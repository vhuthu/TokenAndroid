package com.vhuthu.tryout2.utils

sealed class ApiState<out T> {

    data class Success<out R> (val data:R): ApiState<R>()
    data class Failaure(val msg:String):ApiState<Nothing>()
    object Loading : ApiState<Nothing>()
}
