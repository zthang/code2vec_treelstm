public String nextLine() {
    int c = snext();
    StringBuilder res = new StringBuilder();
    do {
        res.appendCodePoint(c);
        c = snext();
    } while (!isEndOfLine(c));
    if (isEndOfLine(res.charAt(res.length() - 1)))
        return res.deleteCharAt(res.length()).toString();
    return res.toString();
}