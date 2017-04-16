package br.com.iteris.accesstage.transaction.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

import br.com.iteris.accesstage.model.transaction.response.TransactionResponse;

@Entity
//@IdClass(PrimaryKey.class)
public class Transaction implements Serializable {
    private static final long serialVersionUID = 1893503007939053253L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private TransactionResponse info;

    public Transaction() { }

    public Transaction(TransactionResponse info) {
        this.info = info;
    }
}
