package com.demomaster.kotlin.staticrv

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.demomaster.databinding.ActivityStatickRvBinding

class StatickRVActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStatickRvBinding
    private var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStatickRvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mContext = this@StatickRVActivity

        setSupportActionBar(binding.toolBare.root)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
        binding.toolBare.root.setNavigationOnClickListener { finish() }

        val layoutManager = LinearLayoutManager(mContext)
        binding.rvStatic.layoutManager = layoutManager
        val adapter = RVAdapter(addData())
        binding.rvStatic.adapter = adapter
    }

    private fun addData(): ArrayList<String> {
        val nameList = ArrayList<String>()
        nameList.add("Test")
        nameList.add("Demo")
        nameList.add("TestDemo")
        nameList.add("DemoTest")
        nameList.add("DemoTest")
        nameList.add("DemoTest")
        nameList.add("DemoTest")
        nameList.add("DemoTest")
        nameList.add("DemoTest")
        nameList.add("DemoTest")
        nameList.add("DemoTest")
        nameList.add("DemoTest")
        nameList.add("DemoTest")
        nameList.add("DemoTest")
        nameList.add("DemoTest")
        nameList.add("DemoTest")
        nameList.add("DemoTest")
        return nameList
    }
}