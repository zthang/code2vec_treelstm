public static long[] maximumPrimeFactor(long n) {
    long[] ans = new long[2];
    ans[0] = 1;
    for (int i = 0; i < primes.length; i++) {
        if (DigitUtils.isMultiplicationOverflow(ans[0], primes[i], n)) {
            break;
        }
        ans[0] *= primes[i];
        ans[1]++;
    }
    return ans;
}