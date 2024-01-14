package com.romeoscode.cards.persisitence;

import com.romeoscode.cards.domain.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author romeo.jerenyama
 * @created 06/01/2024 - 16:39
 */
public interface CardsRepository extends JpaRepository<Cards, Long> {
    Optional<Cards> findByMobileNumber(String mobileNumber);

    Optional<Cards> findByCardNumber(String cardNumber);
}
