package br.com.iteris.accesstage.transaction.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.iteris.accesstage.model.transaction.response.TransactionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class TransactionRepository {

    private final ObjectMapper mapper;

    @Autowired
    public TransactionRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public void save(TransactionResponse response) {
        try {
            System.out.println(mapper.writeValueAsString(response));
        } catch (JsonProcessingException e) {
            System.out.println("Erro ao escrever valor");
        }
    }
}
