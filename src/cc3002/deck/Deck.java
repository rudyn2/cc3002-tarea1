package cc3002.deck;

import cc3002.card.ICard;

import java.util.ArrayList;

public class Deck implements IDeck {

    private ArrayList<ICard> deck;

    public Deck(ArrayList<ICard> deck) {
        this.deck = deck;
    }

    @Override
    public void push(ICard card) {
        deck.add(card);
    }

    @Override
    public ICard pop() {
        if (!this.isEmpty())
            return deck.remove(deck.size()-1);
        return null;
    }

    @Override
    public boolean isEmpty() {
        return deck.isEmpty();
    }

}
