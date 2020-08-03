package nz.bradcampbell.legacyappwithworkflows.bindings

import android.widget.LinearLayout
import com.squareup.workflow1.ui.BuilderBinding
import com.squareup.workflow1.ui.ViewRegistry
import com.squareup.workflow1.ui.WorkflowUiExperimentalApi
import com.squareup.workflow1.ui.bindShowRendering
import nz.bradcampbell.legacyappwithworkflows.models.ButtonViewModel
import nz.bradcampbell.legacyappwithworkflows.models.ColumnViewModel

@OptIn(WorkflowUiExperimentalApi::class)
val ColumnBinding = BuilderBinding(
    type = ColumnViewModel::class,
    viewConstructor = { initialRendering, initialViewEnvironment, contextForNewView, _ ->
        LinearLayout(contextForNewView).apply {
            orientation = LinearLayout.VERTICAL
            bindShowRendering(initialRendering, initialViewEnvironment) { rendering, viewEnvironment ->
                // Inefficient but it doesn't matter for this demo.
                removeAllViews()
                val registry = viewEnvironment[ViewRegistry]
                for (item in rendering.items) {
                    val factory = registry.getFactoryFor(item::class)
                    val child = factory.buildView(item, viewEnvironment, context, this)
                    addView(child)
                }
            }
        }
    }
)
