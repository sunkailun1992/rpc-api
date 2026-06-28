package com.kellen.rpc.auth;

import java.io.Serializable;

/**
 * 外部身份映射 RPC 响应 DTO。
 */
public class ExternalIdentityRpcDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 外部系统编码，例如 partner-system。
     */
    private String providerCode;

    /**
     * 外部租户 ID。
     */
    private String externalTenantId;

    /**
     * 外部用户 ID。
     */
    private String externalUserId;

    /**
     * 外部患者或业务主体 ID。
     */
    private String externalPatientId;

    /**
     * 本系统租户 ID。
     */
    private String localTenantId;

    /**
     * 本系统用户 ID。
     */
    private String localUserId;

    /**
     * 主体类型，例如 USER、PATIENT、DOCTOR。
     */
    private String subjectType;

    /**
     * 展示名称。
     */
    private String displayName;

    /**
     * 映射状态。
     */
    private Integer state;

    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

    public String getExternalTenantId() {
        return externalTenantId;
    }

    public void setExternalTenantId(String externalTenantId) {
        this.externalTenantId = externalTenantId;
    }

    public String getExternalUserId() {
        return externalUserId;
    }

    public void setExternalUserId(String externalUserId) {
        this.externalUserId = externalUserId;
    }

    public String getExternalPatientId() {
        return externalPatientId;
    }

    public void setExternalPatientId(String externalPatientId) {
        this.externalPatientId = externalPatientId;
    }

    public String getLocalTenantId() {
        return localTenantId;
    }

    public void setLocalTenantId(String localTenantId) {
        this.localTenantId = localTenantId;
    }

    public String getLocalUserId() {
        return localUserId;
    }

    public void setLocalUserId(String localUserId) {
        this.localUserId = localUserId;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
