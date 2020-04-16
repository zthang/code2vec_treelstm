public char nextChar() {
    int c = read();
    while (isSpaceChar(c)) c = read();
    return (char) c;
}