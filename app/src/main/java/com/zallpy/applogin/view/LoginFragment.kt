package com.zallpy.applogin.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.zallpy.applogin.R
import com.zallpy.applogin.databinding.FragmentLoginBinding
import com.zallpy.applogin.viewModel.LoginViewModel

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        binding?.buttonLogin?.setOnClickListener {
            validateLogin()
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(
            this,
            LoginViewModel.LoginViewModelProvider(this)
        )[LoginViewModel::class.java]
    }

    private fun validateLogin() {
        binding?.let {
            viewModel.authUser(
                it.editTextEmail.text.toString(),
                it.editTextPassword.text.toString())
        }
        viewModel.liveDataToken.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), "TOKEN = $it", Toast.LENGTH_LONG).show()
        })
    }
}