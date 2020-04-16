public String nextLine() {
    StringBuilder res = new StringBuilder();
    while (c <= 32) c = getChar();
    while (c != '\n') {
        res.append(c);
        c = getChar();
    }
    return res.toString();
}