private void solveD() throws IOException {
    int n = in.nextInt();
    long[] b = in.nextLongArray(n);
    int[] c = new int[n], cnt = new int[60];
    int maxId = 0;
    for (int i = 0; i < n; i++) {
        while (b[i] % (1L << c[i]) == 0) c[i]++;
        c[i]--;
        if (++cnt[c[i]] > cnt[maxId])
            maxId = c[i];
    }
    out.println(n - cnt[maxId]);
    for (int i = 0; i < n; i++) {
        if (c[i] != maxId)
            out.print(b[i] + " ");
    }
}