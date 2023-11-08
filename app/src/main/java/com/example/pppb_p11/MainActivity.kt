package com.example.pppb_p11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.pppb_p11.databinding.ActivityMainBinding
import com.example.pppb_p11.model.Users
import com.example.pppb_p11.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val client = ApiClient.getInstance()
        val response = client.getAllUser()
        response.enqueue(object: Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
//                println(response.code())
                val namaUsers = ArrayList<String>()
                for (i in response.body()!!.data) {
                    namaUsers.add(i.employeeName)
                }
                val listAdapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, namaUsers)
                binding.lv.adapter = listAdapter
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {

            }
        })
    }
}