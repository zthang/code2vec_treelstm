public long[] extendEuclid(int a, int b) {
    /**
     * *** a*x+b*y=gcd(a,b) ************
     */
    long[] ans = new long[2];
    if (b == 0) {
        ans[0] = 1;
        ans[1] = 0;
        return ans;
    } else {
        ans = extendEuclid(b, a % b);
        long x = ans[0], y = ans[1];
        ans[0] = y;
        ans[1] = x - ((a / b) * y);
        return ans;
    }
}