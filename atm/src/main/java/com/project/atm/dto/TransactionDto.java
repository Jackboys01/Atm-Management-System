package com.project.atm.dto;


import com.project.atm.entity.UserAccount;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TransactionDto {
    private Long id;

    private String transactionType;

    private Integer amount;

    private LocalDateTime transactionDate;


    private String sourceAccount;
    private Integer sourceBalance;

    private String destinationAccount;
    private Integer destinationBalance;
}
