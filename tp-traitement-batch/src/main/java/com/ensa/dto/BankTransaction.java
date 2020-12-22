package com.ensa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class BankTransaction {

    @Id
    private Long id;
    private long idCompte;
    private double montant;
    private Date dateTransaction;
    @Transient // ne vas pas etre stocké dans la BD
    private String strDateTransaction;
}
