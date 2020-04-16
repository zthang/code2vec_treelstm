static long fib(int n) {
    if (n == 1 || n == 0) {
        return 1;
    }
    if (fib[n] != -1) {
        return fib[n];
    } else
        return fib[n] = ((fib(n - 2) % mod + fib(n - 1) % mod) % mod);
}