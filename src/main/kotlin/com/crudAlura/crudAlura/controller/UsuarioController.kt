package com.crudAlura.crudAlura.controller

import com.crudAlura.crudAlura.dto.AtualizacaoUsuarioForm
import com.crudAlura.crudAlura.dto.UsuarioForm
import com.crudAlura.crudAlura.dto.UsuarioView
import com.crudAlura.crudAlura.service.UsuarioService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController //receber e enviar dados
@RequestMapping ("/usuarios") //informa a URI que esse controller irá manipular
class UsuarioController (private val service: UsuarioService){

    @GetMapping
    fun exibir():List<UsuarioView> {
        return service.exibir()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id:Long): UsuarioView{
        return service.buscarPorId(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrarUsuario(@RequestBody @Valid usuarioForm: UsuarioForm){ //não aceitou :Void
        return service.cadastrarUsuario(usuarioForm)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid usuarioForm: AtualizacaoUsuarioForm): ResponseEntity<UsuarioView> {
            val usuarioView = service.atualizarUsuario(usuarioForm)
            return ResponseEntity.ok(usuarioView)
    }

    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletarUsuario(@PathVariable id: Long){
        return service.deletarUsuario(id)
    }
}
