private void solveA() throws IOException {
    long n = in.nextLong(), ans = 0;
    for (int i = 1; i < 10; i++) {
        long x = i;
        while (x <= n) {
            ans++;
            x = x * 10 + i;
        }
    }
    out.println(ans);
}