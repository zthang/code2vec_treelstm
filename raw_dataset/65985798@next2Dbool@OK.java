public boolean[][] next2Dbool(int lines, char c) throws IOException {
    boolean[][] result = new boolean[lines][];
    for (int i = 0; i < lines; i++) {
        result[i] = nextBoolArray(c);
    }
    return result;
}