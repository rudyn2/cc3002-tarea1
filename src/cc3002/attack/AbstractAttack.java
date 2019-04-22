package cc3002.attack;

public abstract class AbstractAttack implements IAttack {

    private String name;
    private String description;
    private int baseDamage;
    private int cost;

    AbstractAttack(String name, String description, int baseDamage, int cost){
        this.name = name;
        this.description = description;
        this.baseDamage = baseDamage;
        this.cost = cost;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCost() {
        return this.cost;
    }

    @Override
    public String getDescription(){
        return this.description;
    }

    @Override
    public int getBaseDamage() {
        return this.baseDamage;
    }

}
