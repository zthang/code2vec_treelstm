private void kasai() {
    lcp = new int[N];
    int[] inv = new int[N];
    for (int i = 0; i < N; i++) inv[sa[i]] = i;
    for (int i = 0, len = 0; i < N; i++) {
        if (inv[i] > 0) {
            int k = sa[inv[i] - 1];
            while ((i + len < N) && (k + len < N) && T[i + len] == T[k + len]) len++;
            lcp[inv[i] - 1] = len;
            if (len > 0)
                len--;
        }
    }
}