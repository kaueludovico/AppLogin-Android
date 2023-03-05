package com.zallpy.applogin.viewModel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zallpy.applogin.model.Login
import com.zallpy.applogin.model.ResponseToken
import com.zallpy.applogin.network.EndPoint
import com.zallpy.applogin.network.NetworkUtils
import com.zallpy.applogin.view.LoginFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(private val fragment: LoginFragment) : ViewModel() {

    var liveDataToken = MutableLiveData<ResponseToken>()

    fun authUser(username: String, password: String) {
        val endpoint = NetworkUtils.createRequest(EndPoint::class.java)
        val callback = endpoint.authUser(Login(username, password))

        callback.enqueue(object: Callback<ResponseToken> {
            override fun onResponse(call: Call<ResponseToken>, response: Response<ResponseToken>) {
                response.body()?.let {
                    liveDataToken.value = it
                }
            }
            override fun onFailure(call: Call<ResponseToken>, t: Throwable) {
                Toast.makeText(fragment.context, "ERRO > $t", Toast.LENGTH_LONG).show()
            }
        })
    }

    class LoginViewModelProvider(
        private val fragment: LoginFragment
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LoginViewModel(fragment) as T
        }
    }
}