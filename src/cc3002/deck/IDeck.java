package cc3002.deck;

import cc3002.card.ICard;

public interface IDeck {

    void push(ICard card);
    ICard pop();
    boolean isEmpty();
}
