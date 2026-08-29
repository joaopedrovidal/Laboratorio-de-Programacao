public class Cavalo extends Animal {

    public Cavalo(String nome, int idade, String cor) {
        super(nome, idade, cor, "iiirrrri, iiirrrri, iiirrrrí!");
    }

    @Override
    public void emitirSom() {
        System.out.println("Rinchando: " + getSom());
    }
}
