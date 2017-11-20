package cs544.jms1.sender;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JMSSenderApp {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"springconfigsender.xml");
		JMSSender jmssender = context.getBean("jmsSender", JMSSender.class);

		jmssender.send(new CalcInstruction('+', 86));
		jmssender.send(new CalcInstruction('-', 2));
		jmssender.send(new CalcInstruction('*', 7));
		jmssender.send(new CalcInstruction('/', 14));
		
		context.close();
	}
}
