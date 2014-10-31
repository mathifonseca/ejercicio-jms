package ej.jms.ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

@Stateless
@LocalBean
public class MecanicoSB {
    
    @Resource(lookup = "jms/ConnectionFactory")
    private ConnectionFactory connectionFactory;
    
    @Resource(lookup = "jms/Queue1")
    private Queue queue;
    
    public void armarMotor(String auto) {
        
        System.out.println("ESTOY ARMANDO EL MOTOR DEL AUTO: " + auto);
        
        notificarPintor(auto);
        
        //
        
    }
    
    private void notificarPintor(String auto) {
        
        try {
            
            Connection connection = connectionFactory.createConnection();
            
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            
            MessageProducer producer = session.createProducer(queue);
            
            TextMessage message = session.createTextMessage();
            
            message.setText(auto);
            
            producer.send(message);
            
            session.close();
            
            connection.close();
            
        } catch (JMSException ex) {
            Logger.getLogger(MecanicoSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
