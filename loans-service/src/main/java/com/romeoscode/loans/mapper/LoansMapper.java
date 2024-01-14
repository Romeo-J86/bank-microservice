package com.romeoscode.loans.mapper;

import com.romeoscode.loans.domain.Loans;
import com.romeoscode.loans.dto.LoansDto;

/**
 * @author romeo.jerenyama
 * @created 06/01/2024 - 15:04
 */
public class LoansMapper {

    public static LoansDto mapToLoansDto(Loans loans, LoansDto loansDto) {
        loansDto.setLoanType(loans.getLoanType());
        loansDto.setLoanNumber(loans.getLoanNumber());
        loansDto.setMobileNumber(loans.getMobileNumber());
        loansDto.setTotalLoan(loans.getTotalLoan());
        loansDto.setAmountPaid(loans.getAmountPaid());
        loansDto.setOutstandingAmount(loans.getOutstandingAmount());
        return loansDto;
    }

    public static Loans mapToLoans(LoansDto loansDto, Loans loans) {
        loans.setLoanNumber(loansDto.getLoanNumber());
        loans.setLoanType(loansDto.getLoanType());
        loans.setMobileNumber(loansDto.getMobileNumber());
        loans.setTotalLoan(loansDto.getTotalLoan());
        loans.setAmountPaid(loansDto.getAmountPaid());
        loans.setOutstandingAmount(loansDto.getOutstandingAmount());
        return loans;
    }

}
