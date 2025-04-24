package view;

import java.util.Scanner;
import model.*;
import java.time.LocalDate;

public class MenuView {
    private Scanner sc = new Scanner(System.in);

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== MENU BIBLIOTECA ===");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Pesquisar Livro");
            System.out.println("3. Cadastrar Usuário");
            System.out.println("4. Realizar Empréstimo");
            System.out.println("5. Registrar Devolução");
            System.out.println("6. Relatórios");
            System.out.println("7. Listar Todos os Livros");
            System.out.println("0. Sair");
            System.out.print("\nEscolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    pesquisarLivro();
                    break;
                case 3:
                    cadastrarUsuario();
                    break;
                case 4:
                    realizarEmprestimo();
                    break;
                case 5:
                    registrarDevolucao();
                    break;
                case 6:
                    relatorios();
                    break;
                case 7:
                    listarTodosLivros();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }

    private void cadastrarLivro() {
        System.out.print("Código: ");
        String cod = sc.nextLine();

        if (Biblioteca.buscarLivroPorCodigo(cod) != null) {
            System.out.println("Já existe um livro com esse código!");
            return;
        }

        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("Ano: ");
        int ano = sc.nextInt();
        System.out.print("Exemplares: ");
        int ex = sc.nextInt();
        sc.nextLine();
        System.out.print("Categoria: ");
        String cat = sc.nextLine();

        Livro livroCompleto = new Livro(cod, titulo, autor, ano, ex, cat);
        Biblioteca.adicionarLivro(livroCompleto);
        System.out.println("Livro cadastrado com sucesso!");
    }

    private void cadastrarUsuario() {
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Telefone: ");
        String tel = sc.nextLine();
        System.out.print("Endereço: ");
        String end = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        Biblioteca.adicionarUsuario(new Usuario(id, nome, tel, end, email));
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private void pesquisarLivro() {
        System.out.print("Digite o título a buscar: ");
        String titulo = sc.nextLine();
        java.util.List<Livro> livros = Biblioteca.buscarLivrosPorTitulo(titulo);
        for (Livro l : livros) {
            System.out.printf("%s - %s (%d)\n", l.getCodigo(), l.getTitulo(), l.getAno());
        }
    }

    private void realizarEmprestimo() {
        System.out.print("ID do usuário: ");
        String id = sc.nextLine();
        Usuario u = Biblioteca.buscarUsuarioPorId(id);
        if (u == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        System.out.print("Código do livro: ");
        String cod = sc.nextLine();
        Livro l = Biblioteca.buscarLivroPorCodigo(cod);
        if (l == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        try {
            l.emprestar();
            Emprestimo emp = new Emprestimo(u, l, LocalDate.now(), LocalDate.now().plusDays(7));
            Biblioteca.registrarEmprestimo(emp);
            System.out.println("Empréstimo realizado com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void registrarDevolucao() {
        System.out.print("Código do livro: ");
        String cod = sc.nextLine();

        for (Emprestimo emp : Biblioteca.getEmprestimos()) {
            if (emp.getLivro().getCodigo().equalsIgnoreCase(cod) && emp.getDataDevolucao() == null) {
                emp.registrarDevolucao();
                System.out.println("Devolução registrada. Dias em atraso: " + emp.diasAtraso());
                return;
            }
        }
        System.out.println("Empréstimo não encontrado ou já devolvido.");
    }

    private void relatorios() {
        System.out.println("\n=== LIVROS EMPRESTADOS ===");
        for (Emprestimo emp : Biblioteca.getEmprestimos()) {
            if (emp.getDataDevolucao() == null) {
                System.out.printf("%s emprestado a %s até %s\n", emp.getLivro().getTitulo(), emp.getUsuario().getNome(), emp.getDataPrevista());
            }
        }

        System.out.println("\n=== ATRASOS ===");
        Biblioteca.getEmprestimos().stream()
            .filter(e -> e.getDataDevolucao() != null && e.diasAtraso() > 0)
            .sorted((a, b) -> Long.compare(b.diasAtraso(), a.diasAtraso()))
            .forEach(e -> System.out.printf("%s devolvido por %s com %d dias de atraso\n", e.getLivro().getTitulo(), e.getUsuario().getNome(), e.diasAtraso()));
    }

    private void listarTodosLivros() {
        System.out.println("\n=== LISTA DE TODOS OS LIVROS ===");
        for (Livro l : Biblioteca.getLivros()) {
            System.out.printf("%s - %s (%d), Autor: %s, Exemplares: %d, Categoria: %s\n",
                l.getCodigo(), l.getTitulo(), l.getAno(), l.getAutor(), l.getExemplares(), l.getCategoria());
        }
    }
}
