package com.example.dotaheroyokhttp.model.data

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class HeroyItemItemX(
    val id: Int,
    val name: String,
    val localized_name: String,
    val primary_attr: String,
    val attack_type: String,
    val roles: List<String>,
    val img: String,
    val icon: String,
    val base_health: Int,
    val base_health_regen: Double,
    val base_mana: Int,
    val base_mana_regen: Double,
    val base_armor: Double,
    val base_mr: Int,
    val base_attack_min: Int,
    val base_attack_max: Int,
    val base_str: Int,
    val base_agi: Int,
    val base_int: Int,
    val str_gain: Double,
    val agi_gain: Double,
    val int_gain: Double,
    val attack_range: Int,
    val projectile_speed: Int,
    val attack_rate: Double,
    val move_speed: Int,
    val cm_enabled: Boolean,
    val legs: Int,
    val hero_id: Int
)