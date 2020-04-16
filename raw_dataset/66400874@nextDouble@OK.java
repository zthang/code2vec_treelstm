public double nextDouble() {
    try {
        double sign = 1;
        int b = input.read();
        while ((b < '0' || '9' < b) && b != '-' && b != '+') {
            b = input.read();
        }
        if (b == '-') {
            sign = -1;
            b = input.read();
        } else if (b == '+') {
            b = input.read();
        }
        double ret = b - '0';
        while (true) {
            b = input.read();
            if (b < '0' || '9' < b)
                break;
            ret *= 10;
            ret += b - '0';
        }
        if (b != '.')
            return sign * ret;
        double div = 1;
        b = input.read();
        while ('0' <= b && b <= '9') {
            ret *= 10;
            ret += b - '0';
            div *= 10;
            b = input.read();
        }
        return sign * ret / div;
    } catch (IOException e) {
        e.printStackTrace();
        return Double.NaN;
    }
}