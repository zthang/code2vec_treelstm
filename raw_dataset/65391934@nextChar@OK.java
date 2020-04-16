public char nextChar() throws Exception {
    byte c = read();
    while (c <= ' ') {
        c = read();
    }
    return (char) c;
}