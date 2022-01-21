package br.poa.sprenger.mercadolivro.controller

import br.poa.sprenger.mercadolivro.controller.request.PostCustomerRequest
import br.poa.sprenger.mercadolivro.controller.request.PutCustomerRequest
import br.poa.sprenger.mercadolivro.model.CustomerModel
import br.poa.sprenger.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customers")
class CustomerController(val service: CustomerService) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll(@RequestParam name: String?): List<CustomerModel> {
        return service.getAll(name)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: PostCustomerRequest) {
        service.createCustomer(customer)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getCustomer(@PathVariable id: Int): CustomerModel {
        return service.getCustomer(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: Int, @RequestBody customer: PutCustomerRequest) {
        return service.updateCustomer(id, customer)
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) {
        service.delete(id)
    }
}