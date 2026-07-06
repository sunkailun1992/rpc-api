package com.kellen.rpc.memory;

/**
 * AI 记忆召回 RPC 契约。
 */
public interface MemoryRetrievalRpcService {

    /**
     * 按患者、来源租户、会话和用途召回可注入模型的上下文。
     *
     * @param request 召回请求
     * @return 召回结果
     */
    MemoryRetrievalRpcDTO retrieve(MemoryRetrievalRpcRequest request);
}
