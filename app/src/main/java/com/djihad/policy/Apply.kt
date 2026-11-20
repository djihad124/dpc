package com.djihad.policy

import android.app.Activity
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.os.Bundle
import android.os.UserManager
import android.util.Log

class Apply : Activity() {
  override fun onCreate(b: Bundle?) {
    super.onCreate(b)
    try {
      val dpm = getSystemService(DevicePolicyManager::class.java)
      val a = ComponentName(this, Admin::class.java)
      if (dpm.isDeviceOwnerApp(packageName)) {
        dpm.addUserRestriction(a, UserManager.DISALLOW_CONFIG_PRIVATE_DNS)
      }
    } catch (e: Exception) {
      Log.e("djihad", "apply failed", e)
    }
    finish()
  }
}
