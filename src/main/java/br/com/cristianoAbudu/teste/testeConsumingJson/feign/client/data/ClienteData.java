package br.com.cristianoAbudu.teste.testeConsumingJson.feign.client.data;

import java.util.List;

public class ClienteData {
    public String nome;
    public String cpf;
    public List<CompraData> compras;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<CompraData> getCompras() {
        return compras;
    }

    public void setCompras(List<CompraData> compras) {
        this.compras = compras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
