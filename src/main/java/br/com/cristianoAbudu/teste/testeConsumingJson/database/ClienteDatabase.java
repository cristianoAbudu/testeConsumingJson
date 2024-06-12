package br.com.cristianoAbudu.teste.testeConsumingJson.database;

import br.com.cristianoAbudu.teste.testeConsumingJson.feign.client.ClienteClient;
import br.com.cristianoAbudu.teste.testeConsumingJson.feign.client.data.ClienteData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteDatabase {

    @Autowired
    ClienteClient clienteClient;

    public List<ClienteData> findAll(){
        return clienteClient.get();
    }

    public Optional<ClienteData> findByCpf(String cpf) {
        for(ClienteData clienteData : findAll()){
            if(cpf!=null && cpf.equals(clienteData.getCpf())){
                return Optional.of(clienteData);
            }
        }
        return Optional.empty();
    }
}
