package com.romeoscode.accounts.persistence;

import com.romeoscode.accounts.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author romeo.jerenyama
 * @created 02/01/2024 - 18:38
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByMobileNumber(String mobileNumber);

    Optional<Customer> findByMobileNumber(String mobileNumber);
}
