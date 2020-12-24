package namnh.clean.sample.model.mapper

import namnh.clean.domain.entity.BaseEntity
import namnh.clean.sample.model.PresentationModel

abstract class PresentationMapper<T : BaseEntity, R : PresentationModel> {
    abstract fun map(entity: T): R
}
