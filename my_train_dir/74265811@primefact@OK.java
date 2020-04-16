static void primefact(int n) {
    for (int i = 2; i * i <= n; i++) {
        while ((n % i) == 0) {
            cnt.add(i);
            n /= i;
        }
    }
    if (n > 1) {
        cnt.add(n);
    }
}