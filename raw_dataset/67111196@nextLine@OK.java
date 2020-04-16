public String nextLine() {
    int c = read();
    StringBuilder result = new StringBuilder();
    do {
        result.appendCodePoint(c);
        c = read();
    } while (!isNewLine(c));
    return result.toString();
}