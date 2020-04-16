public String next() {
    if (!hN())
        throw new NoSuchElementException();
    StringBuilder sb = new StringBuilder();
    int b = rB();
    while (iPC(b)) {
        sb.appendCodePoint(b);
        b = rB();
    }
    return sb.toString();
}