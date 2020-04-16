public char readChar() {
    skipBlank();
    char c = (char) next;
    next = read();
    return c;
}