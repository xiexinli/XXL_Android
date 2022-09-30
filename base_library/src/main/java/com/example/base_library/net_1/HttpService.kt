package com.example.base_library.net_1

import retrofit2.http.*

interface HttpService {

    @Headers(URL_WWW)
    @FormUrlEncoded
    @POST("article/query/0/json")
    suspend fun postOne(@Field("k") keyword: String): NetResultBean<Any>

    @Headers(URL_MRD)
    @FormUrlEncoded
    @POST("/appsearch/storeSearch.do")
    suspend fun postTwo(@FieldMap params: Map<String, String?>): NetResultBean<Any>

    @Headers(URL_MRD)
    @FormUrlEncoded
    @POST
    suspend fun postUrl(
        @Url url: String,
        @FieldMap params: Map<String, String?>
    ): NetResultBean<Any>

    @Headers(URL_APP)
    @GET("/checkout/cartSplit/buyAgainList.do")
    suspend fun getOne(@QueryMap params: Map<String, String?>): NetResultBean<Any>


}

data class NetResultBean<T>(
    var message: String? = null, // 返回结果
    var state: String? = null, // 返回码
    var serverTime: Long = 0,
    var data: T? = null
)
