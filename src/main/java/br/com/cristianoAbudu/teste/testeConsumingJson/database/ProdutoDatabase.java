package br.com.cristianoAbudu.teste.testeConsumingJson.database;

import br.com.cristianoAbudu.teste.testeConsumingJson.feign.client.ProdutoClient;
import br.com.cristianoAbudu.teste.testeConsumingJson.feign.client.data.ProdutoData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoDatabase {

    @Autowired
    ProdutoClient produtoClient;

    public List<ProdutoData> findAll(){
        return produtoClient.get();
    }

    public Optional<ProdutoData> findByCodigo(String codigo){
        for(ProdutoData produtoData :produtoClient.get()){
            if(codigo!=null && codigo.equals(produtoData.getCodigo().toString())){
                return Optional.of(produtoData);
            }
        }
        return Optional.empty();
    }

    public List<ProdutoData> findByTipo_vinho(String tipoVinho){

        List<ProdutoData> produtoDataList = new ArrayList<>();
        for(ProdutoData produtoData :produtoClient.get()){
            if(tipoVinho!=null && tipoVinho.equals(produtoData.getTipo_vinho())){
                produtoDataList.add(produtoData);
            }
        }
        return produtoDataList;
    }
}
