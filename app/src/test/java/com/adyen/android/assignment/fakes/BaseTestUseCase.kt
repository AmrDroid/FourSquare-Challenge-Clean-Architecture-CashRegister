package com.adyen.android.assignment.fakes
import com.adyen.android.assignment.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


abstract class BaseTestUseCase<out T, in P>(private val result: Result) {

    fun execute(params: P): Flow<T> = flow {
        when (result) {
            Result.SUCCESS -> emit(getValue(params))
            Result.FAILURE -> throw Exception("Error !!")
        }
    }

    abstract fun getValue(params: P): T

}