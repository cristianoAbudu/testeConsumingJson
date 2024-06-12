package br.com.cristianoAbudu.teste.testeConsumingJson.feign.client.data;

import java.math.BigDecimal;

public class ProdutoData {
    public Integer codigo;
    public String tipo_vinho;
    public BigDecimal preco;
    public String safra;
    public Integer ano_compra;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipo_vinho() {
        return tipo_vinho;
    }

    public void setTipo_vinho(String tipo_vinho) {
        this.tipo_vinho = tipo_vinho;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getSafra() {
        return safra;
    }

    public void setSafra(String safra) {
        this.safra = safra;
    }

    public Integer getAno_compra() {
        return ano_compra;
    }

    public void setAno_compra(Integer ano_compra) {
        this.ano_compra = ano_compra;
    }
}
