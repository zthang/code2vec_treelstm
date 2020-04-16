long grtdiv(long x) {
    if (isPrime(x))
        return 1;
    else {
        long ans = 0;
        long y = (long) Math.sqrt(x) + 1;
        for (; y >= 2; y--) {
            if (x % y == 0)
                ans = Math.max(ans, Math.max(y, x / y));
        }
        return ans;
    }
}