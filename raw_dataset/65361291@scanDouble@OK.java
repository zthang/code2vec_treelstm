public double scanDouble() throws IOException {
    double doub = 0;
    int n = scan();
    while (isWhiteSpace(n)) n = scan();
    int neg = 1;
    if (n == '-') {
        neg = -1;
        n = scan();
    }
    while (!isWhiteSpace(n) && n != '.') {
        if (n >= '0' && n <= '9') {
            doub *= 10;
            doub += n - '0';
            n = scan();
        } else
            throw new InputMismatchException();
    }
    if (n == '.') {
        n = scan();
        double temp = 1;
        while (!isWhiteSpace(n)) {
            if (n >= '0' && n <= '9') {
                temp /= 10;
                doub += (n - '0') * temp;
                n = scan();
            } else
                throw new InputMismatchException();
        }
    }
    return doub * neg;
}