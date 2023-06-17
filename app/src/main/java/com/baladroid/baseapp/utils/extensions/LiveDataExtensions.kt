package com.baladroid.baseapp.utils.extensions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.baladroid.baseapp.utils.livedata.SingleLiveEvent

inline fun <T, U, R> LiveData<T>.combine(
    arg: LiveData<U>,
    crossinline f: (T, U) -> R
): LiveData<R> {
    return combineAll(
        this,
        arg,
        transform = { @Suppress("UNCHECKED_CAST") f(it[0] as T, it[1] as U) }
    )
}

inline fun <T, U1, U2, R> LiveData<T>.combine(
    arg1: LiveData<U1>,
    arg2: LiveData<U2>,
    crossinline f: (T, U1, U2) -> R
): LiveData<R> {
    return combineAll(
        this,
        arg1,
        arg2,
        transform = { @Suppress("UNCHECKED_CAST") f(it[0] as T, it[1] as U1, it[2] as U2) }
    )
}

inline fun <T, U1, U2, U3, R> LiveData<T>.combine(
    arg1: LiveData<U1>,
    arg2: LiveData<U2>,
    arg3: LiveData<U3>,
    crossinline f: (T, U1, U2, U3) -> R
): LiveData<R> {
    return combineAll(
        this,
        arg1,
        arg2,
        arg3,
        transform = {
            @Suppress("UNCHECKED_CAST") f(
                it[0] as T,
                it[1] as U1,
                it[2] as U2,
                it[3] as U3
            )
        }
    )
}

inline fun <T, U1, U2, U3, U4, R> LiveData<T>.combine(
    arg1: LiveData<U1>,
    arg2: LiveData<U2>,
    arg3: LiveData<U3>,
    arg4: LiveData<U4>,
    crossinline f: (T, U1, U2, U3, U4) -> R
): LiveData<R> {
    return combineAll(
        this,
        arg1,
        arg2,
        arg3,
        arg4,
        transform = {
            @Suppress("UNCHECKED_CAST") f(
                it[0] as T,
                it[1] as U1,
                it[2] as U2,
                it[3] as U3,
                it[4] as U4
            )
        }
    )
}

inline fun <T, U1, U2, U3, U4, U5, R> LiveData<T>.combine(
    arg1: LiveData<U1>,
    arg2: LiveData<U2>,
    arg3: LiveData<U3>,
    arg4: LiveData<U4>,
    arg5: LiveData<U5>,
    crossinline f: (T, U1, U2, U3, U4, U5) -> R
): LiveData<R> {
    return combineAll(
        this,
        arg1,
        arg2,
        arg3,
        arg4,
        arg5,
        transform = {
            @Suppress("UNCHECKED_CAST") f(
                it[0] as T,
                it[1] as U1,
                it[2] as U2,
                it[3] as U3,
                it[4] as U4,
                it[5] as U5
            )
        }
    )
}

inline fun <T, U1, U2, U3, U4, U5, U6, R> LiveData<T>.combine(
    arg1: LiveData<U1>,
    arg2: LiveData<U2>,
    arg3: LiveData<U3>,
    arg4: LiveData<U4>,
    arg5: LiveData<U5>,
    arg6: LiveData<U6>,
    crossinline f: (T, U1, U2, U3, U4, U5, U6) -> R
): LiveData<R> {
    return combineAll(
        this,
        arg1,
        arg2,
        arg3,
        arg4,
        arg5,
        arg6,
        transform = {
            @Suppress("UNCHECKED_CAST") f(
                it[0] as T,
                it[1] as U1,
                it[2] as U2,
                it[3] as U3,
                it[4] as U4,
                it[5] as U5,
                it[6] as U6
            )
        }
    )
}

