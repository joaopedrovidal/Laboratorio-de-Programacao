

public class Bibliotecario extends Pessoa {
    String cargo;

    public Bibliotecario(int codigo, String nome, String cpf, String cargo) {
        super(codigo, nome, cpf);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
