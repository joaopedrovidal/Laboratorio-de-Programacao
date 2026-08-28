import java.util.ArrayList;
import java.util.Date;

public class Emprestimos {

    private static int proximaId = 1;

    private int id;
    private int quantidade;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    private Bibliotecario bibliotecarioResponsavel;
    private Aluno alunoResponsavel;

    private ArrayList<Livro> livrosEmprestados;

    public Emprestimos(
            Bibliotecario bibliotecarioResponsavel,
            Aluno alunoResponsavel,
            ArrayList<Livro> livrosEmprestados
    ) {

        this.id = proximaId++;

        this.bibliotecarioResponsavel = bibliotecarioResponsavel;
        this.alunoResponsavel = alunoResponsavel;
        this.livrosEmprestados = livrosEmprestados;

        this.quantidade = livrosEmprestados.size();

        this.dataEmprestimo = new Date();
        this.dataDevolucao = null;
    }

    public int getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Bibliotecario getBibliotecarioResponsavel() {
        return bibliotecarioResponsavel;
    }

    public Aluno getAlunoResponsavel() {
        return alunoResponsavel;
    }

    public ArrayList<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void devolver() {
        this.dataDevolucao = new Date();
    }
}