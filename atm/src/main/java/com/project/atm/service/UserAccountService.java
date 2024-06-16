package com.project.atm.service;


import com.project.atm.dto.UserAccountDto;
import com.project.atm.entity.Bank;
import com.project.atm.entity.User;
import com.project.atm.entity.UserAccount;
import com.project.atm.repository.BankRepo;
import com.project.atm.repository.UserAccountRepo;
import com.project.atm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserAccountService {

    @Autowired
     public UserAccountRepo userAccountRepo;
    @Autowired
    public BankRepo bankRepo;

    @Autowired
    public UserRepository userRepository;

    public UserAccountDto createAccount(UserAccount userDetails,Long id) {
        userDetails.setBank(bankRepo.findById(id).get());
        userAccountRepo.save(userDetails);

        User user = new User();
        user.setRole("admin");
        user.setUsername("daksh");
        user.setPassword(userDetails.getPin());

        userRepository.save(user);

        return new UserAccountDto(
                userDetails.getId(),
                userDetails.getAccountNumber(),
                userDetails.getBalance(),
                bankRepo.findById(id).get().getName()
        );
    }

    public UserAccountDto updateAccount(Long id,UserAccount userAccount) {
         UserAccount userAccount1 = userAccountRepo.findById(id).get();

        if(Objects.nonNull(userAccount.getPin()) &&  !"".equalsIgnoreCase(userAccount.getPin()))
        {
            userAccount1.setPin(userAccount.getPin());
        }

        userAccountRepo.save(userAccount1);
        return new UserAccountDto(
                userAccount.getId(),
                userAccount.getAccountNumber(),
                userAccount.getBalance(),
                userAccount.getBank().getName()
        );
    }

    public void deleteAccount(Long id) {
         userAccountRepo.deleteById(id);
    }
}
