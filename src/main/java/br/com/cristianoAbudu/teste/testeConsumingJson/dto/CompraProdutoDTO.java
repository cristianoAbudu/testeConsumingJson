package br.com.cristianoAbudu.teste.testeConsumingJson.dto;

import br.com.cristianoAbudu.teste.testeConsumingJson.feign.client.data.ProdutoData;

public class CompraProdutoDTO {
    ProdutoData produto;
    Integer quantidade;

    public ProdutoData getProduto() {
        return produto;
    }

    public void setProduto(ProdutoData produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
