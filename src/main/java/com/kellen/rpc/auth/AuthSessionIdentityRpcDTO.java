package com.kellen.rpc.auth;

import java.io.Serializable;

/** 已验证 access token 的最小用户与授权租户快照，不含 token、角色或内部实体。 */
public class AuthSessionIdentityRpcDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userId;
    private String tenantId;
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getTenantId() { return tenantId; }
    public void setTenantId(String tenantId) { this.tenantId = tenantId; }
}
