public String next() {
    StringBuilder res = new StringBuilder();
    while (c <= 32) c = getChar();
    while (c > 32) {
        res.append(c);
        c = getChar();
    }
    return res.toString();
}