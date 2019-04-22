package cc3002.energy;

public abstract class AbstractEnergy implements IEnergy {

    private String name;
    private int baseEnergy;

    AbstractEnergy(String name, int baseEnergy) {
        this.name = name;
        this.baseEnergy = baseEnergy;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBaseEnergy() {
        return this.baseEnergy;
    }

}
