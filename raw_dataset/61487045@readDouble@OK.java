public double readDouble() {
    boolean sign = true;
    skipBlank();
    if (next == '+' || next == '-') {
        sign = next == '+';
        next = read();
    }
    long val = 0;
    while (next >= '0' && next <= '9') {
        val = val * 10 + next - '0';
        next = read();
    }
    if (next != '.') {
        return sign ? val : -val;
    }
    next = read();
    long radix = 1;
    long point = 0;
    while (next >= '0' && next <= '9') {
        point = point * 10 + next - '0';
        radix = radix * 10;
        next = read();
    }
    double result = val + (double) point / radix;
    return sign ? result : -result;
}