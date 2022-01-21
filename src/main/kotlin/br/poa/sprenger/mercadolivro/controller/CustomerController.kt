package br.poa.sprenger.mercadolivro.controller

import br.poa.sprenger.mercadolivro.controller.request.PostCustomerRequest
import br.poa.sprenger.mercadolivro.controller.request.PutCustomerRequest
import br.poa.sprenger.mercadolivro.model.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("customers")
class CustomerController {

    val customers = mutableListOf<CustomerModel>()

    @GetMapping
    fun getAll(): List<CustomerModel> {
        return customers
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): CustomerModel {
        try {
            return customers[id - 1]
        } catch (e: IndexOutOfBoundsException) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.localizedMessage)
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: Int, @RequestBody customer: PutCustomerRequest) {
        try {
            customers.first {it.id == "$id"}.let {
                it.name = customer.name
                it.email = customer.email
            }
        } catch (e: NoSuchElementException) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.localizedMessage)
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: PostCustomerRequest) {
        customers.add(CustomerModel("${customers.size + 1}", customer.name, customer.email))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) {
        val removed = customers.removeIf { it.id == id }
        if (!removed) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "There's not any element with this id.")
        }
    }
}