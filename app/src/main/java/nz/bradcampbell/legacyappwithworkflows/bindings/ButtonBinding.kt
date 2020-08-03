package nz.bradcampbell.legacyappwithworkflows.bindings

import android.widget.Button
import com.squareup.workflow1.ui.BuilderBinding
import com.squareup.workflow1.ui.WorkflowUiExperimentalApi
import com.squareup.workflow1.ui.bindShowRendering
import nz.bradcampbell.legacyappwithworkflows.models.ButtonViewModel

@OptIn(WorkflowUiExperimentalApi::class)
val ButtonBinding = BuilderBinding(
    type = ButtonViewModel::class,
    viewConstructor = { initialRendering, viewEnvironment, contextForNewView, _ ->
        Button(contextForNewView).apply {
            bindShowRendering(initialRendering, viewEnvironment) { rendering, _ ->
                text = rendering.title
                setOnClickListener {
                    rendering.onClick()
                }
            }
        }
    }
)
