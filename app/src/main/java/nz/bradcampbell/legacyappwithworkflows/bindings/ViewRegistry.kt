package nz.bradcampbell.legacyappwithworkflows.bindings

import com.squareup.workflow1.ui.ViewRegistry
import com.squareup.workflow1.ui.WorkflowUiExperimentalApi

@OptIn(WorkflowUiExperimentalApi::class)
val viewRegistry = ViewRegistry(ButtonBinding, ColumnBinding)
