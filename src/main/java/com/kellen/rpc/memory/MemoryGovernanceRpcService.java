package com.kellen.rpc.memory;

/**
 * AI 记忆治理 RPC 契约。
 */
public interface MemoryGovernanceRpcService {

    /**
     * 删除、归档、脱敏或撤销记忆。
     *
     * @param request 治理请求
     * @return 治理结果
     */
    MemoryGovernanceRpcDTO govern(MemoryGovernanceRpcRequest request);

    /**
     * 创建 Qdrant 派生索引重建任务。
     *
     * @param request 重建请求
     * @return 任务创建结果
     */
    MemoryGovernanceRpcDTO rebuildVectorIndex(MemoryVectorRebuildRpcRequest request);
}
