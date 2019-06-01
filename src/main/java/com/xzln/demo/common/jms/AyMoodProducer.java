package com.xzln.demo.common.jms;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;


@Service("producer")
public class AyMoodProducer {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     *   发送消息，destination是发送到的队列，message是待发送的消息
     */
    public void sendMessage(Destination destination, final String message){
        jmsMessagingTemplate.convertAndSend(message, destination);
    }
}
