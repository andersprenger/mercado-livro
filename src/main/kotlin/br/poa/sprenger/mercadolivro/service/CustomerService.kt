package br.poa.sprenger.mercadolivro.service

import br.poa.sprenger.mercadolivro.model.CustomerModel
import br.poa.sprenger.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(val customerRepository: CustomerRepository) {

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContainingIgnoreCase(name)
        }

        return customerRepository.findAll().toList()
    }

    fun getCustomer(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow()
    }

    fun updateCustomer(customer: CustomerModel) {
        if (!customerRepository.existsById(customer.id!!)) {
            throw NoSuchElementException()
        }

        customerRepository.save(customer)
    }

    fun createCustomer(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun delete(id: Int) {
        if (!customerRepository.existsById(id)) {
            throw Exception()
        }

        customerRepository.deleteById(id)
    }
}