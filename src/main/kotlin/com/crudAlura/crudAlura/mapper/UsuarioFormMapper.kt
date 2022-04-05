package com.crudAlura.crudAlura.mapper

import com.crudAlura.crudAlura.dto.UsuarioForm
import com.crudAlura.crudAlura.model.Usuario
import org.springframework.stereotype.Component

@Component
class UsuarioFormMapper:Mapper<UsuarioForm, Usuario> {
    override fun map(t: UsuarioForm): Usuario {
        return Usuario(
            nome = t.nome,
            email = t.email
        )
    }


}
