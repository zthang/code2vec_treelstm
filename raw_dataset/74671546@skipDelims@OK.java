private final int skipDelims() {
    int c = read();
    while (isDelim(c)) {
        c = read();
    }
    return c;
}