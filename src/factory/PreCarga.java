package factory;

import model.*;
import java.time.LocalDate;

public class PreCarga {
    public static void executar() {
        Livro l1 = new Livro("1", "Java Básico", "João Silva", 2020, 5, "Programação");
        Livro l2 = new Livro("2", "POO com Java", "Ana Souza", 2018, 3, "Programação");
        Livro l3 = new Livro("3", "Algoritmos", "Carlos Lima", 2015, 4, "Computação");
        Livro l4 = new Livro("4", "Banco de Dados", "Mariana Dias", 2019, 2, "Informática");
        Livro l5 = new Livro("5", "Estrutura de Dados", "Pedro Alves", 2021, 6, "Computação");
        Livro l6 = new Livro("6", "Redes de Computadores", "Laura Gomes", 2017, 1, "Informática");

        Usuario u1 = new Usuario("111", "Maria", "99999-9999", "Rua A", "maria@email.com");
        Usuario u2 = new Usuario("222", "Carlos", "98888-8888", "Rua B", "carlos@email.com");
        Usuario u3 = new Usuario("333", "Joana", "97777-7777", "Rua C", "joana@email.com");
        Usuario u4 = new Usuario("444", "Felipe", "96666-6666", "Rua D", "felipe@email.com");

        Biblioteca.adicionarLivro(l1);
        Biblioteca.adicionarLivro(l2);
        Biblioteca.adicionarLivro(l3);
        Biblioteca.adicionarLivro(l4);
        Biblioteca.adicionarLivro(l5);
        Biblioteca.adicionarLivro(l6);

        Biblioteca.adicionarUsuario(u1);
        Biblioteca.adicionarUsuario(u2);
        Biblioteca.adicionarUsuario(u3);
        Biblioteca.adicionarUsuario(u4);

        try {
            l1.emprestar();
            Emprestimo e1 = new Emprestimo(u1, l1, LocalDate.now().minusDays(2), LocalDate.now().plusDays(5));
            Biblioteca.registrarEmprestimo(e1);

            l2.emprestar();
            Emprestimo e2 = new Emprestimo(u2, l2, LocalDate.now().minusDays(10), LocalDate.now().minusDays(3));
            e2.registrarDevolucao(); // atraso de 3 dias
            Biblioteca.registrarEmprestimo(e2);

            l3.emprestar();
            Emprestimo e3 = new Emprestimo(u3, l3, LocalDate.now().minusDays(14), LocalDate.now().minusDays(7));
            e3.registrarDevolucao(); // atraso de 7 dias
            Biblioteca.registrarEmprestimo(e3);

            l4.emprestar();
            Emprestimo e4 = new Emprestimo(u4, l4, LocalDate.now().minusDays(5), LocalDate.now().plusDays(2));
            Biblioteca.registrarEmprestimo(e4);
        } catch (Exception e) {
            System.out.println("Erro na pré-carga de empréstimos: " + e.getMessage());
        }
    }
}