package cs544.jms1.receiver;

import cs544.jms1.sender.CalcInstruction;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class MessageCalc implements MessageListener {

    private static int state = 0;

    public synchronized void onMessage(Message message) {
        ObjectMessage objmessage = (ObjectMessage) message;
        try {
            CalcInstruction inst = (CalcInstruction) objmessage.getObject();
            int result = 0;
            switch (inst.getOperator()) {
                case '+':
                    result = state + inst.getNumber();
                    break;
                case '-':
                    result = state - inst.getNumber();
                    break;
                case '*':
                    result = state * inst.getNumber();
                    break;
                case '/':
                    result = state / inst.getNumber();
                    break;
            }
            System.out.println(state + " " + inst.getOperator() + " "
                    + inst.getNumber() + " = " + result);
            state = result;

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
