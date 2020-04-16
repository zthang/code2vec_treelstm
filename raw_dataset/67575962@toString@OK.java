public String toString() {
    LongObjectEntryIterator<V> iterator = iterator();
    StringBuilder builder = new StringBuilder("{");
    while (iterator.hasNext()) {
        iterator.next();
        builder.append(iterator.getEntryKey()).append("->").append(iterator.getEntryValue()).append(',');
    }
    if (builder.charAt(builder.length() - 1) == ',') {
        builder.setLength(builder.length() - 1);
    }
    builder.append('}');
    return builder.toString();
}