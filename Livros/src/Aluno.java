public class Aluno extends Pessoa {
    String curso;

    public Aluno(int codigo, String nome, String cpf, String curso) {
        super(codigo, nome, cpf);
        this.curso = curso;
    }


    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}

