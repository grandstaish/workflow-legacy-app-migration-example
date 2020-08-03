package nz.bradcampbell.legacyappwithworkflows.legacy

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import nz.bradcampbell.legacyappwithworkflows.R

/**
 * Demonstrates an existing Activity in an app that you're slowly converting to use Workflow.
 */
class LegacyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.legacy_activity)
        val backButton = findViewById<View>(R.id.back)
        backButton.setOnClickListener {
            finish()
        }
    }
}
