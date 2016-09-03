package com.dongwt.activemq;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.jms.Destination;
import javax.jms.JMSException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:/spring.xml")
public class JmsTest {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private Destination queueDestination;

	@Test
	public void sender() {
		JmsSender sender = new JmsSender(jmsTemplate, queueDestination);
		sender.sender();
	}

	@Test
	public void receiver() {
		try {
			JmsReceiver.receiver(queueDestination, jmsTemplate);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
