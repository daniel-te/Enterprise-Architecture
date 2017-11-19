package cs544.exercise23_1.client;

import cs544.exercise23_1.server.ICalculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RMIClient_noStopWatch {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"springconfigclient.xml");
		ICalculator remoteServer = context.getBean("calcServer", ICalculator.class);
		int result = remoteServer.calc('+', 10);
		System.out.println("sending + 10    receiving result: " + result);
		result = remoteServer.calc('+', 2);
		System.out.println("sending + 2    receiving result: " + result);
		result = remoteServer.calc('-', 3);
		System.out.println("sending - 3    receiving result: " + result);
		result = remoteServer.calc('*', 4);
		System.out.println("sending * 4    receiving result: " + result);
		result = remoteServer.calc('*', 5);
		System.out.println("sending * 5    receiving result: " + result);
		result = remoteServer.calc('/', 6);
		System.out.println("sending / 6    receiving result: " + result);
	}

}
