package com.project.atm.dto;

import com.project.atm.entity.UserAccount;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BankDto {
    private Long id;
    private String name;

    private List<UserAccountDto> accounts;

}
