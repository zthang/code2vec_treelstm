public long[][] next2Dlong(int lines) throws IOException {
    long[][] result = new long[lines][];
    for (int i = 0; i < lines; i++) {
        result[i] = nextLongLine();
    }
    return result;
}