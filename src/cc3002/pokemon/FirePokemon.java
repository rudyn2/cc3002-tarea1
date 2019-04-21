package cc3002.pokemon;

import cc3002.attack.IAttack;

import java.util.ArrayList;

public class FirePokemon extends AbstractPokemon{

    FirePokemon(int hp, String name, ArrayList<IAttack> attacks){
        super(hp, name, attacks);
    }

    void receiveElectricAttack(ElectricPokemon enemy){

    }

}
