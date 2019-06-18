package cc3002.trainercard;

import cc3002.card.ICard;
import cc3002.trainer.ITrainer;
import cc3002.visitor.IVisitor;

/**
 * Common interface that defines the basic extra functionality of a trainer card.
 * Basically they must be able to accept a visitor.
 */
public interface ITrainerCard extends ICard {

    void accept(IVisitor v);
}
