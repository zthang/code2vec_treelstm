public final String readString(int L) throws IOException {
    int c = read();
    while (isSpaceChar(c)) {
        c = read();
    }
    StringBuilder res = new StringBuilder(L);
    do {
        res.append((char) c);
        c = read();
    } while (!isSpaceChar(c));
    return res.toString();
}