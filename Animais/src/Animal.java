public abstract class Animal {
    private String nome;
    private int idade;
    private String cor;
    private String som;

    public abstract void emitirSom();

    public Animal(String nome, int idade, String cor, String som) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
        this.som = som;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getSom() {
        return som;
    }

    public void setSom(String som) {
        this.som = som;
    }
}
