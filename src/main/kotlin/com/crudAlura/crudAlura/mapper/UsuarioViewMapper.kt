package com.crudAlura.crudAlura.mapper

import com.crudAlura.crudAlura.dto.UsuarioView
import com.crudAlura.crudAlura.model.Usuario
import org.springframework.stereotype.Component

@Component
class UsuarioViewMapper : Mapper<Usuario, UsuarioView> {
    override fun map(t: Usuario): UsuarioView {
        return UsuarioView(
            id = t.id,
            nome = t.nome,
            email = t.email
        )
    }
}