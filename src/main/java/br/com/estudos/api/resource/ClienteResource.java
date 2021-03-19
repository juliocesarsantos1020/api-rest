package br.com.estudos.api.resource;

import br.com.estudos.api.domain.Cliente;
import br.com.estudos.api.dto.ClienteCadastroDTO;
import br.com.estudos.api.mapper.ClienteMapper;
import br.com.estudos.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/clientes")
public class ClienteResource {

    private ClienteService service;
    private ClienteMapper clienteMapper;

    public ClienteResource(ClienteService service, ClienteMapper clienteMapper) {
        this.service = service;
        this.clienteMapper = clienteMapper;
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody ClienteCadastroDTO clienteCadastroDTO) {
        Cliente  cliente = clienteMapper.converterParaDominio(clienteCadastroDTO);
        Cliente clienteSalvo = service.salvar(cliente);
        return new ResponseEntity(clienteSalvo, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Cliente> buscarTodos() {
        return service.buscarTodos();
    }

}
