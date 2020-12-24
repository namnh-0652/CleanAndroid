package namnh.clean.sample.model

data class OwnerModel(
    val id: Long,
    val login: String,
    val url: String
) : PresentationModel()
