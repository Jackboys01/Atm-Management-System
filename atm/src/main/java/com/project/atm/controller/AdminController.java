package com.project.atm.controller;

import com.project.atm.dto.BankDto;
import com.project.atm.dto.TransactionDto;
import com.project.atm.dto.UserAccountDto;
import com.project.atm.entity.Bank;
import com.project.atm.entity.Transaction;
import com.project.atm.entity.UserAccount;
import com.project.atm.service.BankService;
import com.project.atm.service.TransactionService;
import com.project.atm.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {


    @Autowired
    UserAccountService userAccountService;
    @Autowired
    TransactionService transactionService;

    @Autowired
    BankService bankService;

    @PostMapping("/createAccount/{id}")
    ResponseEntity<UserAccountDto> createAccount(@RequestBody UserAccount userDetails, @PathVariable Long id)
    {
        return ResponseEntity.ok(userAccountService.createAccount(userDetails,id));
    }

    @GetMapping("/getAccounts/{id}")
    ResponseEntity<BankDto>getAccount(@PathVariable Long id){
        return ResponseEntity.ok(bankService.getAccount(id));
    }

    @PostMapping("/transaction")
    ResponseEntity<TransactionDto> createTransaction(@RequestBody Transaction transaction)
    {
        return ResponseEntity.ok(transactionService.createTransaction(transaction));
    }

    @PostMapping("/banktobank/transcation")
    ResponseEntity<TransactionDto> bankToBankTransaction(@RequestBody Transaction transaction)
    {
         return ResponseEntity.ok(transactionService.bankToBankTransaction(transaction));
    }

    @PutMapping("/update/account/{id}")
    ResponseEntity<UserAccountDto>updateAcccount(@PathVariable Long id, @RequestBody UserAccount userAccount)
    {
        return ResponseEntity.ok(userAccountService.updateAccount(id,userAccount));
    }

    @DeleteMapping("/delete/account/{id}")
    ResponseEntity<String> deleteAccount(@PathVariable  Long id)
    {
        userAccountService.deleteAccount(id);
        return ResponseEntity.ok("SUCCESS");
    }


}
