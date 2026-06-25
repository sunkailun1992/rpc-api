# AGENTS.md

本文件是 `rpc-api` 契约仓库的 AI 编码入口。AI 修改本项目代码前，必须先阅读本文件，再按影响范围阅读 `docs/ai-coding` 下的规范和目标 Java 类。

## 项目定位

- 项目名称：`rpc-api`
- 项目类型：Java 17 / Gradle `java-library` / Maven 契约包
- 发布坐标：`com:rpc-api`
- 当前版本：`1.0.0`
- 主要消费者：同级 `../user`、`../message`、`../ai`、`../ai-agent`、`../gateway`
- 核心风险：RPC 契约破坏消费者、DTO 泄露内部实体字段、接口版本不兼容、把运行时配置或业务实现放进契约包

## 修改前阅读顺序

1. `README.md`：确认契约包定位、构建发布和消费者验证要求。
2. `docs/ai-coding/README.md`：确认 AI 编码入口、修改前检查和文档维护要求。
3. `docs/ai-coding/RPC_API_CODING_SPEC.md`：确认接口、DTO、provider、consumer 和 `utils` 边界。
4. `docs/ai-coding/TESTING_SPEC.md`：确认契约库测试、AssertJ 断言和消费者编译验证边界。
5. `docs/ai-coding/VERSIONING_SPEC.md`：确认版本号、兼容性和消费者同步规则。
6. `docs/ai-coding/BRANCHING_SPEC.md`：确认分支命名、短分支生命周期、release/hotfix、tag 和清理规则。
7. `docs/ai-coding/SECURITY_CODING_SPEC.md`：涉及用户、权限、租户、数据范围、token、上下文或脱敏字段时必须阅读。
8. `docs/ai-coding/MIGRATION_SCOPE.md`：确认从其他项目迁移过来的通用规范范围和不迁移原因。

## 项目边界

- 只放跨服务稳定契约：接口、DTO、枚举、值对象、常量。
- 不放 `@DubboService` provider 实现、`@DubboReference` consumer 调用点、Controller、Mapper、Entity、数据库访问或业务流程。
- 不放 Spring Boot 启动类、不放 `application-*.yml`、不放 Nacos import、不放数据源或注册中心地址。
- 不依赖 `utils`，避免契约层反向依赖公共运行时包。
- `utils` 可以提供 Dubbo 上下文透传过滤器和公共配置，但不得维护业务 RPC 接口。

## 修改门禁

- 新增、删除或改签名 RPC 接口时，必须同步更新 provider、consumer、CI 和 `docs/ai-coding/RPC_API_CODING_SPEC.md`。
- 只要本次任务修改了生产源码或构建脚本，就必须按 `VERSIONING_SPEC.md` 提升一次 `build.gradle` 中的 `version`。
- DTO 字段只能新增兼容字段，不能随意改名、改类型或删除；破坏性变更必须走新接口、新 DTO 或主版本升级。
- 所有跨服务上下文字段优先通过 Dubbo attachment / filter 透传，不写进每个业务方法参数；确实是业务查询条件的字段才进入接口参数。
- 测试分层按 `docs/ai-coding/TESTING_SPEC.md` 执行；本仓库以契约单元/兼容测试为主，不默认启动 Spring Boot。

## 验证命令

```bash
./gradlew clean test publishToMavenLocal
bash scripts/check-secrets.sh
```

main 分支提交并推送远程 Git 仓库时，如果本次变更会被其它机器直接解析，还应使用统一阿里云 Maven 凭据执行：

```bash
./gradlew publish
```

修改契约后，还要至少编译直接受影响的 provider 和 consumer：

```bash
cd ../user && ./gradlew clean compileJava -x test
cd ../message && ./gradlew clean compileJava -x test
```

## 禁止事项

- 禁止提交 Maven 仓库凭证、真实密钥、本机 Gradle 配置、本机绝对路径或发布账号。
- 禁止把业务实体、Mapper、ServiceImpl、Controller 或运行时配置迁入本仓库。
- 禁止在服务项目或 `utils` 中复制 RPC 接口/DTO。
- 禁止为了单个消费者临时兼容而破坏已有稳定契约。
