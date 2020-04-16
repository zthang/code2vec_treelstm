String nextString() {
    int b = readByte();
    StringBuilder sb = new StringBuilder();
    while (!isTrash(b) || b == ' ') {
        sb.appendCodePoint(b);
        b = readByte();
    }
    return sb.toString();
}