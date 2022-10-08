package com.example.base_library.net_1.exception

class SelfDefineHttpException : HttpTimeException {
    constructor(e: Throwable?, state: String?) : super(e, state)
    constructor(state: String?, detailMessage: String?) : super(state, detailMessage)
    constructor(message: String?) : super(message)
}