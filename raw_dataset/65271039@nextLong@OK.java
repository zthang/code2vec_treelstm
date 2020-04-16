long nextLong() {
    while (Character.isWhitespace(buffer[curr])) toNextChar();
    long res = 0;
    while (Character.isDigit(buffer[curr])) {
        res *= 10;
        res += buffer[curr] - '0';
        toNextChar();
    }
    return res;
}