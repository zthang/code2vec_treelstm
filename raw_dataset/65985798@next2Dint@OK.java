public int[][] next2Dint(int lines) throws IOException {
    int[][] result = new int[lines][];
    for (int i = 0; i < lines; i++) {
        result[i] = nextIntLine();
    }
    return result;
}