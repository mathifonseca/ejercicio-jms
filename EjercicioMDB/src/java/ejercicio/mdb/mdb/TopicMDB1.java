package ejercicio.mdb.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/Topic", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "TopicMDB1"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "TopicMDB1")
})
public class TopicMDB1 implements MessageListener {
    
    public TopicMDB1() {
    }
    
    @Override
    public void onMessage(Message message) {
        System.out.println("LLEGO A TOPIC POR MDB1!!!");
    }
    
}