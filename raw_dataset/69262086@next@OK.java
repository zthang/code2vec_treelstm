public String next() {
    StringBuilder res = new StringBuilder();
    while (c <= 32) c = nextChar();
    while (c > 32) {
        res.append(c);
        c = nextChar();
    }
    return res.toString();
}