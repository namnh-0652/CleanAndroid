package namnh.clean.shared.extensions

/**
 * Returns a list containing all elements except last [n] elements.
 */
fun <E> List<E>.removeLast(n: Int): MutableList<E> {
    if (n < 0 || n > size) {
        throw IllegalArgumentException("Requested element $n is not in range [0->$size)")
    }
    return dropLast(size - n).toMutableList()
}
