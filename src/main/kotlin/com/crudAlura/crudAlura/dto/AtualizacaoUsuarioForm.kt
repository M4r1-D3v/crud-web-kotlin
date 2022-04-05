package com.crudAlura.crudAlura.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class AtualizacaoUsuarioForm(
    @field: NotNull
    val id: Long,
    @field:Size(min = 5, max = 100)
    @field : NotEmpty
    val email: String
)



