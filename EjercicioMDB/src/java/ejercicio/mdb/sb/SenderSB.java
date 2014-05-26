package ejercicio.mdb.sb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

@Stateless
@LocalBean
public class SenderSB {
    
    @Resource(lookup = "ConnectionFactory")
    private ConnectionFactory connectionFactory;
    
    @Resource(lookup = "jms/Queue")
    private Queue queue;

    @Resource(lookup = "jms/Topic")
    private Topic topic;

    public void sendToQueue() {
        
        try {
            
            Connection connection = connectionFactory.createConnection();
            
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            
            MessageProducer producer = session.createProducer(queue);
            
            TextMessage message = session.createTextMessage();
            message.setText("MENSAJE DE PRUEBA!!!");
            producer.send(message);
            
            connection.close();
            
        } catch (Exception ex) {
            Logger.getLogger(SenderSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void sendToTopic() {
        
        try {
            
            Connection connection = connectionFactory.createConnection();
            
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            
            MessageProducer producer = session.createProducer(topic);
            
            TextMessage message = session.createTextMessage();
            message.setText("MENSAJE DE PRUEBA!!!");
            producer.send(message);
            
            connection.close();
            
        } catch (Exception ex) {
            Logger.getLogger(SenderSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}