package model;

import java.util.*;

public class Biblioteca {
    private static List<Cadastravel> cadastraveis = new ArrayList<>();
    private static List<Emprestimo> emprestimos = new ArrayList<>();

    public static void adicionarCadastravel(Cadastravel c) {
        cadastraveis.add(c);
    }

    public static Livro buscarLivroPorCodigo(String codigo) {
        for (Cadastravel c : cadastraveis) {
            if (c instanceof Livro) {
                Livro l = (Livro) c;
                if (l.getCodigo().equalsIgnoreCase(codigo)) {
                    return l;
                }
            }
        }
        return null;
    }

    public static List<Livro> buscarLivrosPorTitulo(String titulo) {
        List<Livro> encontrados = new ArrayList<>();
        for (Cadastravel c : cadastraveis) {
            if (c instanceof Livro) {
                Livro l = (Livro) c;
                if (l.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                    encontrados.add(l);
                }
            }
        }
        return encontrados;
    }

    public static Usuario buscarUsuarioPorId(String id) {
        for (Cadastravel c : cadastraveis) {
            if (c instanceof Usuario) {
                Usuario u = (Usuario) c;
                if (u.getId().equalsIgnoreCase(id)) {
                    return u;
                }
            }
        }
        return null;
    }

    public static List<Livro> getLivros() {
        List<Livro> livros = new ArrayList<>();
        for (Cadastravel c : cadastraveis) {
            if (c instanceof Livro) {
                livros.add((Livro) c);
            }
        }
        return livros;
    }

    public static void registrarEmprestimo(Emprestimo e) {
        emprestimos.add(e);
    }

    public static List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}
