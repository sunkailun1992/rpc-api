package com.kellen.rpc.memory;

import java.io.Serializable;

/**
 * AI 记忆召回 RPC 请求。
 */
public class MemoryRetrievalRpcRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String caller;

    private String purpose;

    private String traceId;

    private String userId;

    private String tenantId;

    private String sourceTenantId;

    private String patientId;

    private String conversationId;

    private String query;

    private Integer maxItems;

    private Integer maxTokens;

    private Boolean includeArchived;

    private Boolean allowSensitive;

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getSourceTenantId() {
        return sourceTenantId;
    }

    public void setSourceTenantId(String sourceTenantId) {
        this.sourceTenantId = sourceTenantId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getMaxItems() {
        return maxItems;
    }

    public void setMaxItems(Integer maxItems) {
        this.maxItems = maxItems;
    }

    public Integer getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
    }

    public Boolean getIncludeArchived() {
        return includeArchived;
    }

    public void setIncludeArchived(Boolean includeArchived) {
        this.includeArchived = includeArchived;
    }

    public Boolean getAllowSensitive() {
        return allowSensitive;
    }

    public void setAllowSensitive(Boolean allowSensitive) {
        this.allowSensitive = allowSensitive;
    }
}
