public char[][] next2Dchar(int lines) throws IOException {
    char[][] result = new char[lines][];
    for (int i = 0; i < lines; i++) {
        result[i] = nextCharArray();
    }
    return result;
}