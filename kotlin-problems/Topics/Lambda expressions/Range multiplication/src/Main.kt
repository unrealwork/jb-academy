val lambda: (Long, Long) -> Long = { start, end -> (start..end).reduce { acc, e -> acc * e } }
