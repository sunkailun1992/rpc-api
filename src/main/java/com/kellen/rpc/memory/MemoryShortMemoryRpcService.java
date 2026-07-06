package com.kellen.rpc.memory;

/**
 * AI 短期会话记忆 RPC 契约。
 */
public interface MemoryShortMemoryRpcService {

    /**
     * 追加一条短期会话消息。
     *
     * @param request 短期记忆消息
     * @return 写入结果
     */
    MemoryWriteRpcDTO appendMessage(MemoryShortMessageRpcRequest request);

    /**
     * 合并或覆盖会话滚动摘要。
     *
     * @param request 摘要请求
     * @return 写入结果
     */
    MemoryWriteRpcDTO upsertSummary(MemoryShortSummaryRpcRequest request);
}
