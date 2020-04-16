private static final boolean isSpaceChar(final int c) {
    return c == 32 || c == 10 || c == 13 || c == 9 || // 32 == ' ', 10 == '\n', 13 == '\r', 9 == '\t'
    c == -1;
}