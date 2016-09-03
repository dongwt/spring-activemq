package com.dongwt.activemq;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import org.springframework.jms.core.JmsTemplate;

public class JmsReceiver {
	
	public static void receiver(Destination destination,JmsTemplate jmsTemplate) throws JMSException{
	        int i = 0;  
	        ObjectMessage message = null;  
	        // 这里写个循环，一直接受消息到结束  
	        while ( (message = (ObjectMessage)jmsTemplate.receive(destination)) != null){  
	            System.out.println("收到消息条数:"+i++  +" "+message.getObject());
	        }  
	}

}
