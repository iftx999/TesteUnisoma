package com.funcionarios.funcionarios.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity // Define que a classe é uma entidade
@Table(name = "funcionarios") // Define o nome da tabela
public class Funcionario { // Cria a classe modelo

    @Id // Define que o atributo é uma chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o atributo é auto incrementável
    private Long id; // Cria o atributo id

    private String nome; // Cria o atributo nome
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
    private String endereco;
    private double salario;

    public Funcionario() {} // Cria o construtor vazio

    public Funcionario(String nome, String cpf, LocalDate dataNascimento, String telefone, String endereco, double salario) { // Cria o construtor com parâmetros
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.endereco = endereco;
        this.salario = salario;
    }

    public Long getId() { // Cria o método get do atributo id
        return id;
    }

    public void setId(Long id) { // Cria o método set do atributo id
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}