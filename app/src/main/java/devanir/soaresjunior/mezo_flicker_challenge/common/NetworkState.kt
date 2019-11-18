package devanir.soaresjunior.mezo_flicker_challenge.common

sealed class NetworkState<out T> {
    class Loading<out T> : NetworkState<T>()
    data class Success<out T>(val data: T?) : NetworkState<T>()
    data class Failure<out T>(val error: Throwable) : NetworkState<T>()
}
