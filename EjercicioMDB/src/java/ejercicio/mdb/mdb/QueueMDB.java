package ejercicio.mdb.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/Queue", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class QueueMDB implements MessageListener {
    
    public QueueMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        System.out.println("LLEGO QUEUE!!!");
    }
    
}
