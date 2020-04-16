public String toString() {
    StringBuilder builder = new StringBuilder();
    for (IntegerIterator iterator = iterator(); iterator.hasNext(); ) {
        builder.append(iterator.next()).append(' ');
    }
    return builder.toString();
}