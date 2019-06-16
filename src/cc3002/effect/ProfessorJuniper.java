package cc3002.effect;

import cc3002.card.ICard;

public class ProfessorJuniper extends InstantEffect {

    public ProfessorJuniper(String name) {
        super(name);
    }

    @Override
    public void execute() {
        for (ICard c: this.getTarget().getHand()){
            this.getUser().discardCard(c);
        }

        for (int i = 0; i < 7; i++){
            this.getUser().drawCard();
        }
    }
}
