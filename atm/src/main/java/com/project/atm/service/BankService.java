package com.project.atm.service;

import com.project.atm.dto.BankDto;
import com.project.atm.dto.UserAccountDto;
import com.project.atm.entity.Bank;
import com.project.atm.entity.UserAccount;
import com.project.atm.repository.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class BankService {
    @Autowired
    BankRepo bankRepo;
    public BankDto getAccount(Long id) {
        Bank bank = bankRepo.findById(id).get();

        return new BankDto(
                bank.getId(),
                bank.getName(),
                bank.getAccounts().stream()
                        .map(emp->new UserAccountDto(
                                emp.getId(),
                                emp.getAccountNumber(),
                                emp.getBalance(),
                                bank.getName()
                        )).collect(Collectors.toList())
        );

    }
}
