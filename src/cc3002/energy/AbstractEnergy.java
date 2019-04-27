package cc3002.energy;

import cc3002.trainer.ITrainer;

/**
 * Abstract class that represent a generic energy. It has the minimal energy specifications in
 * order to make a interaction between attacks and pokemon. The game logic says that a pokemon needs
 * energy to perform attacks. This class implements some common methods and an abstract constructor
 * for a generic energy.
 */
public abstract class AbstractEnergy implements IEnergy {

    /**
     * Tha name of the energy. It could be FireEnergy, GrassEnergy,
     * WaterEnergy, ElectricEnergy, FighterEnergy or PsychicEnergy.
     */
    private String name;

    /**
     * The amount of base energy. It could be any positive integer number.
     */
    private int baseEnergy;

    /**
     * Abstract constructor for the AbstractEnergy class. Any energy can be
     * built from the name and base energy.
     * @param name Tha name of the energy.
     * @param baseEnergy The base energy.
     */
    AbstractEnergy(String name, int baseEnergy) {
        this.name = name;
        this.baseEnergy = baseEnergy;
    }

    /**
     * Getter for the name of the energy.
     * @return The name of the energy.
     */
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getInfo() {
        return "Nombre: " + this.getName() + ", Tipo: Energía";
    }


    @Override
    public void play(ITrainer trainer) {
        this.assignEnergy(trainer.getActivePokemon());
    }

    /**
     * Getter for the base energy of the energy card.
     * @return An integer that represents the base energy.
     */
    @Override
    public int getBaseEnergy() {
        return this.baseEnergy;
    }

}
