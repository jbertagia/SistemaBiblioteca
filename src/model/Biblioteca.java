package model;

import java.util.*;

public class Biblioteca {
    private static List<Livro> livros = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Emprestimo> emprestimos = new ArrayList<>();

    public static void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public static void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static List<Livro> getLivros() { return livros; }
    public static List<Usuario> getUsuarios() { return usuarios; }
    public static List<Emprestimo> getEmprestimos() { return emprestimos; }

    public static Livro buscarLivroPorCodigo(String codigo) {
        for (Livro livro : livros) {
            if (livro.getCodigo().equalsIgnoreCase(codigo)) return livro;
        }
        return null;
    }

    public static List<Livro> buscarLivrosPorTitulo(String titulo) {
        List<Livro> encontrados = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                encontrados.add(livro);
            }
        }
        return encontrados;
    }

    public static Usuario buscarUsuarioPorId(String id) {
        for (Usuario u : usuarios) {
            if (u.getId().equals(id)) return u;
        }
        return null;
    }

    public static void registrarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }
}