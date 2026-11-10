# rpc-api

`rpc-api` 是 Java 微服务之间的 Dubbo RPC 契约包，只维护接口、DTO、枚举和值对象。

- Maven 坐标：`com:rpc-api:1.0.8`
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
implementation "com:rpc-api:1.0.8"
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

个人制品保持 `com:rpc-api:1.0.8`，公共能力库使用 `com:utils:1.5.1`；美联对应制品使用 `com.kellen:rpc-api` 和 `com.kellen:utils`。两边共用同一个阿里云 Maven 地址，通过 group 隔离制品路径并独立发布版本。个人消费者必须引用 `com` 坐标，不能混用美联制品；Java package `com.kellen.*` 与 Maven group 无关。发布前检查目标版本是否已存在，已有 release 不重复覆盖。

## AI 编程规范

AI 或人类修改本仓库前先读：

1. `AGENTS.md`
2. `docs/ai-coding/README.md`
3. `docs/ai-coding/RPC_API_CODING_SPEC.md`
4. `docs/ai-coding/VERSIONING_SPEC.md`
5. `docs/ai-coding/BRANCHING_SPEC.md`

开放接口认证提供 `verifyRequiredOpenApiSignature` 严格入口：只接受显式开启签名的客户端，服务端验证 HMAC、时钟和一次性 nonce 后返回 true。消费者必须要求 true，不得回退到保留可选签名语义的 `verifyOpenApiSignature`。升级该能力时 provider/consumer 同步使用 1.0.7。

`1.0.8` 兼容新增 `AuthSessionRpcService.resolveAccessIdentity(String)` 和 `AuthSessionIdentityRpcDTO`，保留此前全部契约。终端 access token 只作为认证中心的验证输入，不记录或回传；输出仅包含已验证 userId/tenantId。provider 在 user，直接 consumer 为 ai / ai-agent；它们必须完成签名、生命周期和有效账号/租户验证，不能从正文或服务 HMAC 断言业务身份。
