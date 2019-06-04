package cc3002.pokemon;

import cc3002.attack.ElectricAttack;
import cc3002.attack.FighterAttack;
import cc3002.attack.GrassAttack;
import cc3002.attack.IAttack;

import java.util.ArrayList;

public class WaterPokemon extends AbstractPokemon {
    public WaterPokemon(int hp, String name, int id, ArrayList<IAttack> attacks) {
        super(hp, name, id, attacks);
    }

    @Override
    public void attack(IPokemon pokemon) {
        if (this.getSelectedAttack().checkWaterEnergy(this)) {
            this.getSelectedAttack().attack(pokemon);
        }
    }

    @Override
    public void receiveGrassAttack(GrassAttack attack) {
        this.makeDamage(attack.getBaseDamage()*2);
    }

    @Override
    public void receiveElectricAttack(ElectricAttack attack) {
        this.makeDamage(attack.getBaseDamage()*2);
    }

    @Override
    public void receiveFighterAttack(FighterAttack attack) {
        this.makeDamage(attack.getBaseDamage()-30);
    }
}
