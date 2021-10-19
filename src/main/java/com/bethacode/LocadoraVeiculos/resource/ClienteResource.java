package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.enterprise.EntityNotFoundException;
import com.bethacode.LocadoraVeiculos.enterprise.ValidationException;
import com.bethacode.LocadoraVeiculos.model.Cliente;
import com.bethacode.LocadoraVeiculos.model.Modelo;
import com.bethacode.LocadoraVeiculos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clientes")
public class ClienteResource extends AbstractResource {

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public List<ClienteDTO> getClientes() {
        return repository.findAll().stream().map(p -> ClienteDTO.toDTO(p)).collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public ClienteDTO getById(@PathVariable(value = "id") Long clienteId) throws EntityNotFoundException {

        Cliente clienteFind = repository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID :: " + clienteId));

        return ClienteDTO.toDTO(clienteFind);
    }


    @PostMapping
    public ClienteDTO create(@Valid @RequestBody Cliente cliente)  throws ValidationException {

        List<Cliente> byNome = repository.findByDocumento(cliente.getNome());

        if (!byNome.isEmpty()) {
            throw new ValidationException("Já existe um cliente com o mesmo documento! 2x");
        }

        return ClienteDTO.toDTO(repository.save(cliente));
    }


    @PutMapping("/{id}")
    public ClienteDTO update(@PathVariable(value = "id") Long clienteId,
                             @RequestBody Cliente cliente) throws EntityNotFoundException {
        Cliente clienteFind = repository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID :: " + clienteId));
        clienteFind.setId(cliente.getId());
        clienteFind.setNome(cliente.getNome());
        clienteFind.setTipoDocumento(cliente.getTipoDocumento());
        clienteFind.setDocumento(cliente.getDocumento());
        clienteFind.setDataNascimento(cliente.getDataNascimento());
        clienteFind.setCidade(cliente.getCidade());


        return ClienteDTO.toDTO(repository.save(clienteFind));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long clienteId) throws EntityNotFoundException {
        Cliente clienteFind = repository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID :: " + clienteId));

        repository.delete(clienteFind);

        return ResponseEntity.noContent().build();
    }

}
