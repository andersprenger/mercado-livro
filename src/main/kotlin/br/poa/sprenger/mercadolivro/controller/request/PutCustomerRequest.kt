package br.poa.sprenger.mercadolivro.controller.request

import br.poa.sprenger.mercadolivro.model.CustomerModel

data class PutCustomerRequest (
    var name: String,
    var email: String
)
fun PutCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(null, name, email)
}