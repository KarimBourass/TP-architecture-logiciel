package com.ensa.aspects;

import com.ensa.entities.Client;

import org.apache.log4j.Logger;

public aspect RetirerAspect {
    private long t1,t2;
    private Logger logger = Logger.getLogger(this.getClass().getName());
    pointcut retirer(double montant): call(* entities.Client.retirer(..)) && args(montant);

    void around(double montant): retirer(montant){
        Client client = (Client) thisJoinPoint.getTarget();
        if(client.getCp().getSolde() > montant) {
            logger.info("proceedd");
            proceed(montant);
        } else {
            throw new RuntimeException("le solde n'est pas suffisant pour terminer l'operation !!!");
        }
    }
    before(): retirer(double){
        Client client = (Client) thisJoinPoint.getTarget();
        logger.info("le solde actuel = "+client.getCp().getSolde());
    }
    after(): retirer(double){
        Client client = (Client) thisJoinPoint.getTarget();
        logger.info("le nouveau solde = "+client.getCp().getSolde());

    }
}
