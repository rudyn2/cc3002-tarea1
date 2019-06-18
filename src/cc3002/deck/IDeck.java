package cc3002.deck;

import cc3002.card.ICard;

/**
 * This interface is dedicated to the control of a normal deck. A deck has the
 * LIFO principle (last in first out). This aux interface will help with the
 * handling of the cards.
 */
public interface IDeck {

    void push(ICard card);
    ICard pop();
    boolean isEmpty();
}
