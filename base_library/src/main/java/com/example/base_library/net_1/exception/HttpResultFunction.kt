package com.example.base_library.net_1.exception

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.Function

class HttpResultFunction <T>:Function<Throwable, Observable<T>>{
    override fun apply(t: Throwable): Observable<T> {
        return Observable.error(NetExceptions.handleException(t))
    }
}