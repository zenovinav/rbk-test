package org.github.zenovinav.rbk.server.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    private Long id;

    private Double amount;
}
