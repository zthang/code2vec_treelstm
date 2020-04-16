public String getNextString(StringTokenizer stringTokenizer) {
    while (stringTokenizer.hasMoreTokens()) {
        return stringTokenizer.nextToken();
    }
    throw new RuntimeException("no more tokens in string");
}