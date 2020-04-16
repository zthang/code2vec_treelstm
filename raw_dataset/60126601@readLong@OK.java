public long readLong() {
    int sign = 1;
    skipBlank();
    if (next == '+' || next == '-') {
        sign = next == '+' ? 1 : -1;
        next = read();
    }
    long val = 0;
    if (sign == 1) {
        while (next >= '0' && next <= '9') {
            val = val * 10 + next - '0';
            next = read();
        }
    } else {
        while (next >= '0' && next <= '9') {
            val = val * 10 - next + '0';
            next = read();
        }
    }
    return val;
}