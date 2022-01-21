package br.poa.sprenger.mercadolivro.service

import br.poa.sprenger.mercadolivro.model.CustomerModel
import org.springframework.stereotype.Service

@Service
class CustomerService {
    val customers = mutableListOf<CustomerModel>()
    var counter: Int = 0

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }
        }

        return customers
    }

    fun getCustomer(id: Int): CustomerModel {
        return customers[id - 1]
    }

    fun updateCustomer(id: Int, customer: CustomerModel) {
        customers.first { it.id == id }.let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun createCustomer(customer: CustomerModel) {
        customer.id = ++counter
        customers.add(customer)
    }

    fun delete(id: Int) {
        customers.removeIf { it.id == id }
    }
}