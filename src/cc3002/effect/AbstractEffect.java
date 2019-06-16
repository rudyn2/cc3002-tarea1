package cc3002.effect;

import cc3002.trainer.ITrainer;

public abstract class AbstractEffect implements Effect {

    private String name;
    private ITrainer user;
    private ITrainer target;

    public AbstractEffect(String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void set(ITrainer user, ITrainer target) {
        this.user = user;
        this.target = target;

    }

    public ITrainer getUser() {
        return user;
    }

    public ITrainer getTarget() {
        return target;
    }

}
