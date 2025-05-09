package model;

public class Livro implements Cadastravel {
    private String codigo;
    private String titulo;
    private String autor;
    private int ano;
    private int exemplares;
    private String categoria;

    public Livro(String codigo, String titulo, String autor, int ano, int exemplares, String categoria) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.exemplares = exemplares;
        this.categoria = categoria;
    }

    @Override
    public String getId() {
        return this.codigo;
    }

    @Override
    public String getResumo() {
        return String.format("Livro: %s (%d) - Autor: %s", titulo, ano, autor);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    public int getExemplares() {
        return exemplares;
    }

    public String getCategoria() {
        return categoria;
    }

    public void emprestar() throws Exception {
        if (exemplares <= 0)
            throw new Exception("Livro indisponível.");
        exemplares--;
    }

    public void devolver() {
        exemplares++;
    }

}
