public int nextInt() {
    int sign = 1;
    int c = skipDelims();
    if (c == '-') {
        sign = -1;
        c = read();
        if (isDelim(c))
            throw new RuntimeException("Incorrect format");
    }
    int val = 0;
    while (c != -1 && !isDelim(c)) {
        if (!isDigit(c))
            throw new RuntimeException("Incorrect format");
        val = 10 * val + (c - '0');
        c = read();
    }
    return val * sign;
}