package com.example.base_library.net_1

data class NetResultBean<T>(
    var message: String? = null, // 返回结果
    var state: String? = null, // 返回码
    var serverTime: Long = 0,
    var data: T? = null,
    var errorCode: Int = 0,
    var errorMsg: String? = null,
)

enum class NetStatus {
    LOADING,
    SUCCESS,
    COMPLETE,
    ERROR,
    CACHE
}

data class NetResource<out T>(
    val status: NetStatus,
    val state: String?,
    val data: T?,
    val message: String?,
    val serverTime: Long?
) {
    constructor(status: NetStatus, state: String?, data: T?, message: String?) : this(
        status,
        state,
        data,
        message,
        null
    )

    companion object {
        fun <T> success(data: T?): NetResource<T> {
            return NetResource(NetStatus.SUCCESS, null, data, null)
        }

        fun <T> success(data: T?, serverTime: Long?): NetResource<T> {
            return NetResource(NetStatus.SUCCESS, null, data, null, serverTime)
        }

        fun <T> success(data: T?, state: String?, serverTime: Long?): NetResource<T> {
            return NetResource(NetStatus.SUCCESS, state, data, null, serverTime)
        }

        fun <T> success(data: T?, state: String?, message: String?): NetResource<T> {
            return NetResource(NetStatus.SUCCESS, state, data, message)
        }

        fun <T> error(msg: String?, data: T?): NetResource<T> {
            return NetResource(NetStatus.ERROR, null, data, msg, 0)
        }

        fun <T> error(msg: String?, state: String?, data: T?, serverTime: Long?): NetResource<T> {
            return NetResource(NetStatus.ERROR, state, data, msg, serverTime)
        }

        fun <T> error(msg: String?, state: String?, data: T?): NetResource<T> {
            return NetResource(NetStatus.ERROR, state, data, msg, 0)
        }

        fun <T> loading(): NetResource<T> {
            return NetResource(NetStatus.LOADING, "", null, null)
        }

        fun <T> complete(data: T?): NetResource<T> {
            return NetResource(NetStatus.COMPLETE, "", data, null)
        }

        fun <T> cache(data: T?): NetResource<T> {
            return NetResource(NetStatus.CACHE, "", data, null)
        }
    }
}