long power(long x, long y) {
    long ans = 1;
    while (y != 0) {
        if (y % 2 == 1)
            ans *= x;
        x = x * x;
        y /= 2;
    }
    return ans;
}