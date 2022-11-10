package com.demomaster.kotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.demomaster.R
import com.demomaster.databinding.ActivityDemoMasterBinding
import com.demomaster.kotlin.glideDemo.GlideListActivity
import com.demomaster.kotlin.postData.PostDataActivity
import com.demomaster.kotlin.staticrv.StatickRVActivity

class MainKotlinActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityDemoMasterBinding
    private var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoMasterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mContext = this@MainKotlinActivity

        setSupportActionBar(binding.toolBare.root)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.title = "Kotlin Logic"
        }
        binding.toolBare.root.setNavigationOnClickListener { finish() }

        binding.btnRecycleViewStatic.setOnClickListener(this)
        binding.btnRecycleViewList.text = resources.getString(R.string.glide_load_image)
        binding.btnRecycleViewList.setOnClickListener(this)
        binding.btnApiRecycleview.setOnClickListener(this)
        binding.btnApiRecycleview.text=resources.getString(R.string.post_data)


    }

    override fun onClick(v: View?) {
        if (v!!.id == binding.btnRecycleViewStatic.id) {
            val intent = Intent(mContext, StatickRVActivity::class.java)
            startActivity(intent)
        } else if (v.id == binding.btnRecycleViewList.id) {
            startActivity(Intent(mContext, GlideListActivity::class.java))
        }else if (v.id==binding.btnApiRecycleview.id){
            startActivity(Intent(mContext,PostDataActivity::class.java))
        }
    }
}