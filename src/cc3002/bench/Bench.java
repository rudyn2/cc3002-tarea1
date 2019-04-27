package cc3002.bench;

import cc3002.pokemon.IPokemon;

import java.util.ArrayList;

public class Bench implements IBench {

    /**
     * The bench that will store the pokemon's.
     */
    private ArrayList<IPokemon> bench;

    /**
     * Empty Constructor for the class Bench. It will initialize the bench empty.
     */
    public Bench(){
        this(new ArrayList<>());
    }

    /**
     * Generic constructor for the class Bench. It will initialize the bench with an array of pokemon's.
     * @param bench An ArrayList with the initial pokemon's.
     */
    public Bench(ArrayList<IPokemon> bench) {
        if (bench.size() > 5) {
            this.bench = new ArrayList<>();
            System.out.println("La banca se inicializó vacía. Debe especificar hasta 5 pokemones.");
        } else {
            this.bench = bench;
        }

    }


    /**
     * Method to add a pokemon into the bench. Only if the bench isn't full.
     *
     * @param pokemon The pokemon that will be added.
     */
    @Override
    public void add(IPokemon pokemon) {
        if (!this.isFull()){
            this.bench.add(pokemon);
        }
    }

    /**
     * Method to remove a pokemon from the bench.
     *
     * @param option The position of the pokemon that will be removed.
     */
    @Override
    public void remove(int option) {
        if (this.isValidOption(option)) {
            this.bench.remove(option);
        } else {
            System.out.println("Debe especificar una opción válida.");
        }
    }

    /**
     * Method to replace a pokemon in the bench.
     *
     * @param option The position of the pokemon that will be replaced.
     * @param pokemon The pokemon that will take place in the bench.
     * @return The pokemon that was in the place specified in the option.
     */

    @Override
    public IPokemon replace(int option, IPokemon pokemon) {
        if (this.isValidOption(option)){
            return this.bench.set(option, pokemon);
        } else {
            System.out.println("Debe especificar una opción válida.");
            return null;
        }
    }

    /**
     * Method that counts the number of pokemon's that are in the bench.
     *
     * @return The number of pokemon's in the bench.
     */
    @Override
    public int count() {
        return this.bench.size();
    }

    /**
     * Method to visualize the pokemon's in the bench. It will print
     * the position and the name of the pokemon in the bench.
     */
    @Override
    public void visualize() {
        if (this.count() > 0){
            for (int i = 0; i < this.count(); i++){
                System.out.println(i + ".- " + this.bench.get(i).getName() + " (ID: ");
            }
        } else {
            System.out.println("La banca está vacía.");
        }

    }

    /**
     * Method that checks if the bench is empty.
     *
     * @return True if the bench is empty.
     */
    @Override
    public boolean isEmpty() {
        return this.count() == 0;
    }

    /**
     * Method that checks if the bench is full.
     *
     * @return True if the bench is full.
     */
    @Override
    public boolean isFull() {
        return this.count() == 5;
    }

    private boolean isValidOption(int option){
        return (option >= 0) && (option < this.count());
    }
}
