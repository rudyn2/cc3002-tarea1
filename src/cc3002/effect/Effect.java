package cc3002.effect;

import cc3002.game.GameDriver;
import cc3002.trainer.ITrainer;

/**
 * This interface defines the basic functionality of a effect element. Like getters
 * for the name, setting the users and targets or the execution of commands.
 */
public interface Effect {
    String getName();
    void set(ITrainer user, ITrainer target);
    void execute();
}
