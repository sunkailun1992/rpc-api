# AI 规范迁移范围

本仓库从现有 Java 微服务规范中迁移“通用且适用于 RPC 契约库”的内容，并剔除运行时服务专属内容。

## 已迁移或新增

- `AGENTS.md`：AI 编码入口和仓库职责边界。
- `README.md`：构建、发布、引用和验证说明。
- `BRANCHING_SPEC.md`：main、feature、fix、release、hotfix 和分支清理规则。
- `VERSIONING_SPEC.md`：`group = 'com'`、`version = '1.0.0'`、补丁/次版本/主版本递增规则。
- `SECURITY_CODING_SPEC.md`：DTO 字段安全、权限边界和上下文安全。
- `RPC_API_CODING_SPEC.md`：契约分层、接口、DTO、provider、consumer、上下文透传规则。
- `scripts/check-secrets.sh`：沿用通用密钥告警扫描脚本。
- `.github/workflows/ci.yml`：沿用 Java 17 编译、测试、发布到 Maven Local 和密钥扫描门禁。

## 未迁移

- `NACOS_CONFIG_SPEC.md`：`rpc-api` 无 Spring Boot 运行时、无配置中心 import、无 dataId，不迁移。
- `ENVIRONMENT_CONFIG_SPEC.md`：`rpc-api` 无 dev/test/prod 运行 profile，不迁移。
- `UTILS_TOOL_CATALOG.md`：这是 `utils` 的工具目录，迁移会混淆公共工具包与契约包边界。
- `PACKAGE_REFACTOR_GUIDE.md`：主要用于 `utils` 包结构治理，`rpc-api` 只保留 `com.kellen.rpc.<domain>` 规则。
- 前端、小程序、Swagger 聚合、网关路由模板：这些属于运行服务和展示层，不属于契约包。

## 后续补充原则

如果未来 `rpc-api` 增加新领域契约，只新增契约相关规范；不要把运行时配置、Nacos 管理、数据库、多数据源、OpenAPI 聚合或前端发布规范塞进本仓库。
