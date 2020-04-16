public float nextFloat() {
    float result, div;
    byte c;
    result = 0;
    div = 1;
    c = (byte) read();
    while (c <= ' ') c = (byte) read();
    boolean isNegative = (c == '-');
    if (isNegative)
        c = (byte) read();
    do {
        result = result * 10 + c - '0';
    } while ((c = (byte) read()) >= '0' && c <= '9');
    if (c == '.')
        while ((c = (byte) read()) >= '0' && c <= '9') result += (c - '0') / (div *= 10);
    if (isNegative)
        return -result;
    return result;
}