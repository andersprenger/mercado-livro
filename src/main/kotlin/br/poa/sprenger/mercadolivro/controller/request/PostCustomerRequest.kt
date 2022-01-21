package br.poa.sprenger.mercadolivro.controller.request

import br.poa.sprenger.mercadolivro.model.CustomerModel

data class PostCustomerRequest (
    var name: String,
    var email: String
)

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(null, name, email)
}