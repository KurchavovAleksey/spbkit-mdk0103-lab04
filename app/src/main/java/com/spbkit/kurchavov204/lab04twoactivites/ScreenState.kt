package com.spbkit.kurchavov204.lab04twoactivites

import java.io.Serializable

data class ScreenState(
    val chkBox1State: Boolean,
    val chkBox2State: Boolean,
    val txtEdit1State: String  // Курчавов Алексей 204 группа СПБКИТ
) : Serializable
