package ej.jms.mdb;

import ej.jms.ejb.PintorSB;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/Queue1")
})
public class ReceptorMDB implements MessageListener {
    
    @EJB
    PintorSB pintor;
    
    public ReceptorMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        try {
            
            if (message != null) {

                TextMessage txt = (TextMessage)message;
                
                String contenido = txt.getText();
                
                System.out.println("LLEGO MENSAJE = " + contenido);
                
                pintor.pintar(contenido);

            }
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}
