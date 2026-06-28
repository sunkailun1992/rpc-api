package com.kellen.rpc.auth;

import java.io.Serializable;

/**
 * 外部身份映射 RPC 请求 DTO。
 */
public class ExternalIdentityRpcRequest implements Serializable {

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
     * 主体类型，例如 USER、PATIENT、DOCTOR。
     */
    private String subjectType;

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

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }
}
