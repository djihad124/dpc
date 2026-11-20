package com.djihad.policy

import android.app.admin.DeviceAdminReceiver
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.UserManager

class Admin : DeviceAdminReceiver() {
  override fun onEnabled(c: Context, i: Intent) {
    val dpm = c.getSystemService(DevicePolicyManager::class.java)
    val a = ComponentName(c, Admin::class.java)
    dpm.addUserRestriction(a, UserManager.DISALLOW_CONFIG_PRIVATE_DNS)
  }
}
