package nz.bradcampbell.legacyappwithworkflows.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.workflow1.ui.WorkflowRunner
import com.squareup.workflow1.ui.WorkflowUiExperimentalApi
import com.squareup.workflow1.ui.setContentWorkflow
import nz.bradcampbell.legacyappwithworkflows.bindings.viewRegistry
import nz.bradcampbell.legacyappwithworkflows.legacy.LegacyActivity

private val workflow = MainWorkflow()

/**
 * Demonstrates an Activity that uses Workflow output for navigation in an app that has more than
 * 1 Activity. Once you navigate away from this Activity, the workflow is shutdown. Returning back
 * to the Activity later means it's no longer functional.
 *
 * Is there another way to easily retrofit an existing application with many activities? AFAIK we
 * need the Activity Context for navigation to other activities in our app, and we cannot inject
 * that into the Workflow because Activities have a shorter lifecycle.
 *
 * Issue: https://github.com/square/workflow-kotlin/issues/109
 */
@OptIn(WorkflowUiExperimentalApi::class)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentWorkflow(
            registry = viewRegistry,
            configure = { WorkflowRunner.Config(workflow) },
            onResult = { output ->
                when (output) {
                    MainWorkflow.Output.QUIT -> finish()
                    MainWorkflow.Output.NEXT -> {
                        startActivity(Intent(this, LegacyActivity::class.java))
                    }
                }
            }
        )
    }
}
