# rpc-api

`rpc-api` 是 Java 微服务之间的 Dubbo RPC 契约包，只维护接口、DTO、枚举和值对象。

- Maven 坐标：`com:rpc-api:2.0.0`
- Java 版本：21
- 主要消费者：`user`、`message`、`ai`、`ai-agent`、`gateway`
- 职责边界：不包含 provider 实现、controller、数据库访问、Spring Boot 启动类、Nacos 配置或业务运行时配置。

## 本地使用

先发布契约包到 Maven Local：

```bash
./gradlew publishToMavenLocal
```

业务服务通过下面的坐标引入：

```gradle
implementation "com:rpc-api:2.0.0"
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

个人制品保持 `com:rpc-api:2.0.0`，公共能力库使用 `com:utils:2.0.0`；美联对应制品使用 `com.kellen:rpc-api` 和 `com.kellen:utils`。两边共用同一个阿里云 Maven 地址，通过 group 隔离制品路径并独立发布版本。个人消费者必须引用 `com` 坐标，不能混用美联制品；Java package `com.kellen.*` 与 Maven group 无关。发布前检查目标版本是否已存在，已有 release 不重复覆盖。

## AI 编程规范

AI 或人类修改本仓库前先读：

1. `AGENTS.md`
2. `docs/ai-coding/README.md`
3. `docs/ai-coding/RPC_API_CODING_SPEC.md`
4. `docs/ai-coding/VERSIONING_SPEC.md`
5. `docs/ai-coding/BRANCHING_SPEC.md`

`1.0.9` 只把编译基线改为 Java 21、Gradle wrapper 升到 9.9.1（第1阶段底座升级），契约与依赖不变；消费者须运行在 Java 21。

`1.1.0` 新增消息事件契约 `com.kellen.rpc.user.event.UserAccountCreatedEvent`（账号已创建：user 在事务提交后经 RocketMQ 发出，message 收到后发欢迎站内信），字段为事件 ID、发生时刻、租户 ID、用户 ID、用户名与昵称；其余契约不变。跨服务的消息事件类放 `com.kellen.rpc.<领域>.event` 包。

`2.0.0`（第5阶段）删除 user 的旧认证契约 `com.kellen.rpc.auth`（`AuthSessionRpcService`、`AuthIdentityRpcService`、`AuthOpenApiRpcService` 及其 DTO）：身份改由 Keycloak 签发，服务间用 OAuth2 客户端凭证或 RFC 8693 令牌交换，不再经 user 校验会话或 HMAC 签名。按请求加载业务上下文的契约 `SecurityContextRpcService` 在 utils 的安全包里（utils 不依赖 rpc-api）。其余契约不变。
