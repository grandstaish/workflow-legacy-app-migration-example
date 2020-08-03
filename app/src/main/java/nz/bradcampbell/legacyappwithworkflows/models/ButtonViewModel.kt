package nz.bradcampbell.legacyappwithworkflows.models

data class ButtonViewModel(
    val title: String,
    val onClick: () -> Unit
)
