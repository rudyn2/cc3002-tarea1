package cc3002.pokemon;

import cc3002.attack.IAttack;

import java.util.ArrayList;

public abstract class AbstractPokemon implements IPokemon {

    private int hp;
    private String name;
    private ArrayList<IAttack> attacks;
    private int damageCounter;

    AbstractPokemon(int hp, String name, ArrayList<IAttack> attacks){
        this.hp = hp;
        this.name = name;
        this.attacks = attacks;
        this.damageCounter = 0;
    }


    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public int getHp(){
        return this.hp;
    }

    @Override
    public boolean isDead() {
        return damageCounter >= hp;
    }

    @Override
    public ArrayList<IAttack> getAttacks(){
        return this.attacks;
    }

}
