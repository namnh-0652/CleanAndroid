package namnh.clean.sample.model

data class UserModel(
    val login: String,
    val avatarUrl: String,
    val name: String,
    val company: String,
    val reposUrl: String,
    val blog: String
) : PresentationModel()
