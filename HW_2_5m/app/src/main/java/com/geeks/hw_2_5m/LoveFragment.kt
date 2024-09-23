package com.geeks.hw_2_5m

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.geeks.hw_2_5m.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoveFragment : Fragment() {
    private lateinit var binding: ActivityMainBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        initListener()
    }
        private fun initListener() = with(binding){
            btnCalculateButton.setOnClickListener{
                RetrofitService.api.getPercentage(
                    firstName = edFirstName.text.toString(),
                    secondName = edSecondName.text.toString(),
                    host = "love-calculator.p.rapidapi.com",
                    key = "bba0e0acaemsh38fla7b99023527p1a7a8fjsn26046b35aa96"
                ).enqueue(object : Callback<LoveModel> {
                    @SuppressLint("SuspiciousIndentation")
                    override fun onResponse(call : Call<LoveModel>, response : Response<LoveModel>) {
                        if (response.isSuccessful && response.body() != null) {
                            val result = response.body()
                            setFragmentResult(
                                "key", bundleOf(
                                    "data" to result
                                )
                            )
                            findNavController().navigate(R.id.tv_resultText)
                        }
                    }
                    override fun onFailure(call : Call<LoveModel>, response : Throwable) {
                        
                    }

                })
            }
        }

    private fun findNavController(): Any {
        TODO("Not yet implemented")
    }

    private fun setFragmentResult(s: String, bundleOf: Bundle) {
        TODO("Not yet implemented")
    }


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(R.layout.fragment_result, container, false)
        }

    }

private fun Any.navigate(tvResulttext: Int) {

}

