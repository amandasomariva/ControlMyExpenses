
package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.enterprise.EntityNotFoundException;
import com.bethacode.LocadoraVeiculos.enterprise.ValidationException;
import com.bethacode.LocadoraVeiculos.model.Usuario;
import com.bethacode.LocadoraVeiculos.repository.UsuarioRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource extends AbstractResource {

    @Autowired
    private UsuarioRepository repository;

    /*@GetMapping
    public List<GastoDTO> getGasto() {
        return repository.findAll().stream().map(p -> GastoDTO.toDTO(p)).collect(Collectors.toList());
    }
    ;*/

    @GetMapping
    public List<UsuarioDTO> getUsuario(@QuerydslPredicate(root = Usuario.class) Predicate predicate) {
        List<UsuarioDTO> result = new ArrayList<>();
        Iterable<Usuario> all = repository.findAll(predicate);
        all.forEach(f -> result.add(UsuarioDTO.toDTO(f)));
        return result;
    }


    @GetMapping("/{id}")
    public UsuarioDTO getById(@PathVariable(value = "id") Long usuarioId) throws EntityNotFoundException {

        Usuario usuarioFind = repository.findById(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado com ID :: " + usuarioId));

        return UsuarioDTO.toDTO(usuarioFind);
    }


    @PostMapping
    public UsuarioDTO create(@Valid @RequestBody Usuario usuario)  throws ValidationException {

        List<Usuario> byCpf = repository.findByCpf(usuario.getCpf());

        if (!byCpf.isEmpty()) {
            throw new ValidationException("Já existe uma pessoa com o mesmo cpf! 2x");
        }

        return UsuarioDTO.toDTO(repository.save(usuario));
    }


    @PutMapping("/{id}")
    public UsuarioDTO update(@PathVariable(value = "id") Long usuarioId,
                           @RequestBody Usuario usuario) throws EntityNotFoundException {
        Usuario usuarioFind = repository.findById(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado com ID :: " + usuarioId));
        usuarioFind.setId(usuario.getId());
        usuarioFind.setNome(usuario.getNome());
        usuarioFind.setDataNascimento(usuario.getDataNascimento());
        usuarioFind.setSexo(usuario.getSexo());
        usuarioFind.setCpf(usuario.getCpf());
        usuarioFind.setEmail(usuario.getEmail());

        return UsuarioDTO.toDTO(repository.save(usuarioFind));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long usuarioId) throws EntityNotFoundException {
        Usuario usuarioFind = repository.findById(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado com ID :: " + usuarioId));

        repository.delete(usuarioFind);

        return ResponseEntity.noContent().build();
    }

}