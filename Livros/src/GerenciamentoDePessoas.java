import java.util.ArrayList;
import java.util.Scanner;

public class GerenciamentoDePessoas {
    ArrayList<Pessoa> pessoas = new ArrayList();
    Scanner scanner = new Scanner(System.in);

    Biblioteca minhaBiblioteca = new Biblioteca();

    public Pessoa buscarPessoaPorCodigo(){
        try {
            System.out.println("\nDigite o codigo da Pessoa que deseja Editar: ");

            int codigo = minhaBiblioteca.letInteriro();

            for (Pessoa pessoa : pessoas) {
                if (pessoa.getCodigo() == codigo) {
                    return pessoa;
                }
            }
            System.out.println("\nOps! Parece que a Pessoa nao foi encontrada.");
            return null;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verificaSeExistePessoaPorCodigo(int codigo){
        try {
            for (Pessoa pessoa : pessoas){
                if (codigo == pessoa.getCodigo()){
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verificaSeExistePessoPorCpf(String cpf){
        try {
            for (Pessoa pessoa : pessoas){
                if (cpf.equals(pessoa.getCpf())){
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verificaValidadeCpf(String cpf){
        try {
            return cpf != null && cpf.matches("\\d{11}");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    int opcao = 0;

    public void cadastrarPessoa() {
        try {
            while(true){
                System.out.println(
                        "\n--- MENU DE CADASTRO PESSOAS---" +
                                "\n Digite 1 para cadastrar um Aluno" +
                                "\n Digite 2 para cadastrar um Bibliotecario" +
                                "\n Digite qualquer outra tecla para sair do menu de cadastros"
                );

                opcao = minhaBiblioteca.letInteriro();;

                switch (opcao){
                    case 1:

                        System.out.println("Digite o nome do Aluno: ");
                        String nome = scanner.nextLine();

                        System.out.println("Digite o codigo do Aluno: ");
                        int codigo = minhaBiblioteca.letInteriro();;

                        while (verificaSeExistePessoaPorCodigo(codigo)){
                            System.out.println("\nOps! Parece que ja existe uma Pessoa com esse Codigo! Escolha outro Codigo e tente novamente.");

                            System.out.println("Digite o codigo do Aluno: ");
                            codigo = minhaBiblioteca.letInteriro();;
                        }


                        System.out.println("Digite o CPF do Aluno: ");
                        String cpf = scanner.nextLine();


                        while (!verificaValidadeCpf(cpf) || verificaSeExistePessoPorCpf(cpf)){
                            if (!verificaValidadeCpf(cpf)){
                                System.out.println("Ops! O CPF deve possuir exatamente 11 caracteres numericos.");
                            }else {
                                System.out.println("Ops! Parece que ja existe uma Pessoa com esse CPF! Escolha outro CPF e tente novamente.");
                            }

                            System.out.println("Digite o CPF do Aluno: ");
                            cpf = scanner.nextLine();
                        }

                        System.out.println("Digite o curso do Aluno: ");
                        String curso = scanner.nextLine();


                        Aluno aluno = new Aluno(codigo, nome, cpf, curso);
                        pessoas.add(aluno);

                        break;

                    case 2:

                        System.out.println("Digite o nome do Bibliotecario: ");
                        String nomeBibliotecario = scanner.nextLine();

                        System.out.println("Digite o codigo do Bibliotecario: ");
                        int codigoBibliotecario = minhaBiblioteca.letInteriro();;

                        while (verificaSeExistePessoaPorCodigo(codigoBibliotecario)){
                            System.out.println("\nOps! Parece que ja existe uma Pessoa com esse Codigo! Escolha outro Codigo e tente novamente.");

                            System.out.println("Digite o codigo do Bibliotecario: ");
                            codigoBibliotecario = minhaBiblioteca.letInteriro();;
                        }


                        System.out.println("Digite o CPF do Bibliotecario: ");
                        String cpfBibliotecario = scanner.nextLine();

                        while (!verificaValidadeCpf(cpfBibliotecario) || verificaSeExistePessoPorCpf(cpfBibliotecario)){
                            if (!verificaValidadeCpf(cpfBibliotecario)){
                                System.out.println("Ops! O CPF deve possuir exatamente 11 caracteres numericos.");
                            }else {
                                System.out.println("Ops! Parece que ja existe uma Pessoa com esse CPF! Escolha outro CPF e tente novamente.");
                            }

                            System.out.println("Digite o CPF do Bibliotecario: ");
                            cpfBibliotecario = scanner.nextLine();
                        }

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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void excluirPessoa() {
        try {
            while(true){
                System.out.println(
                        "---MENU DE EXCLUSAO DE PESSOAS---" +
                                "\nDigite 1 para excluir um Aluno" +
                                "\nDigite 2 para excluir um bibliotecario" +
                                "\n\nDigite qualquer m outra tecla para sair do Menu de Exclusao"
                );

                opcao = minhaBiblioteca.letInteriro();

                switch (opcao){
                    case 1:
                        System.out.println("Digite o codigo do aluno: ");
                        int codigoAluno = minhaBiblioteca.letInteriro();;

                        for (Pessoa pessoa : pessoas){
                            if(pessoa instanceof Aluno && pessoa.getCodigo() == codigoAluno){
                                pessoas.remove(pessoa);

                                System.out.println("Aluno " + pessoa.getNome() + " excluido com sucesso!");

                                break;
                            }
                            System.out.println("\nNao foi encontrado nenhum Aluno com esse codigo, tente novamente.");
                        }
                        break;

                    case 2:
                        System.out.println("Digite o codigo do bibliotecario: ");
                        int codigoBibliotecario = minhaBiblioteca.letInteriro();;

                        for (Pessoa pessoa : pessoas){
                            if(pessoa instanceof Bibliotecario && pessoa.getCodigo() == codigoBibliotecario){
                                pessoas.remove(pessoa);

                                System.out.println("Biliotecario " + pessoa.getNome() + " excluido com sucesso!");
                                break;
                            }
                            System.out.println("\nNao foi encontrado nenhum Bibliotecario com esse codigo, tente novamente.");
                        }
                        break;
                    default:
                        System.out.println("Saindo do menu de exclusao de pessoas...");
                        return;
                }
            }
        } catch (Exception e) {

        }
    }

    public void listarPessoas() {
        try{
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void editarPessoa(){
        try {
            Pessoa pessoa = buscarPessoaPorCodigo();

            if(pessoa == null){
                return;
            }

            System.out.println("\nDigite o novo Nome da Pessoa");
            String novoNome = scanner.nextLine();

            System.out.println("\nDigite o novo CPF da Pessoa");
            String novoCPF = scanner.nextLine();

            while (!verificaValidadeCpf(novoCPF) || verificaSeExistePessoPorCpf(novoCPF)){
                if (!verificaValidadeCpf(novoCPF)){
                    System.out.println("Ops! O CPF deve possuir exatamente 11 caracteres numericos.");
                }else {
                    System.out.println("Ops! Parece que ja existe uma Pessoa com esse CPF! Escolha outro CPF e tente novamente.");
                }

                System.out.println("Digite o CPF da Pessoa: ");
                novoCPF = scanner.nextLine();
            }

            pessoa.setCpf(novoCPF);

            if (pessoa instanceof  Aluno){
                Aluno aluno = (Aluno) pessoa;

                System.out.println("Digite o novo Curso do Aluno");
                String novoCurso = scanner.nextLine();

                aluno.setCurso(novoCurso);
            }

            if (pessoa instanceof  Bibliotecario){
                Bibliotecario bibliotecario = (Bibliotecario) pessoa;

                System.out.println("Digite o novo Cargo do Bibliotecario");
                String novoCargo = scanner.nextLine();

                bibliotecario.setCargo(novoCargo);
            }
            pessoa.setNome(novoNome);

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