inline fun <T, U1, U2, U3, U4, U5, U6, U7, R> LiveData<T>.combine(
    arg1: LiveData<U1>,
    arg2: LiveData<U2>,
    arg3: LiveData<U3>,
    arg4: LiveData<U4>,
    arg5: LiveData<U5>,
    arg6: LiveData<U6>,
    arg7: LiveData<U7>,
    crossinline f: (T, U1, U2, U3, U4, U5, U6, U7) -> R
): LiveData<R> {
    return combineAll(
        this,
        arg1,
        arg2,
        arg3,
        arg4,
        arg5,
        arg6,
        arg7,
        transform = {
            @Suppress("UNCHECKED_CAST") f(
                it[0] as T,
                it[1] as U1,
                it[2] as U2,
                it[3] as U3,
                it[4] as U4,
                it[5] as U5,
                it[6] as U6,
                it[7] as U7
            )
        }
    )
}

inline fun <T, U1, U2, U3, U4, U5, U6, U7, U8, U9, U10, U11, R> LiveData<T>.combine(
    arg1: LiveData<U1>,
    arg2: LiveData<U2>,
    arg3: LiveData<U3>,
    arg4: LiveData<U4>,
    arg5: LiveData<U5>,
    arg6: LiveData<U6>,
    arg7: LiveData<U7>,
    arg8: LiveData<U8>,
    arg9: LiveData<U9>,
    arg10: LiveData<U10>,
    arg11: LiveData<U11>,
    crossinline f: (T, U1, U2, U3, U4, U5, U6, U7, U8, U9, U10, U11) -> R
): LiveData<R> {
    return combineAll(
        this,
        arg1,
        arg2,
        arg3,
        arg4,
        arg5,
        arg6,
        arg7,
        arg8,
        arg9,
        arg10,
        arg11,
        transform = {
            @Suppress("UNCHECKED_CAST") f(
                it[0] as T,
                it[1] as U1,
                it[2] as U2,
                it[3] as U3,
                it[4] as U4,
                it[5] as U5,
                it[6] as U6,
                it[7] as U7,
                it[8] as U8,
                it[9] as U9,
                it[10] as U10,
                it[11] as U11
            )
        }
    )
}

fun <T> liveDataList(vararg liveData: LiveData<T>): LiveData<List<T>> {
    return combineAll(
        *liveData,
        transform = {
            it.filterNotNull().toList().map { obj ->
                @Suppress("UNCHECKED_CAST")
                obj as T
            }
        }
    )
}

inline fun <R> combineAll(
    vararg liveData: LiveData<*>,
    crossinline transform: (Array<Any?>) -> R
): LiveData<R> {
    val result = MediatorLiveData<R>()
    val size = liveData.size
    val initiated = BooleanArray(size)
    liveData.forEachIndexed { sourceIndex, liveDate ->
        result.addSource(liveDate) {
            initiated[sourceIndex] = true
            if (initiated.all { it }) {
                val args = arrayOfNulls<Any>(size)
                for (index in 0 until size) {
                    args[index] = liveData[index].value
                }
                result.value = transform(args)
            }
        }
    }
    return result
}

inline fun <T, R : Any> LiveData<T>.mapNotNull(crossinline f: (T) -> R?): LiveData<R> {
    val result = MediatorLiveData<R>()
    result.addSource(this) {
        try {
            result.value = checkNotNull(f(it))
        } catch (ex: IllegalStateException) {
        }
    }
    return result
}

suspend fun MutableLiveData<Boolean>.withLoading(
    work: suspend () -> Unit
) {
    postValue(true)
    work()
    postValue(false)
}

val LiveData<String>.stringValue get() = this.value.orEmpty()
val LiveData<Boolean?>?.boolValue get() = this?.value ?: false

fun SingleLiveEvent<*>.emptyValue() {
    postValue(null)
}

inline fun <T> LiveData<T>.filter(crossinline f: (T) -> Boolean): LiveData<T> {
    val result = MediatorLiveData<T>()
    result.addSource(this) {
        if (f(it)) result.value = it
    }
    return result
}
