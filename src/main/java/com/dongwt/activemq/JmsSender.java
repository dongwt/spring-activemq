package com.dongwt.activemq;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class JmsSender{

    private JmsTemplate jmsTemplate;  
    private Destination destination;  
    private static int i = 0;
  
    public JmsSender(JmsTemplate jmsTemplate, Destination destination) {  
        this.jmsTemplate = jmsTemplate;  
        this.destination = destination;  
    }  
  
    public void sender(){
    	 for(; i<10; i++){
    		 jmsTemplate.send(destination, new MessageCreator() {  
                 // 这里的session 会有工厂自动创建  
                 public Message createMessage(Session session) throws JMSException {  
                     Order order = new Order(i, "name"+i);  
                     // 消息分为很多种,有字符串 字节  对象等，这里我们使用对象  
                     System.out.println("发送条数--------------------------"+i);  
                     return session.createObjectMessage(order);  
                 }  
             }); 
    	 }
    }

}
