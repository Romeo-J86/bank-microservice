package com.romeoscode.loans.persistence;

import com.romeoscode.loans.domain.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author romeo.jerenyama
 * @created 04/01/2024 - 22:49
 */
@Repository
public interface LoansRepository extends JpaRepository<Loans, Long> {

    Optional<Loans> findByMobileNumber(String mobileNumber);

    Optional<Loans> findByLoanNumber(String loanNumber);
}
