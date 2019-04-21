package cc3002.pokemon;

import cc3002.attack.IAttack;

import java.util.ArrayList;

public class FighterPokemon extends AbstractPokemon {
    FighterPokemon(int hp, String name, ArrayList<IAttack> attacks) {
        super(hp, name, attacks);
    }
}
