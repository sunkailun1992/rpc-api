package com.kellen.rpc.rag;

/**
 * RAG 知识检索 Dubbo RPC 契约。
 */
public interface RagRetrievalRpcService {

    /**
     * 按用户问题检索可传给 Agent 的知识上下文。
     *
     * @param request RAG 检索请求
     * @return 检索结果；未启用、未命中或资料不足时返回空上下文
     */
    RagRetrievalRpcDTO retrieve(RagRetrievalRpcRequest request);
}
