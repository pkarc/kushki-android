package com.kushkipagos.android

enum class KushkiEnvironment(override val url: String) : Environment {
    TESTING("https://api-uat.kushkipagos.com/v1/"),
    STAGING("https://api-stg.kushkipagos.com/v1/"),
    PRODUCTION("https://api.kushkipagos.com/v1/");
}
