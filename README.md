# rpc-api

`rpc-api` 是 Java 微服务之间的 Dubbo RPC 契约包，只维护接口、DTO、枚举和值对象。

- Maven 坐标：`com:rpc-api:1.0.0`
- Java 版本：17
- 主要消费者：`user`、`message`、`ai`、`ai-agent`、`gateway`
- 职责边界：不包含 provider 实现、controller、数据库访问、Spring Boot 启动类、Nacos 配置或业务运行时配置。

## 本地使用

先发布契约包到 Maven Local：

```bash
./gradlew publishToMavenLocal
```

业务服务通过下面的坐标引入：

```gradle
implementation "com:rpc-api:1.0.0"
```

## 契约归属

- RPC 接口和跨服务 DTO 统一放在 `src/main/java/com/kellen/rpc/**`。
- `utils` 只保留 Dubbo 上下文透传、通用配置、通用工具和中间件适配，不放业务 RPC 接口。
- `user`、`message`、`ai`、`ai-agent` 等服务只实现或调用接口，不复制接口定义。

## 验证

```bash
./gradlew clean test publishToMavenLocal
bash scripts/check-secrets.sh
```

需要发布远程私有 Maven 制品时，使用项目统一的阿里云 Maven 凭据执行：

```bash
./gradlew publish
```

## AI 编程规范

AI 或人类修改本仓库前先读：

1. `AGENTS.md`
2. `docs/ai-coding/README.md`
3. `docs/ai-coding/RPC_API_CODING_SPEC.md`
4. `docs/ai-coding/VERSIONING_SPEC.md`
5. `docs/ai-coding/BRANCHING_SPEC.md`
