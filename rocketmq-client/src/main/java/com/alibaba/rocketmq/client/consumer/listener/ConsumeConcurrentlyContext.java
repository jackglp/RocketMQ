/**
 * $Id: ConsumeConcurrentlyContext.java 1831 2013-05-16 01:39:51Z shijia.wxr $
 */
package com.alibaba.rocketmq.client.consumer.listener;

import com.alibaba.rocketmq.common.message.MessageQueue;


/**
 * 消费消息上下文，同一队列的消息会并行消费，消息无顺序性
 * 
 * @author shijia.wxr<vintage.wang@gmail.com>
 */
public class ConsumeConcurrentlyContext {
    /**
     * 要消费的消息属于哪个队列
     */
    private final MessageQueue messageQueue;
    /**
     * 下次消息重试延时时间<br>
     * -1，表示不重试，直接进入死信队列<br>
     * 0，表示由服务器根据重试次数自动叠加<br>
     * >0，表示客户端强制指定延时Level
     */
    private int delayLevelWhenNextConsume = 0;
    /**
     * 对于批量消费，ack至哪条消息，默认全部ack，至最后一条消息
     */
    private int ackIndex = Integer.MAX_VALUE;


    public ConsumeConcurrentlyContext(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }


    public int getDelayLevelWhenNextConsume() {
        return delayLevelWhenNextConsume;
    }


    public void setDelayLevelWhenNextConsume(int delayLevelWhenNextConsume) {
        this.delayLevelWhenNextConsume = delayLevelWhenNextConsume;
    }


    public MessageQueue getMessageQueue() {
        return messageQueue;
    }


    public int getAckIndex() {
        return ackIndex;
    }


    public void setAckIndex(int ackIndex) {
        this.ackIndex = ackIndex;
    }
}
