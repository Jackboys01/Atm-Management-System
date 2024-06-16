package com.project.atm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionType;

    private Integer amount;

    private LocalDateTime transactionDate;

    @ManyToOne
    @JoinColumn(name = "source_account_id")
    private UserAccount sourceAccount;

    @ManyToOne
    @JoinColumn(name = "destination_account_id")
    private UserAccount destinationAccount;

}
