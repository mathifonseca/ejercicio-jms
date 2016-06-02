package com.ejercicio.jms;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.mail.*;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/Queue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class PintorMDB implements MessageListener {
    
    @EJB
    private PintorBean pintorBean;

    public PintorMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        try {
            
            TextMessage txt = (TextMessage) message;
            
            String msg = txt.getText();
            
            pintorBean.trabajar(msg);
            
        } catch (JMSException ex) {
            Logger.getLogger(PintorMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
