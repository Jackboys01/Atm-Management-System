package com.project.atm.entity;


import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;
    private String pin;
    private Integer balance;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @OneToMany(mappedBy = "sourceAccount" ,  cascade = CascadeType.ALL)
    private List<Transaction> sourceTransactions;

    @OneToMany(mappedBy = "destinationAccount" , cascade = CascadeType.ALL)
    private List<Transaction>destinationTransaction;
}