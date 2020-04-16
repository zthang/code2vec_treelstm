public String scanString() {
    int c = scan();
    while (isWhiteSpace(c)) c = scan();
    StringBuilder RESULT = new StringBuilder();
    do {
        RESULT.appendCodePoint(c);
        c = scan();
    } while (!isWhiteSpace(c));
    return RESULT.toString();
}