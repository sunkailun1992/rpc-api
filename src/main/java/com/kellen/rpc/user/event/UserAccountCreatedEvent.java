package com.kellen.rpc.user.event;

import java.io.Serializable;
import java.time.Instant;

/**
 * 账号已创建事件：user 在新建账号的事务提交后经 RocketMQ 发出，message 据此发欢迎站内信。
 *
 * <p>只放 ID 与展示用的称呼，不放口令、令牌、权限、手机号等凭据或个人信息；字段只增不删。
 * 消费方按 {@link #getEventId()} 去重。</p>
 */
public class UserAccountCreatedEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 事件 ID，消费方据此去重。
     */
    private String eventId;

    /**
     * 事件发生时刻。
     */
    private Instant occurredAt;

    /**
     * 新账号所属租户 ID。
     */
    private String tenantId;

    /**
     * 新账号的用户 ID。
     */
    private String userId;

    /**
     * 新账号的用户名。
     */
    private String username;

    /**
     * 新账号的昵称，可能为空。
     */
    private String nickname;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Instant getOccurredAt() {
        return occurredAt;
    }

    public void setOccurredAt(Instant occurredAt) {
        this.occurredAt = occurredAt;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
