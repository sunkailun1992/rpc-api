package com.kellen.rpc.user;

/**
 * 用户中心 Dubbo RPC 契约。
 *
 * <p>RPC 契约只暴露稳定 DTO，不直接暴露 user 服务内部实体。</p>
 */
public interface UserRpcService {

    /**
     * 按租户和用户 ID 查询用户详情。
     *
     * @param tenantId 租户 ID
     * @param userId   用户 ID
     * @return 用户详情；不存在时返回 null
     */
    UserRpcDTO getUserById(String tenantId, String userId);
}
