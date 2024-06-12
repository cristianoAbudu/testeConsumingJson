package br.com.cristianoAbudu.teste.testeConsumingJson.feign.client;

import br.com.cristianoAbudu.teste.testeConsumingJson.feign.client.data.ClienteData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(
        name="ClienteClient",
        url = "https://rgr3viiqdl8sikgv.public.blob.vercel-storage.com/clientes-Vz1U6aR3GTsjb3W8BRJhcNKmA81pVh.json")
public interface ClienteClient {
    @RequestMapping(method = RequestMethod.GET)
    List<ClienteData> get();
}