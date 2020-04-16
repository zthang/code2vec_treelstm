public String toString() {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < stackNum; i++) {
        builder.append(i).append(": ");
        for (IntegerIterator iterator = iterator(i); iterator.hasNext(); ) {
            builder.append(iterator.next()).append(",");
        }
        if (builder.charAt(builder.length() - 1) == ',') {
            builder.setLength(builder.length() - 1);
        }
        builder.append('\n');
    }
    return builder.toString();
}