package namnh.clean.shared.helper

inline fun <I, O> collectionMap(input: List<I>, singleMap: (I) -> O): List<O> {
    return input.map(singleMap)
}

inline fun <I, O> nullableCollectionMap(input: List<I>?, singleMap: (I) -> O): List<O> {
    return input?.map(singleMap).orEmpty()
}
