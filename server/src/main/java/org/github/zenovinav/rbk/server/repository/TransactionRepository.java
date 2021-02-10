package org.github.zenovinav.rbk.server.repository;

import org.github.zenovinav.rbk.server.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
