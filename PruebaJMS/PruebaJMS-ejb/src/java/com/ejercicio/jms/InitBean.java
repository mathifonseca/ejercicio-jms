package com.ejercicio.jms;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;

@Startup
@Singleton
@LocalBean
public class InitBean {
    
    @EJB
    private ElectricistaBean electricistaBean;

    @PostConstruct
    public void init() {
        
        System.out.println("---------START SYNC--------");

        String trabajoSync = electricistaBean.trabajar();
        
        System.out.println(trabajoSync);
        
        System.out.println("--------END SYNC---------");
        
        System.out.println("--------START ASYNC---------");
        
        String trabajoAsync = electricistaBean.trabajarAsync();
        
        System.out.println(trabajoAsync);
        
        System.out.println("--------END ASYNC---------");

    }
    
}
