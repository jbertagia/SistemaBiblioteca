package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevista;
    private LocalDate dataDevolucao;

    public Emprestimo(Usuario usuario, Livro livro, LocalDate dataEmprestimo, LocalDate dataPrevista) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevista = dataPrevista;
    }

    public void registrarDevolucao() {
        this.dataDevolucao = LocalDate.now();
        livro.devolver();
    }

    public long diasAtraso() {
        if (dataDevolucao == null) return 0;
        long atraso = ChronoUnit.DAYS.between(dataPrevista, dataDevolucao);
        return atraso > 0 ? atraso : 0;
    }

    public Usuario getUsuario() { return usuario; }
    public Livro getLivro() { return livro; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public LocalDate getDataPrevista() { return dataPrevista; }
    public LocalDate getDataDevolucao() { return dataDevolucao; }
}