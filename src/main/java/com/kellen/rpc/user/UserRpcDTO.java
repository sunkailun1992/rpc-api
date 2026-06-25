package com.kellen.rpc.user;

import java.io.Serializable;

/**
 * 用户 RPC 响应 DTO。
 */
public class UserRpcDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键。
     */
    private String id;

    /**
     * 租户 ID。
     */
    private String tenantId;

    /**
     * 用户名。
     */
    private String username;

    /**
     * 用户昵称。
     */
    private String nickname;

    /**
     * 管理员分类。
     */
    private String adminType;

    /**
     * 管理员分类说明。
     */
    private String adminTypeDesc;

    /**
     * 所属部门 ID。
     */
    private String deptId;

    /**
     * 用户状态。
     */
    private Integer state;

    /**
     * 用户状态说明。
     */
    private String stateDesc;

    /**
     * 乐观锁版本号。
     */
    private Integer version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
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

    public String getAdminType() {
        return adminType;
    }

    public void setAdminType(String adminType) {
        this.adminType = adminType;
    }

    public String getAdminTypeDesc() {
        return adminTypeDesc;
    }

    public void setAdminTypeDesc(String adminTypeDesc) {
        this.adminTypeDesc = adminTypeDesc;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStateDesc() {
        return stateDesc;
    }

    public void setStateDesc(String stateDesc) {
        this.stateDesc = stateDesc;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
