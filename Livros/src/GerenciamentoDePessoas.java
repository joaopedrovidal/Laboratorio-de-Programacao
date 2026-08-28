import java.util.ArrayList;
import java.util.Scanner;

public class GerenciamentoDePessoas {
    ArrayList<Pessoa> pessoas = new ArrayList();
    Scanner scanner = new Scanner(System.in);

    int opcao = 0;

    public void cadastrarPessoa() {
        while(true){
            System.out.println(
                    "\n--- MENU DE CADASTRO PESSOAS---" +
                            "\n Digite 1 para cadastrar um Aluno" +
                            "\n Digite 2 para cadastrar um Bibliotecario" +
                            "\n Digite qualquer outra tecla para sair do menu de cadastros"
            );

            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    scanner.nextLine();

                    System.out.println("Digite o nome do Aluno: ");
                    String nome = scanner.nextLine();

                    System.out.println("Digite o codigo do Aluno: ");
                    int codigo = scanner.nextInt();

                    scanner.nextLine();

                    System.out.println("Digite o CPF do Aluno: ");
                    String cpf = scanner.nextLine();

                    System.out.println("Digite o curso do Aluno: ");
                    String curso = scanner.nextLine();


                    Aluno aluno = new Aluno(codigo, nome, cpf, curso);
                    pessoas.add(aluno);

                    break;

                case 2:
                    scanner.nextLine();

                    System.out.println("Digite o nome do Bibliotecario: ");
                    String nomeBibliotecario = scanner.nextLine();

                    System.out.println("Digite o codigo do Bibliotecario: ");
                    int codigoBibliotecario = scanner.nextInt();

                    scanner.nextLine();

                    System.out.println("Digite o CPF do Bibliotecario: ");
                    String cpfBibliotecario = scanner.nextLine();

                    System.out.println("Digite o cargo do Bibliotecario: ");
                    String cargoBibliotecario = scanner.nextLine();

                    Bibliotecario bibliotecario = new Bibliotecario(codigoBibliotecario, nomeBibliotecario, cpfBibliotecario, cargoBibliotecario);
                    pessoas.add(bibliotecario);

                    break;

                default:
                    System.out.println("Saindo do menu de cadastros de pessoas...");
                    return;
            }
        }
    }

    public void excluirPessoa() {
        while(true){
            System.out.println(
                    "---MENU DE EXCLUSAO DE PESSOAS---" +
                    "\nDigite 1 para excluir um Aluno" +
                    "\nDigite 2 para excluir um bibliotecario" +
                    "\nDigite qualquerm outra tecla para sair do Menu de Exclusao"
            );

            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Digite o codigo do aluno: ");
                    int codigoAluno = scanner.nextInt();

                    for (Pessoa pessoa : pessoas){
                        if(pessoa instanceof Aluno && pessoa.getCodigo() == codigoAluno){
                            pessoas.remove(pessoa);

                            System.out.println("Aluno " + pessoa.getNome() + " excluido com sucesso!");

                            break;
                        }
                    }
                    break;

                case 2:
                    System.out.println("Digite o codigo do bibliotecario: ");
                    int codigoBibliotecario = scanner.nextInt();

                    for (Pessoa pessoa : pessoas){
                        if(pessoa instanceof Bibliotecario && pessoa.getCodigo() == codigoBibliotecario){
                            pessoas.remove(pessoa);

                            System.out.println("Biliotecario " + pessoa.getNome() + " excluido com sucesso!");
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("Saindo do menu de exclusao de pessoas...");
                    return;
            }
        }
    }

    public void listarPessoas() {
        System.out.println("\n--- PESSOAS CADASTRADAS --- ");
        for (Pessoa pessoa : pessoas){
            System.out.println(
                    "\nCodigo: " + pessoa.getCodigo() +
                    "\nCPF: " + pessoa.getCpf() +
                    "\nNome: " + pessoa.getNome()
            );

            if(pessoa instanceof Aluno){

                Aluno aluno = (Aluno) pessoa;
                System.out.println("Curso: " + aluno.getCurso());

            }else if (pessoa instanceof Bibliotecario){

                Bibliotecario bibliotecario = (Bibliotecario) pessoa;
                System.out.println("Cargo: " + bibliotecario.getCargo());
            }
            System.out.println("------------------------");
        }
    }
}
