package com.ensa;

import com.ensa.entities.Client;
import com.ensa.entities.Compte;

public class Main {

    public static void main(String[] args) {
        System.out.println("****** Main ******");
        new Main().start();
    }
    public void start() {
        Compte c1 = new Compte();
        Client client = new Client("Ahmed",c1);
        client.getCp().setSolde(10000);
        client.getCp().getSolde();
        client.verser(9000);
        client.retirer(14000);
        client.getCp().getSolde();
        System.out.println(client.getCp().toString());
    }

}
