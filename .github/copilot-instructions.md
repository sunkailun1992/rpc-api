# GitHub Copilot Instructions

This repository is the `rpc-api` Java RPC contract library. Before suggesting or changing code, read `AGENTS.md` and `docs/ai-coding/README.md`.

Follow these project rules:

- Keep RPC contracts under `src/main/java/com/kellen/rpc`.
- Do not add Spring Boot application classes, database access, Nacos configuration, business implementations, or controller code to this repository.
- Provider services implement interfaces from this repository with `@DubboService`; consumer services reference them with `@DubboReference`.
- Do not place RPC interfaces or DTOs in `utils` or duplicate them in service repositories.
- Do not change existing secret values or add credentials. Report file paths and line numbers only.
