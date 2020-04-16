public String nextLine() {
    int b = readByte();
    StringBuilder sb = new StringBuilder();
    while (b != '\n' || b != '\r') {
        sb.appendCodePoint(b);
    }
    return sb.toString();
}