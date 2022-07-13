val notPredicate: (Char) -> Boolean = { !originalPredicate.invoke(it) }
