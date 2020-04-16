private char nextChar() {
    checkEof();
    char b = read();
    checkEof();
    return b;
}