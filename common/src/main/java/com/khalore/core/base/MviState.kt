package com.khalore.core.base

interface ViewState
interface ViewEvent
interface ViewSideEffect

sealed class MviState<out T : Any> {
    object None : MviState<Nothing>()
    object Loading : MviState<Nothing>()
    data class Data<C : Any>(val data: C) : MviState<C>()
    data class Error(val error: Throwable) : MviState<Nothing>() {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false
            other as Error
            if (error.javaClass != other.error.javaClass) return false

            return true
        }

        override fun hashCode(): Int {
            var result = super.hashCode()
            result = 31 * result + error.hashCode()
            return result
        }
    }

    fun asData(): T {
        return (this as Data<T>).data
    }

    fun asError(): Throwable {
        return (this as Error).error
    }

    fun asDataOrNull(): T? {
        return (this as? Data<T>)?.data
    }

    fun asErrorOrNull(): Throwable? {
        return (this as? Error)?.error
    }

    override fun toString(): String = javaClass.simpleName
}
