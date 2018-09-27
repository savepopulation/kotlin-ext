package com.raqun.kotlinext

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

/**
 * Commits given FragmentTransaction
 */
inline fun FragmentManager.transact(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}