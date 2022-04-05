package com.crudAlura.crudAlura.mapper

interface Mapper<T, U> {

    fun map(t: T): U
}
