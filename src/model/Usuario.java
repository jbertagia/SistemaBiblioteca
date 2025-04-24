package model;

public class Usuario {
    private String id;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;

    public Usuario(String id, String nome, String telefone, String endereco, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String getEndereco() { return endereco; }
    public String getEmail() { return email; }
}