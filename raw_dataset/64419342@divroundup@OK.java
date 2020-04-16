long divroundup(long n, long d) {
    if (n == 0)
        return 0;
    return (n - 1) / d + 1;
}