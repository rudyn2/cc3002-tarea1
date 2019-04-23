package cc3002.pokemon;

import cc3002.attack.FighterAttack;
import cc3002.attack.IAttack;
import cc3002.attack.WaterAttack;

import java.util.ArrayList;

public class ElectricPokemon extends AbstractPokemon {

    ElectricPokemon(int hp, String name, ArrayList<IAttack> attacks) {
        super(hp, name, attacks);
    }

    @Override
    public void receiveWaterAttack(WaterAttack attack) {
        super.receiveWaterAttack(attack);
    }

    @Override
    public void receiveFighterAttack(FighterAttack attack) {
        this.makeDamage(attack.getBaseDamage()*2);
    }

    @Override
    public void attack(IPokemon pokemon) {
        if (this.getSelectedAttack().checkElectricEnergy(this)) {
            this.getSelectedAttack().attack(pokemon);
            System.out.println(this.getName() + " ha atacado a " + pokemon.getName());
        }
    }

}
