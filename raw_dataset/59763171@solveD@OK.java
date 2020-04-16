private void solveD() throws IOException {
    int n = in.nextInt(), k = in.nextInt();
    int[] a = in.nextIntArray(n);
    shuffleInt(a);
    sort(a);
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < 20; i++) {
        int[] cnt = new int[1 << i], sum = new int[1 << i];
        for (int j = 0; j < n; j++) {
            int x = a[j], cntr = 0;
            while (x >= (1 << i)) {
                x >>= 1;
                cntr++;
            }
            cnt[x]++;
            sum[x] += cntr;
            if (cnt[x] == k)
                ans = min(ans, sum[x]);
        }
    }
    out.println(ans);
}