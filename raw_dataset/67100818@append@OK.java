private static void append(final StringBuilder b, Object o, final String delim) {
    append(x -> {
        append(b, x, delim);
    }, x -> b.append(delim).append(x), o);
}