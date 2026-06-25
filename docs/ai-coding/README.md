# AI 编程规范入口

`rpc-api` 是跨服务 RPC 契约仓库。修改前先确认本次变更是“契约变更”，不是 provider 实现、consumer 调用或运行时配置变更。

## 必读顺序

1. `../../AGENTS.md`
2. `RPC_API_CODING_SPEC.md`
3. `TESTING_SPEC.md`
4. `VERSIONING_SPEC.md`
5. `BRANCHING_SPEC.md`
6. `SECURITY_CODING_SPEC.md`
7. `MIGRATION_SCOPE.md`

## 修改前检查

- 确认接口或 DTO 是否已被 `user`、`message`、`ai`、`ai-agent`、`gateway` 引用。
- 确认是否能用新增字段或新增方法保持兼容，避免直接删除或改类型。
- 确认 provider 和 consumer 是否已同步升级到同一个 `com:rpc-api:<version>`。
- 确认 CI 是否能先发布 `rpc-api` 到 Maven Local，再编译消费者。
- 确认测试符合 `TESTING_SPEC.md`：契约库以单元/兼容测试为主，provider/consumer 真实链路在业务服务验证。

## 完成标准

- `./gradlew clean test publishToMavenLocal` 通过。
- `bash scripts/check-secrets.sh` 通过。
- 直接 provider 和 consumer 编译通过。
- 文档说明了兼容性、版本号和调用方迁移方式。
