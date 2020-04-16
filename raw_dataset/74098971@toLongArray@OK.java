public long[] toLongArray(String s) {
    return Stream.of(s.split("\\s")).mapToLong(Long::parseLong).toArray();
}