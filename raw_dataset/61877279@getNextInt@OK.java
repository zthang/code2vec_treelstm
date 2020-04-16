public int getNextInt(StringTokenizer stringTokenizer) {
    while (stringTokenizer.hasMoreTokens()) {
        return Integer.parseInt(stringTokenizer.nextToken());
    }
    throw new RuntimeException("no more tokens in string");
}