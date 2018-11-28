package com.raqun.kotlinext.view

import android.app.WallpaperManager
import android.widget.ImageView

/**
 * Loads current device wallpaper to an Imageview
 */
fun ImageView.setWallpaper() {
    val wallpaperManager = WallpaperManager.getInstance(context)
    setImageDrawable(wallpaperManager.drawable)
}