package cc3002.pokemon;

import cc3002.attack.IAttack;
import cc3002.attack.WaterAttack;

import java.util.ArrayList;

public class FirePokemon extends AbstractPokemon{

    public FirePokemon(int hp, String name, ArrayList<IAttack> attacks){
        super(hp, name, attacks);
    }

    @Override
    public void receiveWaterAttack(WaterAttack attack) {
        this.makeDamage(attack.getBaseDamage()*2);
    }

    @Override
    public void attack(IPokemon pokemon) {
        if (this.getSelectedAttack().checkFireEnergy(this)) {
            this.getSelectedAttack().attack(pokemon);
            System.out.println(this.getName() + " ha atacado a " + pokemon.getName());
        } else {
            System.out.println("Al parecer " + this.getName() + " no tiene suficiente energía!");
        }
    }


}
