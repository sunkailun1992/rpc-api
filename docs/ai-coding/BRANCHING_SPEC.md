# 分支管理规范

## 长期分支

- `main`：唯一长期主干，保持可构建、可测试、可发布。
- `release/x.y.z`：只在准备发布、联调或灰度冻结时创建，发布后合并回 `main` 并删除。
- `hotfix/x.y.z-description`：只用于线上紧急修复，完成后合并回 `main` 和相关 release 分支并删除。

## 短期分支

- `feature/<scope>-<summary>`：新增兼容契约或文档，例如 `feature/user-rpc-contract`。
- `fix/<scope>-<summary>`：修复契约、构建或 CI，例如 `fix/rpc-api-ci`。
- `chore/<scope>-<summary>`：依赖、文档、脚本、规范调整，例如 `chore/update-versioning-spec`。

## 生命周期

- 短期分支只服务一个明确目标，合并后立即删除本地和远程分支。
- 不在长期分支上堆积多个未完成主题。
- 不用个人姓名、日期流水或含糊命名作为分支名。
- main 上的每次提交都要能通过本仓库 CI。

## 环境区分

代码分支不代表环境。dev/test/prod 由服务项目的运行 profile、Nacos 地址和 namespace 区分；`rpc-api` 自身不持有环境配置。
