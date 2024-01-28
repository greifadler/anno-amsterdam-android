package nl.anno.amsterdam.network

import nl.anno.amsterdam.ApiClient
import nl.anno.amsterdam.api.BuildingsApi
import nl.anno.amsterdam.auth.ApiKeyAuth
import okhttp3.OkHttpClient

object ApiHelper {

    private val client = ApiClient()
    val api: BuildingsApi

    init {
        client.basePath = "http://fal-1.upcode-dev.at:8001/api"
//        client.authentications.put("API-KEY", ApiKeyAuth())
//        client.setApiKeyPrefix("X-")
//        client.setApiKey("O31eeBHlA1aaTNFwge7ns0qqxOc38HKk5Qz4_f2qqUI")
        api = BuildingsApi(client)
    }

}