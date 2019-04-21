package cc3002.pokemon;

import cc3002.attack.IAttack;

import java.util.ArrayList;

public class WaterPokemon extends AbstractPokemon {
    WaterPokemon(int hp, String name, ArrayList<IAttack> attacks) {
        super(hp, name, attacks);
    }
}
