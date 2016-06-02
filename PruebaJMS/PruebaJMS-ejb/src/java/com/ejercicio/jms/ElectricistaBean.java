package com.ejercicio.jms;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

@Stateless
@LocalBean
public class ElectricistaBean {
    
    @Resource(lookup = "jms/ConnectionFactory")
    private ConnectionFactory connectionFactory;
    
    @Resource(lookup = "jms/Queue")
    private Queue queue;
    
    @EJB
    private PintorBean pintorBean;

    public String trabajar() {
        
        System.out.println("Electricista - Tarea1");
        System.out.println("Electricista - Tarea2");
        System.out.println("Electricista - Tarea3");
        System.out.println("Electricista - Tarea4");
        
        String resultadoPintor = pintorBean.trabajar("COMENZAR TRABAJO");
        
        System.out.println("Electricista - Tarea5");
        System.out.println("Electricista - Tarea6");
        
        return resultadoPintor + " y Termino Electricista";
    }
    
    public String trabajarAsync() {
        
        System.out.println("Electricista - Tarea1");
        System.out.println("Electricista - Tarea2");
        System.out.println("Electricista - Tarea3");
        System.out.println("Electricista - Tarea4");
        
        enviarMensajePintor();
        
        System.out.println("Electricista - Tarea5");
        System.out.println("Electricista - Tarea6");
        
        return "Termino Electricista";
    }

    private void enviarMensajePintor() {
        
        try {
            
            Connection connection = connectionFactory.createConnection();
            
            Session session = connection.createSession();
            
            MessageProducer producer = session.createProducer(queue);
            
            Message message = session.createTextMessage("COMENZAR TRABAJO");
            
            producer.send(message);
            
            session.close();
            
            connection.close();
            
        } catch (JMSException ex) {
            Logger.getLogger(ElectricistaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
