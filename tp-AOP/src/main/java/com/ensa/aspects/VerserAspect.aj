package com.ensa.aspects;


import com.ensa.entities.Client;

import java.util.logging.Logger;


public aspect VerserAspect {
    private long t1,t2;
    private Logger logger = Logger.getLogger(this.getClass().getName());
    pointcut verser(): call(* entities.Client.verser(..));
    //pointcut log(): initialization(*.Compte.new(..));

    before():verser(){
        logger.info("Avant l'éxecution de la méthode "+thisJoinPoint.getSignature());
        t1 = System.currentTimeMillis();
        Client client =(Client) thisJoinPoint.getTarget();
        //System.out.println("Client *************************** "+thisJoinPoint.getTarget());
        logger.info("Le client : "+client.getNom()+" a effectué cette operation");
        logger.info("Le solde avant l'operation = " +client.getCp().getSolde());
    }
    after():verser(){
        //logger.info("Après l'éxecution de la méthode "+thisJoinPoint.getSignature());
        Client client =(Client) thisJoinPoint.getTarget();
        logger.info("Le nouveau solde = " +client.getCp().getSolde());
        t2 = System.currentTimeMillis();
        logger.info("durée d'execution = "+(t2-t1));

    }
}


