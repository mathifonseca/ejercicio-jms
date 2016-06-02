package com.ejercicio.jms;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

@Stateless
@LocalBean
public class PintorBean {
    
    @EJB
    private MailBean mailBean;

    public String trabajar(String msg) {
        System.out.println("Electricista dice: " + msg);
        System.out.println("Pintor - Tarea1");
        System.out.println("Pintor - Tarea2");
        System.out.println("Pintor - Tarea3");
        System.out.println("Pintor - Tarea4");
        String termino = "Termino Pintor";
        mailBean.enviarMail("mathifonseca@gmail.com", "Pintor", termino);
        return termino;
    }
    
}
