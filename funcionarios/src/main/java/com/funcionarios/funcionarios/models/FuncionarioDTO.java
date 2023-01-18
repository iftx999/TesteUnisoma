package com.funcionarios.funcionarios.models;

public class FuncionarioDTO { // Cria a classe DTO para o funcionário com o novo salário calculado
    private String cpf;
    private double novoSalario;
    private double valorReajuste; // Cria o atributo valorReajuste
    private double percentualReajuste;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getNovoSalario() {
        return novoSalario;
    }

    public void setNovoSalario(double novoSalario) {
        this.novoSalario = novoSalario;
    }

    public double getValorReajuste() {
        return valorReajuste;
    }

    public void setValorReajuste(double valorReajuste) {
        this.valorReajuste = valorReajuste;
    }

    public double getPercentualReajuste() {
        return percentualReajuste;
    }

    public void setPercentualReajuste(double percentualReajuste) {
        this.percentualReajuste = percentualReajuste;
    }
}