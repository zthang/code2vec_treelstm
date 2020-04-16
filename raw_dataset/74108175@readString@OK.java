public String readString() {
    final StringBuilder stringBuilder = new StringBuilder();
    int c = read();
    while (isSpaceChar(c)) {
        c = read();
    }
    do {
        stringBuilder.append(c);
        c = read();
    } while (!isSpaceChar(c));
    return stringBuilder.toString();
}