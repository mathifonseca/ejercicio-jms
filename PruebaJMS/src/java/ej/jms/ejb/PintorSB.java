package ej.jms.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

@Stateless
@LocalBean
public class PintorSB {
    
    public void pintar(String auto) {
        System.out.println("ESTOY PINTANDO EL AUTO: " + auto);
    }

}
