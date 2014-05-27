package ejercicio.mdb.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "jms/Queue", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class QueueMDB1 implements MessageListener {
    
    public QueueMDB1() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        try {
            
            if (message != null) {

                TextMessage txt = (TextMessage)message;
                
                String contenido = txt.getText();
                
                System.out.println("LLEGO EN QUEUE POR MDB1!!!");
                
                System.out.println("CONTENIDO = " + contenido);

            }
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}
