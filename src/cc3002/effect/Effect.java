package cc3002.effect;

import cc3002.game.GameDriver;
import cc3002.trainer.ITrainer;

public interface Effect {
    String getName();
    void set(ITrainer user, ITrainer target);
    void execute();
}
