package com.example.prakashmaharjan.listviewdemo

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    fun getAndroidVersions(): List<AndroidVersion> {
        return listOf(
            AndroidVersion("Android 1.0", 1),
            AndroidVersion("Android 1.1 (Petit Four)", 2),
            AndroidVersion("Android 1.5 (Cupcake)", 3),
            AndroidVersion("Android 1.6 (Donut)", 4),
            AndroidVersion("Android 2.0 (Eclair)", 5),
            AndroidVersion("Android 2.2 (Froyo)", 8),
            AndroidVersion("Android 2.3 (Gingerbread)", 9),
            AndroidVersion("Android 3.0 (Honeycomb)", 11),
            AndroidVersion("Android 4.0 (Ice Cream Sandwich)", 14),
            AndroidVersion("Android 4.1 (Jelly Bean)", 16),
            AndroidVersion("Android 4.4 (Kitkat)", 19),
            AndroidVersion("Android 5.0 (Lollipop)", 21),
            AndroidVersion("Android 6.0 (Marshmallow)", 23),
            AndroidVersion("Android 7.0 (Nougat)", 24),
            AndroidVersion("Android 8.0 (Oreo)", 26),
            AndroidVersion("Android 9.0 (Pie)", 28),
            AndroidVersion("Android 10 (Quince Tart)", 29),
            AndroidVersion("Android 11 (Red Velvet Cake)", 30),
            AndroidVersion("Android 12 (Snow Cone)", 31),
            AndroidVersion("Android 12L (Snow Cone v2)", 32),
            AndroidVersion("Android 13 (Tiramisu)", 33),
            AndroidVersion("Android 14 (Upside Down Cake)", 34),
            AndroidVersion("Android 15 (Vanilla Ice Cream)", 35),
            AndroidVersion("Android 16 (Baklava)", 36),
        )
    }
}
