package com.pmprogramms.koinexample.data

data class CatFact(
    var status: Status? = null,
    var _id: String? = null,
    var user: String? = null,
    var text: String? = null,
    var __v: Int = 0,
    var source: String? = null,
    var updatedAt: String? = null,
    var type: String? = null,
    var createdAt: String? = null,
    var deleted: Boolean = false,
    var used: Boolean = false,
)

data class Status(
    var verified: Boolean = false,
    var sentCount: Int = 0
)
