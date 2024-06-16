package com.project.atm.service;

import com.project.atm.dto.TransactionDto;
import com.project.atm.entity.Bank;
import com.project.atm.entity.Transaction;
import com.project.atm.entity.UserAccount;
import com.project.atm.repository.BankRepo;
import com.project.atm.repository.TransactionRepo;
import com.project.atm.repository.UserAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TransactionService {
    @Autowired
    BankRepo bankRepo;
    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    UserAccountRepo userAccountRepo;

    public TransactionDto createTransaction(Transaction transaction) {
        Integer amount =  transaction.getAmount();
        UserAccount userAccount = userAccountRepo.findById(transaction.getSourceAccount().getId()).get();

        UserAccount userDestinationAccount = userAccountRepo.findById(transaction.getDestinationAccount().getId()).get();

        Integer destinationBalance = userDestinationAccount.getBalance();

        Integer newDestinationBalance =  destinationBalance + amount;
        Integer balance = userAccount.getBalance();
        Integer newBalance =  balance - amount;

        userDestinationAccount.setBalance(newDestinationBalance);
        userAccount.setBalance(newBalance);
        userAccountRepo.save(userDestinationAccount);
        userAccountRepo.save(userAccount);



          transactionRepo.save(transaction);

          return new TransactionDto(
                  transaction.getId(),
                  transaction.getTransactionType(),
                  transaction.getAmount(),
                  transaction.getTransactionDate(),
                  userAccount.getAccountNumber(),
                  userAccount.getBalance(),
                  userDestinationAccount.getAccountNumber(),
                  userDestinationAccount.getBalance()
          );
    }

    public TransactionDto bankToBankTransaction(Transaction transaction) {
        Long id1 = transaction.getSourceAccount().getId();
        Long id2 = transaction.getDestinationAccount().getId();

        if(!Objects.equals(id1, id2))
        {
            Integer amount =  transaction.getAmount();
            UserAccount userAccount = userAccountRepo.findById(transaction.getSourceAccount().getId()).get();

            UserAccount userDestinationAccount = userAccountRepo.findById(transaction.getDestinationAccount().getId()).get();

            Integer destinationBalance = userDestinationAccount.getBalance();



            Double deduction = amount * 0.10; // Calculate 10% of the amount
            Integer newDestinationBalance = destinationBalance + (int) (amount - deduction); // Deduct 10% from the amount before adding it
            Integer balance = userAccount.getBalance();
            Integer newBalance =  balance - amount;



            userDestinationAccount.setBalance(newDestinationBalance);
            userAccount.setBalance(newBalance);
            userAccountRepo.save(userDestinationAccount);
            userAccountRepo.save(userAccount);



            transactionRepo.save(transaction);

            return new TransactionDto(
                    transaction.getId(),
                    transaction.getTransactionType(),
                    transaction.getAmount(),
                    transaction.getTransactionDate(),
                    userAccount.getAccountNumber(),
                    userAccount.getBalance(),
                    userDestinationAccount.getAccountNumber(),
                    userDestinationAccount.getBalance()
            );

        }
        else return new TransactionDto();
    }
}
