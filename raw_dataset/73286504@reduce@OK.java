static int reduce(int x) {
    for (int d = 2; d * d <= x; d++) {
        if (x % d == 0) {
            while (x % (d * d) == 0) x /= (d * d);
        }
    }
    return x;
}