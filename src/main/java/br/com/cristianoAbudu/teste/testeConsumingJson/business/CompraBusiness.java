package br.com.cristianoAbudu.teste.testeConsumingJson.business;

import br.com.cristianoAbudu.teste.testeConsumingJson.database.ClienteDatabase;
import br.com.cristianoAbudu.teste.testeConsumingJson.database.ProdutoDatabase;
import br.com.cristianoAbudu.teste.testeConsumingJson.dto.CompraDTO;
import br.com.cristianoAbudu.teste.testeConsumingJson.dto.CompraProdutoDTO;
import br.com.cristianoAbudu.teste.testeConsumingJson.feign.client.data.ClienteData;
import br.com.cristianoAbudu.teste.testeConsumingJson.feign.client.data.CompraData;
import br.com.cristianoAbudu.teste.testeConsumingJson.feign.client.data.ProdutoData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class CompraBusiness {
    @Autowired
    ClienteDatabase clienteDatabase;

    @Autowired
    ProdutoDatabase produtoDatabase;

    public List<CompraDTO> getAllOrderByValorCompra() {
        List<ClienteData> clienteDataList = clienteDatabase.findAll();

        List<CompraDTO> compraDTOList = new ArrayList<>();
        for (ClienteData clienteData : clienteDataList) {

            CompraDTO compraDTO = new CompraDTO();
            compraDTO.setValorTotalCompra(BigDecimal.ZERO);
            compraDTO.setCpf(clienteData.getCpf());
            compraDTO.setNomeCliente(clienteData.getNome());
            compraDTO.setProdutos(new ArrayList<>());
            for (CompraData compraData : clienteData.getCompras()) {
                ProdutoData produtoData = produtoDatabase.findByCodigo(compraData.getCodigo()).get();
                CompraProdutoDTO compraProdutoDTO = new CompraProdutoDTO();
                compraProdutoDTO.setProduto(produtoData);
                compraProdutoDTO.setQuantidade(compraData.getQuantidade());
                compraDTO.setValorTotalCompra(compraDTO.getValorTotalCompra().add(produtoData.getPreco().multiply(BigDecimal.valueOf(compraData.getQuantidade()))));
                compraDTO.getProdutos().add(compraProdutoDTO);
            }

            compraDTOList.add(compraDTO);
        }
        return compraDTOList.stream().sorted(
                (o1, o2) -> o1.getValorTotalCompra().compareTo(o2.getValorTotalCompra())
        ).toList();
    }

    public CompraDTO getMaiorCompra(Integer ano) {

        List<CompraDTO> allOrderByValorCompra = getAllOrderByValorCompra();

        List<CompraDTO> comprasDoAno = new ArrayList<>();

        for(CompraDTO compraDTO : allOrderByValorCompra){
            for(CompraProdutoDTO compraProdutoDTO : compraDTO.getProdutos()){
                if(compraProdutoDTO.getProduto().getAno_compra().equals(ano)){
                    comprasDoAno.add(compraDTO);
                }
            }
        }

        return comprasDoAno.get(comprasDoAno.size()-1);
    }

    public List<ClienteData> getClientesFieis() {
        return clienteDatabase.findAll().stream().sorted((o1, o2) -> o1.getCompras().size()>(o2.getCompras().size())?-1:1).toList().subList(0, 3);
    }

    public ProdutoData getRecomendacao(String cpf) {
        Optional<ClienteData> clienteData = clienteDatabase.findByCpf(cpf);

        Map<String, Integer> tipoQuantidadeMap = new HashMap<>();
        for(CompraData compraData : clienteData.get().getCompras()){
            ProdutoData produtoData = produtoDatabase.findByCodigo(compraData.getCodigo()).get();
            if(tipoQuantidadeMap.get(produtoData.getTipo_vinho()) == null){
                tipoQuantidadeMap.put(produtoData.getTipo_vinho(), 1);
            }else{
                tipoQuantidadeMap.put(produtoData.getTipo_vinho(), tipoQuantidadeMap.get(produtoData.getTipo_vinho())+1);
            }
        }

        Integer maiorQuantidade=0;
        String tipoVinhoPreferido = null;
        for(String tipoVinho : tipoQuantidadeMap.keySet()){
            if(maiorQuantidade < tipoQuantidadeMap.get(tipoVinho)){
                tipoVinhoPreferido = tipoVinho;
            }
        }
        List<ProdutoData> byTipoVinho = produtoDatabase.findByTipo_vinho(tipoVinhoPreferido);
        return byTipoVinho.get(new Random().nextInt(byTipoVinho.size()));

    }
}
