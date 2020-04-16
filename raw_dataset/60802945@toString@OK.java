public String toString() {
    StringBuilder builder = new StringBuilder();
    boolean first = true;
    for (IntIterator it = intIterator(); it.isValid(); it.advance()) {
        if (first) {
            first = false;
        } else {
            builder.append(' ');
        }
        builder.append(it.value());
    }
    return builder.toString();
}