public class Principal {
    public static void main(String[] args) {
        Veterinario veterinario = new Veterinario();

        Cachorro minhaCachorra = new Cachorro("Andie", 2, "Branca com Marrom");
        Cavalo meuCavalo = new Cavalo("Pe de Pano", 21, "Marrom");
        Gato meuGato = new Gato("Garfiled", 7, "Laranja");
        Coelho meuCoelho = new Coelho("Pipoca", 1, "Branco");

        veterinario.adicionarAnimal(minhaCachorra);
        veterinario.adicionarAnimal(meuCavalo);
        veterinario.adicionarAnimal(meuGato);
        veterinario.adicionarAnimal(meuCoelho);

        veterinario.levarAnimaisParaCarrocinha();

        System.out.println("--- Modificando o som da Andie ---\n");
        minhaCachorra.setSom("AIN, AIN, AIN! (Chorando)");
        minhaCachorra.emitirSom();
    }
}
