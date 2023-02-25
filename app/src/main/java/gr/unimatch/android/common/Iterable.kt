package gr.unimatch.android.common

fun <T> intersectMany(
    vararg iterable: Iterable<T>
): Set<T> =
    iterable.reduce { accumulator, currentIterable ->
        accumulator intersect currentIterable.toSet()
    }.toSet()
