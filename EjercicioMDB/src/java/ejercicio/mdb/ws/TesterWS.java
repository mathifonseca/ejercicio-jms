package ejercicio.mdb.ws;

import ejercicio.mdb.sb.SenderSB;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;

@WebService(serviceName = "TesterWS")
@Stateless()
public class TesterWS {
    
    @EJB
    private SenderSB ejbRef;

    @WebMethod(operationName = "sendToQueue")
    @Oneway
    public void sendToQueue() {
        ejbRef.sendToQueue();
    }

    @WebMethod(operationName = "sendToTopic")
    @Oneway
    public void sendToTopic() {
        ejbRef.sendToTopic();
    }
    
}