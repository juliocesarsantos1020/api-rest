package br.com.estudos.api.service;

import br.com.estudos.api.domain.Cliente;
import br.com.estudos.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository repository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.repository = clienteRepository;
    }

    @Transactional
    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

    public List<Cliente> buscarTodos() {
        return repository.findAll();
    }
}