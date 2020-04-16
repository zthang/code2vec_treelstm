static void DFS(int s, int[] b, int[] w, int parent, int[] a) {
    Iterator<Integer> itr = adj[s].listIterator();
    while (itr.hasNext()) {
        int n = itr.next();
        if (n != parent) {
            DFS(n, b, w, s, a);
        }
    }
    if (a[s] == 1)
        w[s]++;
    else
        b[s]++;
    Iterator<Integer> itr1 = adj[s].listIterator();
    while (itr1.hasNext()) {
        int n = itr1.next();
        if (n != parent) {
            if (w[n] > b[n]) {
                w[s] = w[s] + w[n];
                b[s] = b[s] + b[n];
            }
        }
    }
}