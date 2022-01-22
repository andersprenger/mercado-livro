package br.poa.sprenger.mercadolivro.controller.request

import br.poa.sprenger.mercadolivro.model.CustomerModel

data class PutCustomerRequest (
    var name: String,
    var email: String
)
fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel {
    return CustomerModel(id, name, email)
}