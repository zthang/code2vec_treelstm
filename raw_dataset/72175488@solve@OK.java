public void solve() {
    int n = in.nextInt();
    int m = in.nextInt();
    to = new ArrayList[n];
    for (int i = 0; i < to.length; i++) {
        to[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
        int x = in.nextInt() - 1;
        int y = in.nextInt() - 1;
        to[y].add(x);
    }
    int k = in.nextInt();
    int[] p = new int[k];
    for (int i = 0; i < p.length; i++) {
        p[i] = in.nextInt() - 1;
    }
    Queue<Integer> q = new ArrayDeque<>();
    int[] len = new int[n];
    int[] size = new int[n];
    for (int i = 0; i < len.length; i++) {
        len[i] = -1;
    }
    len[p[k - 1]] = 0;
    q.add(p[k - 1]);
    while (!q.isEmpty()) {
        int v = q.poll();
        for (int i : to[v]) {
            if (len[i] < 0) {
                len[i] = len[v] + 1;
                q.add(i);
                size[i]++;
            } else if (len[i] == len[v] + 1) {
                size[i]++;
            }
        }
    }
    // for (int i = 0; i < size.length; i++) {
    // System.out.println(len[i] + " " + size[i]);
    // }
    int min = 0;
    int max = 0;
    for (int i = 0; i < p.length - 1; i++) {
        if (len[p[i + 1]] != len[p[i]] - 1) {
            min++;
            max++;
        } else if (size[p[i]] > 1) {
            max++;
        }
    }
    out.println(min + " " + max);
}