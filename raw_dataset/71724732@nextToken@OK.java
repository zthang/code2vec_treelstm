String nextToken() {
    int b = skip();
    StringBuilder sb = new StringBuilder();
    while (!isTrash(b)) {
        sb.appendCodePoint(b);
        b = readByte();
    }
    return sb.toString();
}