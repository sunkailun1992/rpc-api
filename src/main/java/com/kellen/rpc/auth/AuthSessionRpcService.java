package com.kellen.rpc.auth;

/** 认证中心的 access token 验证边界；不得以正文租户或 RPC attachment 替代终端身份验证。 */
public interface AuthSessionRpcService {
    /**
     * 验证签名、时效、撤销状态和账号租户授权，返回最小身份快照。
     * @param accessToken 终端 access token；只用于验证，不记录或回传。
     * @return 已验证用户和有效租户；拒绝时抛出不含 token 的固定业务异常。
     */
    AuthSessionIdentityRpcDTO resolveAccessIdentity(String accessToken);
}
