public long nextLong() {
    try {
        int sign = 1;
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
        long ret = b - '0';
        while (true) {
            b = input.read();
            if (b < '0' || '9' < b)
                return ret * sign;
            ret *= 10;
            ret += b - '0';
        }
    } catch (IOException e) {
        e.printStackTrace();
        return -1;
    }
}