package com.romeoscode.cards.mapper;

import com.romeoscode.cards.domain.Cards;
import com.romeoscode.cards.dto.CardsDto;

/**
 * @author romeo.jerenyama
 * @created 06/01/2024 - 16:42
 */
public class CardsMapper {
    public static CardsDto mapToCardsDto(Cards cards, CardsDto cardsDto) {

        cardsDto.setCardType(cards.getCardType());
        cardsDto.setCardNumber(cards.getCardNumber());
        cardsDto.setMobileNumber(cards.getMobileNumber());
        cardsDto.setTotalLimit(cards.getTotalLimit());
        cardsDto.setAvailableAmount(cards.getAvailableAmount());
        cardsDto.setAmountUsed(cards.getAmountUsed());
        return cardsDto;
    }

    public static Cards mapToCards(CardsDto cardsDto, Cards cards) {
        cards.setCardNumber(cardsDto.getCardNumber());
        cards.setCardType(cardsDto.getCardType());
        cards.setMobileNumber(cardsDto.getMobileNumber());
        cards.setTotalLimit(cardsDto.getTotalLimit());
        cards.setAvailableAmount(cardsDto.getAvailableAmount());
        cards.setAmountUsed(cardsDto.getAmountUsed());
        return cards;
    }
}
