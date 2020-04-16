public static int nni() {
    int ret = 0;
    byte b = buf[++bp];
    while (true) {
        ret = ret * 10 + b - '0';
        b = buf[++bp];
        if (b < '0' || b > '9') {
            while (buf[bp + 1] == '\r' || buf[bp + 1] == '\n' || buf[bp + 1] == ' ') {
                ++bp;
            }
            break;
        }
    }
    return ret;
}