void work() {
    int n = in.nextInt();
    id = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        id[i] = i;
    }
    int k = in.nextInt();
    long ret = 0;
    for (int i = 0; i < k; i++) {
        ret += union(in.nextInt(), in.nextInt());
    }
    out.println(ret);
}