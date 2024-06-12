package br.com.cristianoAbudu.teste.testeConsumingJson.feign.client.data;

public class CompraData {
    public String codigo;
    public Integer quantidade;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
