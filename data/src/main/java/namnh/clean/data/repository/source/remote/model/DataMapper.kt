package namnh.clean.data.repository.source.remote.model

inline fun <I, O> collectionMap(input: Collection<I>, singleMap: (I) -> O): List<O> {
    return input.map(singleMap)
}

inline fun <I, O> nullableCollectionMap(input: Collection<I>?, singleMap: (I) -> O): List<O>? {
    return input?.map(singleMap)
}
