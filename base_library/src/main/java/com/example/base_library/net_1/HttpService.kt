package com.example.base_library.net_1

import com.example.base_library.data.ArticlesBean
import retrofit2.http.*

interface HttpService {

    @Headers(URL_WWW)
    @GET("article/list/0/json")
    suspend fun getListArticle(@Field("page_size") keyword: String?): NetResultBean<ArticlesBean>

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