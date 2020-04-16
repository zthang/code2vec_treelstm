public void skipNext() throws Exception {
    byte c = read();
    while (isSpaceChar(c)) {
        c = read();
    }
    do {
        c = read();
    } while (!isSpaceChar(c));
}