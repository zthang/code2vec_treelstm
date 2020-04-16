static void solve() {
    int n = s.nextInt(), k = s.nextInt();
    int[] rank = new int[n + 1], parent = new int[n + 1];
    for (int i = 0; i <= n; i++) parent[i] = i;
    int count = 0;
    for (int i = 0; i < k; i++) {
        int a = s.nextInt(), b = s.nextInt();
        int x = find(a, parent);
        int y = find(b, parent);
        if (x != y) {
            if (rank[x] > rank[y])
                parent[y] = x;
            else if (rank[y] > rank[x])
                parent[x] = y;
            else {
                parent[x] = y;
                rank[y]++;
            }
        } else
            count++;
    }
    System.out.println(count);
}