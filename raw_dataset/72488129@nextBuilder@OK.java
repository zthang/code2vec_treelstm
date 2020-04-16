public StringBuilder nextBuilder() {
    if (!hasNext()) {
        throw new NoSuchElementException();
    }
    StringBuilder sb = new StringBuilder();
    int b = readByte();
    while (isPrintableChar(b)) {
        sb.appendCodePoint(b);
        b = readByte();
    }
    return sb;
}