static long div(long n) {
    long total = 1;
    for (int p = 2; p <= n; p++) {
        if (hash[p]) {
            int count = 0;
            if (n % p == 0) {
                while (n % p == 0) {
                    n = n / p;
                    count++;
                }
                total = total * (count + 1);
            }
        }
    }
    return total;
}