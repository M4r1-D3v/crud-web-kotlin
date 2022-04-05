package com.crudAlura.crudAlura.service

import com.crudAlura.crudAlura.dto.AtualizacaoUsuarioForm
import com.crudAlura.crudAlura.dto.UsuarioForm
import com.crudAlura.crudAlura.dto.UsuarioView
import com.crudAlura.crudAlura.mapper.UsuarioFormMapper
import com.crudAlura.crudAlura.mapper.UsuarioViewMapper
import com.crudAlura.crudAlura.model.Usuario
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class UsuarioService(
    private var usuarios: List<Usuario> = ArrayList(), private val usuarioViewMapper: UsuarioViewMapper,
    private val usuarioFormMapper: UsuarioFormMapper
) {

    fun exibir(): List<UsuarioView> {
        return usuarios.stream().map { u ->
            usuarioViewMapper.map(u)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long?): UsuarioView {
        val usuario = usuarios.stream().filter {  //não entendi stream, estudar!
                u ->
            u.id == id
        }.findFirst().get()
        return usuarioViewMapper.map(usuario)
    }

    fun cadastrarUsuario(usuarioForm: UsuarioForm) {

        val usuario = usuarioFormMapper.map(usuarioForm)
        usuario.id = usuarios.size.toLong() + 1
        usuarios = usuarios.plus(usuario)
    }

    fun atualizarUsuario(usuarioForm: AtualizacaoUsuarioForm): UsuarioView {
        val usuario = usuarios.stream().filter { u ->
            u.id == usuarioForm.id
        }.findFirst().get()
        val usuarioAtulizado = Usuario(
            id = usuarioForm.id,
            nome = usuario.nome,
            email = usuarioForm.email
            )
        usuarios = usuarios.minus(usuario).plus(usuarioAtulizado)
        return usuarioViewMapper.map(usuarioAtulizado)

    }

    fun deletarUsuario(id: Long) {
        val usuario = usuarios.stream().filter { u ->
            u.id == id
        }.findFirst().get()
        usuarios = usuarios.minus(usuario)

    }


}