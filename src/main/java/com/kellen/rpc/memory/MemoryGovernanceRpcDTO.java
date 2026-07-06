package com.kellen.rpc.memory;

import java.io.Serializable;

/**
 * AI 记忆治理 RPC 响应。
 */
public class MemoryGovernanceRpcDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean success;

    private Integer affectedCount;

    private String eventId;

    private String taskId;

    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getAffectedCount() {
        return affectedCount;
    }

    public void setAffectedCount(Integer affectedCount) {
        this.affectedCount = affectedCount;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
