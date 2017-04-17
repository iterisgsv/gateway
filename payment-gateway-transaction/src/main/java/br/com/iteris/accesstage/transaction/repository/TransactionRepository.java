package br.com.iteris.accesstage.transaction.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.iteris.accesstage.transaction.entity.Transaction;

public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Long> {
}
