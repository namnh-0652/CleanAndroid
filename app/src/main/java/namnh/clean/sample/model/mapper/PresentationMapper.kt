package namnh.clean.sample.model.mapper

import namnh.clean.domain.entity.BaseEntity
import namnh.clean.sample.model.PresentationModel

@Suppress("unused")
abstract class PresentationMapper<T : BaseEntity, R : PresentationModel> {

    abstract fun map(entity: T): R

    fun nullableMap(entity: T?): R? {
        return entity?.let { map(it) }
    }

    fun collectionMap(collection: Collection<T>): List<R> {
        return collection.map { map(it) }
    }

    fun nullableCollectionMap(collection: Collection<T>?): List<R>? {
        return collection?.map { map(it) }
    }
}
