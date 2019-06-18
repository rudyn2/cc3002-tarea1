package cc3002.attack;

import cc3002.effect.Effect;
import cc3002.effect.InstantEffect;
import cc3002.pokemon.*;

public abstract class AbstractAbility implements IAbility {

    private String description;
    private String name;
    private InstantEffect effect;

    public AbstractAbility(String name, String description, InstantEffect effect) {
        this.description = description;
        this.name = name;
        this.effect = effect;
    }


    /**
     * Getter for the description of the attack.
     *
     * @return The description of the attack.
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * Getter for the name of the attack.
     *
     * @return The name of the attack.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Check if the specified FirePokemon can perform this attack.
     * @param pokemon The FirePokemon that will be reviewed.
     * @return True if the FirePokemon has more or equal amount of energy than the cost of the attack.
     */
    @Override
    public boolean checkFireEnergy(AbstractFirePokemon pokemon) {
        return true;

    }

    @Override
    public boolean checkElectricEnergy(AbstractElectricPokemon pokemon) {
        return true;
    }

    /**
     * Check if the specified FighterPokemon can perform this attack.
     * @param pokemon The FighterPokemon that will be reviewed.
     * @return True if the FighterPokemon has more or equal amount of energy than the cost of the attack.
     */
    @Override
    public boolean checkFighterEnergy(AbstractFighterPokemon pokemon) {
        return true;
    }

    /**
     * Check if the specified GrassPokemon can perform this attack.
     * @param pokemon The GrassPokemon that will be reviewed.
     * @return True if the GrassPokemon has more or equal amount of energy than the cost of the attack.
     */
    @Override
    public boolean checkGrassEnergy(AbstractGrassPokemon pokemon) {
        return true;
    }

    /**
     * Check if the specified PsychicPokemon can perform this attack.
     * @param pokemon The PsychicPokemon that will be reviewed.
     * @return True if the PsychicPokemon has more or equal amount of energy than the cost of the attack.
     */
    @Override
    public boolean checkPsychicEnergy(AbstractPsychicPokemon pokemon) {
        return true;
    }

    /**
     * Check if the specified WaterPokemon can perform this attack.
     * @param pokemon The WaterPokemon that will be reviewed.
     * @return True if the WaterPokemon has more or equal amount of energy than the cost of the attack.
     */
    @Override
    public boolean checkWaterEnergy(AbstractWaterPokemon pokemon) {
        return true;
    }


    @Override
    public Effect getEffect() {
        return this.effect;
    }
}
