package com.kellen.rpc.auth;

/**
 * 统一认证中心 Dubbo RPC 契约。
 *
 * <p>用于业务系统把外部身份映射到本系统用户，不暴露 user 服务内部实体。</p>
 */
public interface AuthIdentityRpcService {

    /**
     * 解析外部身份映射。
     *
     * @param request 外部身份查询条件
     * @return 身份映射；不存在时返回 null
     */
    ExternalIdentityRpcDTO resolveExternalIdentity(ExternalIdentityRpcRequest request);
}
