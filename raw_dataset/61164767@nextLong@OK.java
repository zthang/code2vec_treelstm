public long nextLong() {
    num = 1;
    boolean neg = false;
    if (c == NC)
        c = nextChar();
    for (; (c < '0' || c > '9'); c = nextChar()) {
        if (c == '-')
            neg = true;
    }
    long res = 0;
    for (; c >= '0' && c <= '9'; c = nextChar()) {
        res = (res << 3) + (res << 1) + c - '0';
        num *= 10;
    }
    return neg ? -res : res;
}