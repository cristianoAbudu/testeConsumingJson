package br.com.cristianoAbudu.teste.testeConsumingJson.dto;

import br.com.cristianoAbudu.teste.testeConsumingJson.feign.client.data.ProdutoData;

import java.math.BigDecimal;
import java.util.List;

public class CompraDTO {
    String nomeCliente;
    String cpf;
    List<CompraProdutoDTO> produtos;
    BigDecimal valorTotalCompra;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<CompraProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<CompraProdutoDTO> produtos) {
        this.produtos = produtos;
    }

    public BigDecimal getValorTotalCompra() {
        return valorTotalCompra;
    }

    public void setValorTotalCompra(BigDecimal valorTotalCompra) {
        this.valorTotalCompra = valorTotalCompra;
    }
}
