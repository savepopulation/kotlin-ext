package com.raqun.kotlinext

import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.support.v4.content.FileProvider
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Gets an uri of file
 */
fun File.getUriFromFile(context: Context, authority: String): Uri {
    return if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
        FileProvider.getUriForFile(context, authority, this)
    } else {
        Uri.fromFile(this)
    }
}

/**
 * Checks and returns if there's a valid directory with given path
 */
fun String.getAsDirectory(): File? {
    val directory = File(Environment.getExternalStorageDirectory(), this)
    return if (directory.exists()) {
        directory
    } else {
        null
    }
}

/**
 * Gets all files in given directory
 */
fun File.getFiles(): List<File> {
    val inFiles = ArrayList<File>()
    val files = this.listFiles()
    if (files != null) {
        for (file in files) {
            if (file.isDirectory) {
                inFiles.addAll(file.getFiles())
            } else {
                inFiles.add(file)
            }
        }
    }
    return inFiles
}

/**
 * Gets the file count of given directory
 */
fun File.getFileCount() = getFiles().size

/**
 * Calculates the folder size
 */
fun File.getFolderSize(): Long {
    var size: Long = 0
    if (isDirectory) {
        val files = listFiles()
        if (files != null) {
            for (file in files) {
                size += if (file.isDirectory) {
                    file.getFolderSize()
                } else {
                    file.length()
                }
            }
        } else {
            size = 0
        }
    } else {
        size = length()
    }

    return size
}

/**
 * Deletes given directory and returns result
 */
fun File.deleteDirectory(): Boolean {
    if (!exists()) return false
    return cleanDirectory()
}

/**
 * Force deletes given directory or file
 */
private fun File.forceDelete() {
    if (isDirectory) {
        deleteDirectory()
    } else {
        val filePresent = exists()
        if (!delete()) {
            if (!filePresent) {
                throw FileNotFoundException("File does not exist: $this")
            }
            val message = "Unable to delete file: $this"
            throw IOException(message)
        }
    }
}

/**
 * Cleans directory and returns result
 */
private fun File.cleanDirectory(): Boolean {
    val files = verifiedDirectoryFiles()
    var allFilesDeleted = true
    for (file in files) {
        try {
            forceDelete()
        } catch (e: IOException) {
            e.printStackTrace()
            if (allFilesDeleted) allFilesDeleted = false
        }
    }
    return allFilesDeleted
}

/**
 * Verifies files of directory
 */
private fun File.verifiedDirectoryFiles(): Array<File> {
    if (!exists()) {
        val message = toString() + " does not exist"
        throw IllegalArgumentException(message)
    }

    if (!isDirectory) {
        val message = toString() + " is not a directory"
        throw IllegalArgumentException(message)
    }

    return listFiles()
            ?: // null if security restricted
            throw IOException("Failed to list contents of $this")
}