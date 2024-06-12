package br.com.cristianoAbudu.teste.testeConsumingJson.controller;

import br.com.cristianoAbudu.teste.testeConsumingJson.business.CompraBusiness;
import br.com.cristianoAbudu.teste.testeConsumingJson.dto.CompraDTO;
import br.com.cristianoAbudu.teste.testeConsumingJson.feign.client.ClienteClient;
import br.com.cristianoAbudu.teste.testeConsumingJson.feign.client.ProdutoClient;
import br.com.cristianoAbudu.teste.testeConsumingJson.feign.client.data.ClienteData;
import br.com.cristianoAbudu.teste.testeConsumingJson.feign.client.data.ProdutoData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientesRESTController {

    @Autowired
    CompraBusiness compraBusiness;

    /*
        http://localhost:8080
    */
    @GetMapping
    public List<CompraDTO> getAllOrderByValorCompra(){
        return compraBusiness.getAllOrderByValorCompra();
    }

    /*
        http://localhost:8080/maior_compra/2018
     */
    // Nao existem dados do ano da compra para cada ano, entao usei o ano da compra do produto.json, quando uma compra
    // tem um produto.json comprado naquele ano considero aquela compra para calcular a maior compra do ano.
    @GetMapping("/maior_compra/{ano}")
    public CompraDTO getMaiorCompra(
        @PathVariable Integer ano
    ){
        return compraBusiness.getMaiorCompra(ano);
    }

    /*
        http://localhost:8080/clientes-fieis
     */
    // Como o requisito não especifica, irei considerar os 3 clientes que mais fizeram compras, independente do valor
    @GetMapping("/clientes-fieis")
    public List<ClienteData> getClientesFieis(){
        return compraBusiness.getClientesFieis();
    }

    /*
        http://localhost:8080/recomendacao/20623850567/tipo
     */
    @GetMapping("/recomendacao/{cliente}/tipo")
    public ProdutoData getRecomendacao(
        @PathVariable String cliente
    ){
        return compraBusiness.getRecomendacao(cliente);
    }

}
