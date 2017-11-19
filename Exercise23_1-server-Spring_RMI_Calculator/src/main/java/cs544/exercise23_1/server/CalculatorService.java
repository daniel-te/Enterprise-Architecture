package cs544.exercise23_1.server;

public class CalculatorService implements ICalculator{
	private int value=0;
    public synchronized int calc(char operator, int number) {
    	if (operator == '+')
    	       value=value+number;
       	if (operator == '-')
 	       value=value-number;
       	if (operator == '*')
 	       value=value*number;
       	if (operator == '/')
 	       value=value/number;
        return value;
    }
}