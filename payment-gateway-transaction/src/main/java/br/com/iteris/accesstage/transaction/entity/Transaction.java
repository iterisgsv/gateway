package br.com.iteris.accesstage.transaction.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

import br.com.iteris.accesstage.model.transaction.response.TransactionResponse;

/**
 * Entidade JPA que armazena os dados da transação recém efetivada.
 *
 * @author iterisgsv
 */
@Entity
public class Transaction implements Serializable {
    private static final long serialVersionUID = 1893503007939053253L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private TransactionResponse info;

    /**
     * Construtor padrão necessário ao JPA.
     */
    public Transaction() { }

    /**
     * Construtor usado pela aplicação.
     *
     * @param info
     *      Dados da transação
     */
    public Transaction(TransactionResponse info) {
        this.info = info;
    }
}
