package cc3002.effect;

public class LuckyStadium extends ContinuousEffect {
    public LuckyStadium(String name) {
        super(name);
    }

    @Override
    public void execute() {
        double random = Math.random();
        if (random >= 0.5) this.getUser().drawCard();
    }
}
