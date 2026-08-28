
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class Biblioteca {
    ArrayList<Livro> livros = new ArrayList();
    Scanner scanner = new Scanner(System.in);

    int opcao = 0;

    public boolean verificaSeExisteLivroPorCodigo(int codigo){
        for (Livro livro : livros){
            if (codigo == livro.getCodigo()){
                return true;
            }
        }

        return false;
    }

    public void cadastrarLivro(){
        while(true){
            System.out.println(
                    "\n--- MENU DE CADASTRO ---" +
                    "\n Digite 1 para cadastrar um Livro Fisico" +
                    "\n Digite 2 para cadastrar um Ebook" +
                    "\n Digite qualquer outra tecla para sair do menu de cadastros"
            );

            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    scanner.nextLine();

                    System.out.println("Digite o titulo do livro: ");
                    String titulo = scanner.nextLine();


                    System.out.println("Digite o nome do autor do livro: ");
                    String autor = scanner.nextLine();


                    System.out.println("Digite o numero de paginas do livro: ");
                    int paginas = scanner.nextInt();

                    scanner.nextLine();

                    System.out.println("Digite o codigo do livro: ");
                    int codigo = scanner.nextInt();

                    while(verificaSeExisteLivroPorCodigo(codigo)){
                        System.out.println("\nOps! Parece que esse Codigo ja esta sendo usado em outro Livro. Tente digitar outro codigo para cadastrar o livro");

                        System.out.println("Digite o Codigo do Livro: ");
                        codigo = scanner.nextInt();
                    }

                    scanner.nextLine();

                    System.out.println("Digite o peso do livro em quilograma: ");
                    double peso = scanner.nextDouble();

                    scanner.nextLine();

                    Livro livro = new LivroFisico(peso, titulo, autor, paginas, codigo);
                    adicionarLivro(livro);
                    listarLivros();
                    break;

                case 2:
                    scanner.nextLine();

                    System.out.println("Digite o titulo do livro: ");
                    String tituloEbook = scanner.nextLine();

                    scanner.nextLine();

                    System.out.println("Digite o nome do autor do livro: ");
                    String autorEbook = scanner.nextLine();


                    System.out.println("Digite o numero de paginas do livro: ");
                    int paginasEbook = scanner.nextInt();

                    scanner.nextLine();

                    System.out.println("Digite o codigo do livro: ");
                    int codigoEbook = scanner.nextInt();

                    while(verificaSeExisteLivroPorCodigo(codigoEbook)){
                        System.out.println("\nOps! Parece que esse Codigo ja esta sendo usado em outro Livro. Tente digitar outro codigo para cadastrar o livro");

                        System.out.println("Digite o Codigo do Livro: ");
                        codigoEbook = scanner.nextInt();
                    }

                    scanner.nextLine();

                    System.out.println("Digite o tamanho do arquivo em mb: ");
                    double tamanhoArquivo = scanner.nextDouble();

                    Ebook ebook = new Ebook(tamanhoArquivo,tituloEbook,autorEbook,paginasEbook,codigoEbook);
                    adicionarLivro(ebook);
                    listarLivros();
                    break;
                default:
                    System.out.println("Saindo do menu de cadastros...");
                    return;
            }
        }

    }

    public void adicionarLivro(Livro livro){
        livros.add(livro);

        System.out.println("\nLivro adicionado: " + livro.getTitulo() + " com sucesso!" );
    }

    public void listarLivros(){

        if(livros.isEmpty()){
            System.out.println("\nOps! Parece que não existe nenhum Livro Cadastrado no momento, realize o Cadastro dos Livros antes de lista-los.");
            return;
        }

        for (Livro l : livros) {
            System.out.println(
                    "\n--- BIBLIOTECA ---" +
                            "\nCodigo do Livro: " + l.getCodigo() +
                            "\nAutor do Livro: " + l.getAutor() +
                            "\nTitulo do Livro: " + l.getTitulo() +
                            "\nNumero de Paginas: " + l.getNumeroDePaginas()
            );
            if (l instanceof LivroFisico) {
                LivroFisico fisico = (LivroFisico) l;
                System.out.println("\nPeso em Quilogramas: " + fisico.getPeso());
            } else if (l instanceof Ebook) {
                Ebook ebook = (Ebook) l;
                System.out.println("\nTamanho do Arquivo em MB: " + ebook.getTamanhoArquivo());
            }
            System.out.println("------------------------");
        }
    }

    public Livro buscarLivroPorCodigo(){
        int codigoLivro = scanner.nextInt();

        for(Livro l : livros){
            if (l.codigo == codigoLivro){;
                return l;
            }
        }
        System.out.println("\nOps! Parece que o seu Livro nao foi encontrado.");
        return null;
    }

    public void excluirLivroPorCodigo(){

        Livro livro = buscarLivroPorCodigo();

        if(livro == null){
            return;
        }

        livros.remove(livro);

        System.out.println("\nLivro " + livro.getTitulo() + " removido com sucesso!" );

        listarLivros();
    }


    public void editarLivroNaBibliotecaPeloCodigo(){
        Livro livro = buscarLivroPorCodigo();

        if (livro == null) {
            return;
        }

        System.out.println("Digite o novo nome do autor: ");
        String novoAutor = scanner.nextLine();

        scanner.nextLine();

        System.out.println("Digite o novo titulo: ");
        String novoTitulo = scanner.nextLine();


        System.out.println("Digite o novo numero de paginas: ");
        int novoNumeroDePaginas = scanner.nextInt();

        livro.setTitulo(novoTitulo);
        livro.setAutor(novoAutor);
        livro.setNumeroDePaginas(novoNumeroDePaginas);

        if(livro instanceof Ebook){
            Ebook ebook = (Ebook) livro;

            System.out.println("Digite o novo tamanho do arquivo do Ebook: ");
            double novoTamanhoArquivoEbook = scanner.nextDouble();

            ebook.setTamanhoArquivo(novoTamanhoArquivoEbook);
        }
        else if(livro instanceof LivroFisico){
            LivroFisico fisico = (LivroFisico) livro;

            System.out.println("Digite o novo peso do Livro: ");
            double novoPeso = scanner.nextDouble();

            fisico.setPeso(novoPeso);
        }
    }
}
