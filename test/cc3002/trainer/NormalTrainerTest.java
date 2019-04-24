package cc3002.trainer;

import cc3002.ICard;
import cc3002.attack.FireAttack;
import cc3002.attack.IAttack;
import cc3002.energy.FireEnergy;
import cc3002.pokemon.FirePokemon;
import cc3002.pokemon.IPokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class NormalTrainerTest {

    private NormalTrainer ash;
    private ArrayList<ICard> someCarts;
    private ArrayList<IPokemon> somePokemons;

    private FirePokemon charmander;
    private FireEnergy fireEnergy;
    private FireAttack fireAttackSimple, hardFireAttack;



    @BeforeEach
    void setUp(){

        fireAttackSimple = new FireAttack("LLama de fuego", "Fuego azul valyrio", 10, 5);
        hardFireAttack = new FireAttack("Bola de fuego", "Fuego verde valyrio", 10, 5);
        ArrayList<IAttack> attacks = new ArrayList<>(Arrays.asList(fireAttackSimple, hardFireAttack));

        charmander = new FirePokemon(100, "Charmander", attacks);
        fireEnergy = new FireEnergy("Energía de fuego", 40);
        someCarts = new ArrayList<>(Arrays.asList(charmander, fireEnergy));
        ash = new NormalTrainer("Ash", someCarts, charmander);
    }

    @Test
    void descriptionTest(){
        assertEquals("Ash", ash.getName());
        assertEquals(someCarts, ash.getHand());
        assertFalse(ash.isOver());
    }

    @Test
    void selectAttackTest(){
        ash.selectAttackOfActivePokemon(1);
        assertEquals(hardFireAttack, ash.getActivePokemon().getSelectedAttack());
        ash.selectAttackOfActivePokemon(1000);
        assertEquals(hardFireAttack, ash.getActivePokemon().getSelectedAttack());
        ash.selectAttackOfActivePokemon(0);
        assertEquals(fireAttackSimple, ash.getActivePokemon().getSelectedAttack());
    }

    @Test
    void changeActivePokemonTest(){
        ash.changeActivePokemon(1);
        assertEquals(charmander, ash.getActivePokemon());

    }
}