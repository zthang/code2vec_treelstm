void run() {
    int n = nextInt();
    int k = nextInt();
    int ans = 0;
    int[] dsu = new int[n];
    for (int i = 0; i < n; i++) {
        dsu[i] = i;
    }
    int[] rank = new int[n];
    for (int i = 0; i < k; i++) {
        int u = nextInt() - 1;
        int v = nextInt() - 1;
        if (unite(u, v, dsu, rank) == false) {
            ++ans;
        }
    }
    println(ans);
}