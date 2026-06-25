# 测试分层规范

## 定位

`rpc-api` 是契约库，不是运行时业务服务。测试重点是契约对象、序列化兼容性、接口签名稳定性和消费者编译兼容。

## 主流分层

- 单元测试：DTO、枚举和值对象，使用 JUnit 5 + AssertJ。
- 契约兼容测试：验证 DTO 字段、Serializable、枚举 code 和默认语义。
- 消费者编译测试：修改契约后必须编译直接 provider 和 consumer。

## assertThat 规则

`assertThat` 是断言工具，可以继续使用。它只能说明被断言对象符合预期，不能替代 provider/consumer 的真实集成验证。

## 不适用项

- 默认不使用 `@SpringBootTest`，因为本仓库没有 Spring Boot 应用。
- 默认不连接 Nacos、数据库、Redis、RabbitMQ 或真实 Dubbo 注册中心。
- 不在本仓库测试 provider 实现或 consumer 调用逻辑。

## 必跑命令

```bash
./gradlew clean test publishToMavenLocal
```

修改契约后，至少同步编译直接 provider 和 consumer。
