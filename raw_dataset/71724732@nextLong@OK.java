long nextLong() {
    long ret = 0;
    int b = skip();
    if (b != '-' && (b < '0' || b > '9')) {
        throw new InputMismatchException();
    }
    boolean neg = false;
    if (b == '-') {
        neg = true;
        b = readByte();
    }
    while (true) {
        if (b >= '0' && b <= '9') {
            ret = ret * 10 + (b - '0');
        } else {
            if (b != -1 && !isTrash(b)) {
                throw new InputMismatchException();
            }
            return neg ? -ret : ret;
        }
        b = readByte();
    }
}