package cs544.exercise13_1;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class EmailAdvice {
	
	@Around("execution(* cs544.exercise13_1.CustomerDAO.*(..))")
	public Object invoke(ProceedingJoinPoint call ) throws Throwable {
		 StopWatch sw = new StopWatch();
		 sw.start(call.getSignature().getName());
		 Object retVal = call.proceed();
		 sw.stop();

		long totaltime = sw.getLastTaskTimeMillis();
		// print the time to the console
		System.out.println("Time to execute save = " +totaltime + "ms");

		return retVal;
		}
	
	@After("execution(* cs544.exercise13_1.EmailSender.*(..))")
	public void traceaftermethod(JoinPoint joinpoint) {
		Object[] args = joinpoint.getArgs();
		String email = (String)args[0];
		String message = (String)args[1];
		
		System.out.println(new Date() +" method = " + joinpoint.getSignature().getName() +  " address= "+email + " message= "+ message +
				"\n "+((EmailSender)joinpoint.getTarget()).getOutgoingMailServer());
	}
	
	
}
