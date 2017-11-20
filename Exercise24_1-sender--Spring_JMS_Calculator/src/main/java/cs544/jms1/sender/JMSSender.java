package cs544.jms1.sender;

import javax.jms.*;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class JMSSender {
	private JmsTemplate jmsTemplate;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void send(final CalcInstruction instruction) {
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(instruction);
			}
		});
		System.out.println("Sending message with calcInstruction object : "
				+ instruction.getOperator() + " " + instruction.getNumber());
	}
}
