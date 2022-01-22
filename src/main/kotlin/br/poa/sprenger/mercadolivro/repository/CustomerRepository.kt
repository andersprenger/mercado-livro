package br.poa.sprenger.mercadolivro.repository

import br.poa.sprenger.mercadolivro.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface CustomerRepository: CrudRepository<CustomerModel, Int> {

    fun findByNameContainingIgnoreCase(name: String): List<CustomerModel>

}