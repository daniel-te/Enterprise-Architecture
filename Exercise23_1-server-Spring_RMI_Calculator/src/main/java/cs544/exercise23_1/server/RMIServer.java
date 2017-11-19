package cs544.exercise23_1.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RMIServer {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"springconfigserver.xml");
		System.out.println("Server is running ... ");
	}
}
