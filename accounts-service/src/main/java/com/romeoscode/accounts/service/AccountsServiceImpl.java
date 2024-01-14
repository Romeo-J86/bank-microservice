package com.romeoscode.accounts.service;

import com.romeoscode.accounts.domain.Accounts;
import com.romeoscode.accounts.domain.Customer;
import com.romeoscode.accounts.dto.CustomerDto;
import com.romeoscode.accounts.exception.CustomerAlreadyExistException;
import com.romeoscode.accounts.exception.ResourceNotFoundException;
import com.romeoscode.accounts.persistence.AccountsRepository;
import com.romeoscode.accounts.persistence.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

import static com.romeoscode.accounts.constants.Constants.AccountType.SAVINGS_ACCOUNT;
import static com.romeoscode.accounts.mapper.EntityMapper.*;
import static java.lang.String.format;
import static java.lang.String.valueOf;
import static java.util.Objects.requireNonNull;

/**
 * @author romeo.jerenyama
 * @created 03/01/2024 - 00:33
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private final CustomerRepository customerRepository;
    private final AccountsRepository accountsRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        requireNonNull(customerDto, "CustomerDto cannot be null");

        if (customerRepository.existsByMobileNumber(customerDto.getMobileNumber())){
            throw new CustomerAlreadyExistException(
                    format("Customer already registered with given mobileNumber:: %s",
                            customerDto.getMobileNumber())
            );
        }
        log.info("Creating account......!");
        var customer = Customer.builder()
                .name(customerDto.getName())
                .email(customerDto.getEmail())
                .mobileNumber(customerDto.getMobileNumber())
                .build();
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Default");

        var savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));

    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        var customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber",
                        mobileNumber));

        var accounts = accountsRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Account", "customerId",
                        valueOf(customer.getCustomerId())));


        var customerDto = buildCustomerDto(customer);
        customerDto.setAccountsDto(buildAccountsDto(accounts));

        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated = false;
        var accountsDto = customerDto.getAccountsDto();

        if (Objects.nonNull(accountsDto)){
            var accounts = accountsRepository.findById(accountsDto.getAccountNumber())
                    .orElseThrow(() -> new ResourceNotFoundException("Account", "accountNumber",
                            valueOf(accountsDto.getAccountNumber())));

            mapToAccounts(accountsDto, accounts);
            accounts = accountsRepository.save(accounts);

            Long customerId = accounts.getCustomerId();
            var customer = customerRepository.findById(accounts.getCustomerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Customer", "customerId",
                            valueOf(customerId)));

            mapToCustomer(customerDto, customer);
            customerRepository.save(customer);
            isUpdated = true;
        }
        return isUpdated;
    }

    private Accounts createNewAccount(Customer customer){

        var accounts = new Accounts();
        long accountNumber = 1000000000L + new Random().nextInt(900000000);
        accounts.setAccountNumber(accountNumber);
        accounts.setCustomerId(customer.getCustomerId());
        accounts.setAccountType(SAVINGS_ACCOUNT);
        accounts.setBranchAddress("102 Pop Street Alabama");
        accounts.setCreatedAt(LocalDateTime.now());
        accounts.setCreatedBy("Default");
        return accounts;
    }
}
