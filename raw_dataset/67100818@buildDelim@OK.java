private static String buildDelim(String delim, Object o, Object... A) {
    StringBuilder b = new StringBuilder();
    append(b, o, delim);
    for (Object p : A) append(b, p, delim);
    return b.substring(min(b.length(), delim.length()));
}