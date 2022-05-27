package com.example.dotaheroyokhttp.model.activity

import android.content.Intent
import android.os.Build.ID
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dotaheroyokhttp.databinding.ActivityMainBinding
import com.example.dotaheroyokhttp.model.URL
import com.example.dotaheroyokhttp.model.adapter.HeroyAdapter
import com.example.dotaheroyokhttp.model.const.Constant.ID_HERO
import com.example.dotaheroyokhttp.model.data.HeroyItemItemX
import com.example.dotaheroyokhttp.model.hero
import com.squareup.moshi.*
import okhttp3.*
import java.io.IOException


open class MainActivity : AppCompatActivity(), HeroyAdapter.ItemClickListener{
     var okHttpClient: OkHttpClient = OkHttpClient()

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        Thread.sleep(3000)
        installSplashScreen()
        setContentView(binding.root)

        DotaHeroy()

    }

    private fun DotaHeroy(){
        val request:Request =  Request.Builder().url(URL).build()
        okHttpClient.newCall(request).enqueue(object: Callback{
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                Log.d("mylog","response")

                val json: String? = response.body?.string()
                val moshi = Moshi.Builder().build()
                val list = Types.newParameterizedType(List::class.java, HeroyItemItemX::class.java)
                val adapter: JsonAdapter<List<HeroyItemItemX>> = moshi.adapter(list)
                hero = adapter.fromJson(json)!!
                runOnUiThread {
                    binding.recyclerview.layoutManager = GridLayoutManager(this@MainActivity,3)
                    binding.recyclerview.adapter = HeroyAdapter(this@MainActivity, hero)

                }
            }


        })
    }

    override fun onClickItem(position: Int) {
        val intent = Intent(this@MainActivity, HeroyDetails::class.java)
        intent.putExtra(ID_HERO,position)
        startActivity(intent)
    }


}