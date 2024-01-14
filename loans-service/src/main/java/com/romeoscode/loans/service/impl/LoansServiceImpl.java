package com.romeoscode.loans.service.impl;

import com.romeoscode.loans.domain.Loans;
import com.romeoscode.loans.dto.LoansDto;
import com.romeoscode.loans.exception.LoanAlreadyExistsException;
import com.romeoscode.loans.exception.ResourceNotFoundException;
import com.romeoscode.loans.mapper.LoansMapper;
import com.romeoscode.loans.persistence.LoansRepository;
import com.romeoscode.loans.service.ILoansService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import static com.romeoscode.loans.constants.LoansConstants.*;
import static com.romeoscode.loans.constants.LoansConstants.NEW_LOAN_LIMIT;
import static com.romeoscode.loans.mapper.LoansMapper.mapToLoans;
import static com.romeoscode.loans.mapper.LoansMapper.mapToLoansDto;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

/**
 * @author romeo.jerenyama
 * @created 06/01/2024 - 15:17
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LoansServiceImpl implements ILoansService {

    private final LoansRepository loansRepository;

    /**
     * @param mobileNumber - Mobile Number of the Customer
     */
    @Override
    public void createLoan(String mobileNumber) {
        requireNonNull(mobileNumber, "Mobile number cannot be null");
        Optional<Loans> optionalLoans= loansRepository.findByMobileNumber(mobileNumber);
        if(optionalLoans.isPresent()){
            throw new LoanAlreadyExistsException(
                    format("Loan already registered with given mobileNumber :: %s", mobileNumber)
            );
        }
        log.info("Creating loan for mobileNumber :: {}", mobileNumber);
        loansRepository.save(createNewLoan(mobileNumber));
    }

    /**
     * @param mobileNumber - Mobile Number of the Customer
     * @return the new loan details
     */
    private Loans createNewLoan(String mobileNumber) {
        Loans newLoan = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(HOME_LOAN);
        newLoan.setTotalLoan(NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(NEW_LOAN_LIMIT);
        return newLoan;
    }

    /**
     *
     * @param mobileNumber - Input mobile Number
     * @return Loan Details based on a given mobileNumber
     */
    @Override
    public LoansDto fetchLoan(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        return mapToLoansDto(loans, new LoansDto());
    }

    /**
     *
     * @param loansDto - LoansDto Object
     * @return boolean indicating if the update of loan details is successful or not
     */
    @Override
    public boolean updateLoan(LoansDto loansDto) {
        Loans loans = loansRepository.findByLoanNumber(loansDto.getLoanNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "LoanNumber", loansDto.getLoanNumber()));
        mapToLoans(loansDto, loans);
        loansRepository.save(loans);
        return  true;
    }

    /**
     * @param mobileNumber - Input MobileNumber
     * @return boolean indicating if the delete of loan details is successful or not
     */
    @Override
    public boolean deleteLoan(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        loansRepository.deleteById(loans.getLoanId());
        return true;
    }
}
