public long getNextLong(StringTokenizer stringTokenizer) {
    while (stringTokenizer.hasMoreTokens()) {
        return Long.parseLong(stringTokenizer.nextToken());
    }
    throw new RuntimeException("no more tokens in string");
}