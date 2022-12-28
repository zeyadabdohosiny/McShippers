package com.cdt.sr.base.entities

import com.google.gson.annotations.SerializedName


data class APIResponse<D>(
    @SerializedName("isSucceed")
    var isSucceed: Boolean?,
    @SerializedName("message")
    var message: String?,
    @SerializedName("Result")
    var Result: D?
)