package br.com.cristianoAbudu.teste.testeConsumingJson.feign.client;

import br.com.cristianoAbudu.teste.testeConsumingJson.feign.client.data.ProdutoData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(
        name="ProdutoClient",
        url = "https://rgr3viiqdl8sikgv.public.blob.vercel-storage.com/produtos-mnboX5IPl6VgG390FECTKqHsD9SkLS.json")
public interface ProdutoClient {
    @RequestMapping(method = RequestMethod.GET)
    List<ProdutoData> get();
}