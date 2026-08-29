import java.util.ArrayList;

public class Veterinario {
    private ArrayList<Animal> animais = new ArrayList<Animal>();

    public void adicionarAnimal(Animal animal) {
        animais.add(animal);
    }

    public void levarAnimaisParaCarrocinha() {
        for (Animal a : animais) {
            a.emitirSom();
            System.out.println("\nO animal " + a.getNome() + " foi colocado na Carrocinha!\n");
        }
    }
}
