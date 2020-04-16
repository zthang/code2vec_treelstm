void work() {
    int n = in.nextInt();
    int m = in.nextInt();
    id = new int[n];
    for (int i = 0; i < n; i++) {
        id[i] = i;
    }
    long ret = 0;
    for (int i = 0; i < m; i++) {
        int s = in.nextInt() - 1;
        int e = in.nextInt() - 1;
        union(s, e);
    }
    for (int i = 0, j = 0, max = 0, cnt = 0; j < n; j++) {
        if (find(j) == j) {
            cnt++;
        }
        max = Math.max(max, find(j));
        if (j == max) {
            ret += cnt - 1;
            i = j + 1;
            cnt = 0;
        }
    }
    out.println(ret);
}