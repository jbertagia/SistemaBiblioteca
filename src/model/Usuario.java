package model;

public class Usuario implements Cadastravel {
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

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getResumo() {
        return String.format("Usuário: %s - Telefone: %s", nome, telefone);
    }
    
    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }


}
