package springpractice.blackjack;

import org.springframework.beans.factory.annotation.Autowired;


public class CardImpl implements Card{

    private final int value;

    private final String suit;

    private final String face;


    @Autowired
    public CardImpl(int value, String suit,String face) {
        this.value = value;
        this.suit = suit;
        this.face = face;
    }


    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getSuit() {
        return suit;
    }

    @Override
    public String getFace() {
        return face;
    }
}
