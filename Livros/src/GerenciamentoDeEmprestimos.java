import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Scanner;

public class GerenciamentoDeEmprestimos {

    ArrayList<Emprestimos> emprestimos = new ArrayList<>();

    ArrayList<Pessoa> pessoas;
    ArrayList<Livro> livros;

    Scanner scanner = new Scanner(System.in);

    Biblioteca minhaBiblioteca = new Biblioteca();

    public GerenciamentoDeEmprestimos(
            ArrayList<Pessoa> pessoas,
            ArrayList<Livro> livros
    ) {
        this.pessoas = pessoas;
        this.livros = livros;
    }


    private Aluno buscarAluno(){
        try {
            System.out.println("Digite o código do aluno:");
            int codigoAluno = minhaBiblioteca.letInteriro();

            Aluno alunoEncontrado = null;

            for (Pessoa pessoa : pessoas) {

                if (pessoa instanceof Aluno &&
                        pessoa.getCodigo() == codigoAluno) {

                    alunoEncontrado = (Aluno) pessoa;
                    break;
                }
            }

            if (alunoEncontrado == null) {
                System.out.println("Aluno não encontrado.");
                return null;
            }

            return alunoEncontrado;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Bibliotecario buscarBibliotecario(){
        try {
            System.out.println("Digite o código do bibliotecário:");
            int codigoBibliotecario = minhaBiblioteca.letInteriro();

            Bibliotecario bibliotecarioEncontrado = null;

            for (Pessoa pessoa : pessoas) {

                if (pessoa instanceof Bibliotecario &&
                        pessoa.getCodigo() == codigoBibliotecario) {

                    bibliotecarioEncontrado = (Bibliotecario) pessoa;
                    break;
                }
            }

            if (bibliotecarioEncontrado == null) {
                System.out.println("Bibliotecário não encontrado.");
                return null;
            }

            return bibliotecarioEncontrado;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean verificarDisponibilidadeDoLivro(int codigoDoLivro){
        try {
            for (Emprestimos emprestimo : emprestimos){
                if(emprestimo.getDataDevolucao() == null){
                    for (Livro livro : emprestimo.getLivrosEmprestados()){
                        if (livro.getCodigo() == codigoDoLivro){
                            return false;
                        }
                    }
                }
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private ArrayList<Livro> informarLivrosDoEmprestimo(){
        try {
            System.out.println("Quantos livros serão emprestados?");
            int quantidade = minhaBiblioteca.letInteriro();

            ArrayList<Livro> livrosEmprestados = new ArrayList<>();

            for (int i = 0; i < quantidade; i++) {

                System.out.println("Digite o código do livro " + (i + 1) + ":");

                int codigoLivro = minhaBiblioteca.letInteriro();

                Livro livroEncontrado = null;

                for (Livro livro : livros) {
                    while (livroEncontrado == null || !verificarDisponibilidadeDoLivro(codigoLivro)){
                        if (livro.getCodigo() == codigoLivro) {
                            livroEncontrado = livro;
                            break;
                        }
                        System.out.println("Ops! Parece que esse Livro nao se encontra disponivel ou nao foi encontrado");

                        System.out.println("Digite o codigo do Livro novamente: ");
                        codigoLivro = minhaBiblioteca.letInteriro();
                    }
                }

                livrosEmprestados.add(livroEncontrado);
            }

            return livrosEmprestados;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void realizarEmprestimo() {
        try {
            System.out.println("\n--- REALIZAR EMPRÉSTIMO ---");

            Emprestimos novoEmprestimo = new Emprestimos(buscarBibliotecario(), buscarAluno(), informarLivrosDoEmprestimo());
            emprestimos.add(novoEmprestimo);

            String temDataDevolucao;

            if (novoEmprestimo.getDataDevolucao() == null) {
                temDataDevolucao = "Esse emprestimo ainda esta vigente";
            }else {
                temDataDevolucao = novoEmprestimo.getDataDevolucao().toString();
            }

            System.out.println(
                    "\nEmprestimo realizado com sucesso!" +
                            "\n------------------------" +
                            "\nID do emprestimo: " + novoEmprestimo.getId() +
                            "\nAluno: " + novoEmprestimo.getAlunoResponsavel().getNome() +
                            "\nBibliotecário: " + novoEmprestimo.getBibliotecarioResponsavel().getNome() +
                            "\nQuantidade de livros: " + novoEmprestimo.getQuantidade() +
                            "\nLivros emprestados: " + novoEmprestimo.getLivrosEmprestados() +
                            "\nData de emmprestimo: " + novoEmprestimo.getDataEmprestimo()  +
                            "\nData de devolucao: " + temDataDevolucao
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void realizarDevolucao() {
        try {
            System.out.println("Digite o ID do emprestimo: ");
            int id = minhaBiblioteca.letInteriro();

            for (Emprestimos emprestimo : emprestimos) {
                if (emprestimo.getId() == id) {
                    if (emprestimo.getDataDevolucao() != null) {
                        System.out.println("\nEsse emprestimo ja foi devolvido!");
                        return;
                    }
                    emprestimo.devolver();

                    System.out.println("\nO emprestimo " + id + " foi devolvido com sucesso!");
                    return;
                }
            }
            System.out.println("\nOps! Parece que esse emprestimo nao foi encontrado!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void  listarEmprestimos() {
        System.out.println("--- EMPRESTIMOS REALIZADOS --- ");
        for (Emprestimos emprestimo : emprestimos) {
            System.out.println(
                    "\n------------------------" +
                    "\nID: " + emprestimo.getId() +
                    "\nQuantidade de Livros: " + emprestimo.getQuantidade() +
                    "\nBibliotecario Responsavel: " + emprestimo.getBibliotecarioResponsavel().getNome() +
                    "\nAluno Responsavel: " + emprestimo.getAlunoResponsavel().getNome() +
                    "\nData de Emprestimo: " + emprestimo.getDataEmprestimo() +
                    "\nData de Devolucao: " + emprestimo.getDataDevolucao()
            );
        }
    }
}