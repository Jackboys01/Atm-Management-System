package com.project.atm.dto;

import com.project.atm.entity.Bank;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserAccountDto {
    private Long id;
    private String accountNumber;

    private Integer balance;

    private String bankName;
}
