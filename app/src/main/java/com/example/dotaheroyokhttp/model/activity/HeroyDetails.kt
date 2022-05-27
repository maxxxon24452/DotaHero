package com.example.dotaheroyokhttp.model.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import coil.load
import com.example.dotaheroyokhttp.databinding.ActivityHeroyDetailsBinding
import com.example.dotaheroyokhttp.model.const.Constant.ID_HERO
import com.example.dotaheroyokhttp.model.hero

class HeroyDetails : AppCompatActivity() {
    lateinit var binding: ActivityHeroyDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroyDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val heroId = intent.getIntExtra(ID_HERO, 0)

        with(binding){
            heroNameDetails.text = hero[heroId].localized_name
            heroImageDetails.load("https://api.opendota.com${hero[heroId].img}")
            rolesDetails.text = "roles: ${hero[heroId].roles}"
            baseHealthDetails.text = "health: ${hero[heroId].base_health}"
            baseAttackMaxDetails.text = "atack max: ${hero[heroId].base_attack_max}"
            baseMana.text = "mana: ${hero[heroId].base_mana}"
        }

    }
}