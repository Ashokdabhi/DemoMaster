package com.demomaster.kotlin.postData

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.demomaster.R
import com.demomaster.databinding.ActivityPostDataBinding
import com.demomaster.demo_master.apiRecyleview.pojo.User
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostDataActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPostDataBinding
    private var mContext: Context? = null
    private var restApiRequestsService: RestApiRequests? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPostDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mContext = this@PostDataActivity

        setSupportActionBar(binding.toolBare.root)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.title = resources.getString(R.string.post_data)
        }
        binding.toolBare.root.setNavigationOnClickListener { finish() }

        binding.btnSubmit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if (v!!.id==binding.btnSubmit.id){
            setValidation()
        }
    }

    private fun setValidation() {

        var isValidate=true

        val name = binding.tilName.editText!!.text.toString().trim()
        val job = binding.tilJob.editText!!.text.toString().trim()

        if (name.isEmpty()){
            isValidate=false
            binding.tilName.editText!!.error="Enter Name"
        }

        if (job.isEmpty()){
            isValidate=false
            binding.tilJob.editText!!.error="Enter Job"
        }
        if (isValidate){
            binding.progressBar.visibility=View.VISIBLE
            restApiRequestsService = ApiClient.buildService(RestApiRequests::class.java)

            val call: Call<ResponseBody> =
                restApiRequestsService!!.createUser(name,job)

            call.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    binding.progressBar.visibility=View.GONE
                    if (response.code()==201){

                        val jsonObject = JSONObject(response.body()!!.string())

                        val a =jsonObject.getString("id")
                        val b =jsonObject.getString("createdAt")

                        Toast.makeText(mContext, "" + name+"\n"+job+"\n"+a+"\n"+b, Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(mContext, "" + response.code(), Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                    Toast.makeText(mContext, "" + t.message, Toast.LENGTH_SHORT).show()
                    call.cancel()
                    binding.progressBar.visibility=View.GONE
                }
            })
        }
    }
}