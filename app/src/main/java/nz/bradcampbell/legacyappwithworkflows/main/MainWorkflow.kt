package nz.bradcampbell.legacyappwithworkflows.main

import com.squareup.workflow1.StatelessWorkflow
import com.squareup.workflow1.action
import nz.bradcampbell.legacyappwithworkflows.main.MainWorkflow.Output
import nz.bradcampbell.legacyappwithworkflows.models.ButtonViewModel
import nz.bradcampbell.legacyappwithworkflows.models.ColumnViewModel

class MainWorkflow : StatelessWorkflow<Unit, Output, ColumnViewModel>() {
    enum class Output {
        QUIT, NEXT
    }

    override fun render(props: Unit, context: RenderContext): ColumnViewModel {
        return ColumnViewModel(
            items = listOf(
                ButtonViewModel("Quit") { context.actionSink.send(quitAction) },
                ButtonViewModel("Next") { context.actionSink.send(nextAction) }
            )
        )
    }

    private val quitAction = action {
        setOutput(Output.QUIT)
    }

    private val nextAction = action {
        setOutput(Output.NEXT)
    }
}
