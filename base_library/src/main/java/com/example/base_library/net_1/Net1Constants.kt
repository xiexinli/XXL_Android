package com.example.base_library.net_1

const val API_SCHEME = "https://"

const val API_WWW = "www.wanandroid.com"
const val API_MRD = "mrd.wanandroid.com"//该host无效，仅示例
const val API_APP = "app.wanandroid.com"//该host无效，仅示例

//如果是新增的域名，注意需要在【UrlInterceptor】拦截器中增加配置
const val URL_WWW = "url:www"
const val URL_MRD = "url:mrd"//该host无效，仅示例
const val URL_APP = "url:app"//该host无效，仅示例

const val API_IMPACT = "xxl.impact.com";

const val err_0x0000 = "0x0000" // Invalid API (System)                返回正常
const val err_0x0001 = "0x0001" // Invalid API (System)                API接口名称不正确
const val err_0x0002 = "0x0002" // Invalid SessionKey (System)         SessionKey不正确
const val err_0x0003 = "0x0003" // Time error over 10min (System)      时间误差超过10分钟
const val err_0x0004 = "0x0004" // Invalid response format (System)    不支持的响应格式
const val err_0x0005 = "0x0005" // Invalid API version (System)        API协议版本不正确
const val err_0x0006 = "0x0006" // Invalid encryption method (System)  不支持的参数加密方法
const val err_0x0007 = "0x0007" // Language is not supported (System)  不支持的语言
const val err_0x0008 = "0x0008" // Currency is not supported (System)  不支持的币种
const val err_0x0009 = "0x0009" // Authentication failed (System)      身份验证失败
const val err_0x0010 = "0x0010" // Time out (System)                   请求/执行超时
const val err_0x0011 = "0x0011" // Data error (System)                 数据异常
const val err_0x0012 = "0x0012" // DataBase error (System)             数据库执行失败
const val err_0x0013 = "0x0013" // Server error (System)               服务器异常
const val err_0x0014 = "0x0014" // Permission denied (System)          用户权限不够
const val err_0x0015 = "0x0015" // Service unavailable (System)        服务不可用
const val err_0x0016 = "0x0016" // Invalid signature (System)          签名无效
const val err_0x0017 = "0x0017" // Invalid app_key

//自定义error
const val err_0x1111 = "0x1111" //网络异常
const val err_0x0222 = "0x0222" //接口返回异常
const val err_0x0504 = "0x0504" //接口返回超时
const val err_0x0100 = "0x0100"
const val err_0x0104 = "0x0104"
const val err_0x0105 = "0x0105"
const val err_0x0106 = "0x0106" //解析异常