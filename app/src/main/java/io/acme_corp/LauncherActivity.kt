package io.acme_corp.android

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create intent to open LumApps application
        val intentLumApps = Intent(Intent.ACTION_VIEW, URI_LUMAPPS_HOME)
        intentLumApps.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP

        // Check if LumApps application is installed
        val isLumAppsInstalled = intentLumApps.resolveActivity(this.packageManager) != null

        // If LumApps is installed
        if (isLumAppsInstalled) {
            // Open LumApps application
            startActivity(intentLumApps)
            finish()

        } else {
            // Show a dialog, ask the user to install the application from the PlayStore
            MaterialAlertDialogBuilder(this, R.style.DialogTheme)
                .setTitle(R.string.dialog_title)
                .setMessage(R.string.dialog_text)
                .setPositiveButton(R.string.dialog_button) { _, _ ->
                    // Open play store to install LumApps
                    startActivity(Intent(Intent.ACTION_VIEW, URI_PLAY_STORE))
                }
                .setOnDismissListener {
                    finish()
                }
                .show()
        }
    }
}

private val URI_LUMAPPS_HOME = Uri.parse("lumapps://home")
private val URI_PLAY_STORE =
    Uri.parse("https://play.google.com/store/apps/details?id=com.lumapps.android")
