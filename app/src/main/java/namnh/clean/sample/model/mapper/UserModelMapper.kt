package namnh.clean.sample.model.mapper

import namnh.clean.domain.entity.User
import namnh.clean.sample.model.UserModel

class UserModelMapper : PresentationMapper<User, UserModel>() {

    override fun map(entity: User): UserModel {
        return UserModel(
            login = entity.login,
            avatarUrl = entity.avatarUrl,
            name = entity.name,
            company = entity.company,
            reposUrl = entity.reposUrl,
            blog = entity.blog
        )
    }
}
