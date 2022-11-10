package com.demomaster.kotlin.glideDemo

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.demomaster.R
import com.demomaster.databinding.ActivityListBinding
import com.google.gson.Gson
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class GlideListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mContext = this@GlideListActivity

        setSupportActionBar(binding.toolBare.root)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.title = resources.getString(R.string.glide_load_image)
        }
        binding.toolBare.root.setNavigationOnClickListener { finish() }

        val retrofit = Retrofit.Builder()
            .baseUrl("https://demonuts.com/Demonuts/JsonTest/Tennis/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiInterface = retrofit.create(APIInterface::class.java)

        val call: Call<ResponseBody> = apiInterface.getResponse()!!

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                binding.progressBar.visibility = View.GONE
                if (response.code() == 200) {
                    val jsonObject = JSONObject(response.body()!!.string())
                    if (jsonObject.getBoolean("status")) {
                        val array = jsonObject.getJSONArray("data")
                        val dataModelList = ArrayList<DataModel>()
                        for (i in 0 until array.length()) {
                            val dataModel = Gson().fromJson(
                                array.getJSONObject(i).toString(),
                                DataModel::class.java
                            )
                            dataModelList.add(dataModel)
                        }
                        binding.rvImageDemo.layoutManager = LinearLayoutManager(mContext)
                        val adapter = GlideAdapter(mContext as GlideListActivity, dataModelList)
                        binding.rvImageDemo.adapter = adapter
                    } else {
                        Toast.makeText(
                            mContext,
                            "" + jsonObject.getBoolean("status"),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else {
                    Toast.makeText(mContext, "" + response.code(), Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                binding.progressBar.visibility = View.GONE
                Log.e("onFailure", "" + t.message)
            }
        })
    }

    interface APIInterface {
        @GET("json_parsing.php")
        fun getResponse(): Call<ResponseBody>?
    }
}