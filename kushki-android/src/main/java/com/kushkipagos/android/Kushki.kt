package com.kushkipagos.android

class Kushki internal constructor(private val publicMerchantId: String, currency: String,
                                  environment: Environment) {
    private val kushkiClient: KushkiClient
    private val kushkiJsonBuilder: KushkiJsonBuilder

    init {
        this.kushkiClient = KushkiClient(environment, publicMerchantId)
        this.kushkiJsonBuilder = KushkiJsonBuilder()
    }

    @Throws(KushkiException::class)
    fun requestToken(card: Card, totalAmount: Double): Transaction {
        return kushkiClient.post(TOKENS_PATH, kushkiJsonBuilder.buildJson(card, totalAmount))
    }

    @Throws(KushkiException::class)
    fun requestSubscriptionToken(card: Card): Transaction {
        return kushkiClient.post(SUBSCRIPTION_TOKENS_PATH, kushkiJsonBuilder.buildJson(card))
    }

    companion object {

        private const val TOKENS_PATH = "tokens"
        private const val SUBSCRIPTION_TOKENS_PATH = "subscription-tokens"
    }
}