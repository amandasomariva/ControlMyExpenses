package com.betha.exemplo.exemplo.enterprise;

import com.betha.exemplo.exemplo.model.Comentario;
import com.betha.exemplo.exemplo.model.ContaUsuario;

import java.util.Set;

public interface IPublicavel {
    public ContaUsuario getUsuarioPublicou();

    public Set<Comentario> getComentarios();
}
