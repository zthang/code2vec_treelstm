public String nextLine() {
    StringBuilder res = new StringBuilder();
    while (c <= 32) c = nextChar();
    while (c != '\n') {
        res.append(c);
        c = nextChar();
    }
    return res.toString();
}