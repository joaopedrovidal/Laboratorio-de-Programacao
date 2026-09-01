public class Coelho extends Animal {

    public Coelho(String nome, int idade, String cor) {
        super(nome, idade, cor, "fum, fum, fum!");
    }

    @Override
    public void emitirSom() {
        System.out.println("Fungando: " + getSom());
    }
}
