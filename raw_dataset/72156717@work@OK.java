void work() {
    int n = ni(), m = ni(), k = ni();
    int[] dis = new int[n];
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < k; i++) {
        set.add(in.nextInt() - 1);
    }
    ArrayList<Integer>[] graph = ng(n, m);
    LinkedList<Integer> q1 = new LinkedList<>();
    LinkedList<Integer> q2 = new LinkedList<>();
    int cur = 0;
    q2.add(n - 1);
    while (q2.size() > 0) {
        cur++;
        int len = q2.size();
        while (len-- > 0) {
            int node = q2.poll();
            for (int nn : graph[node]) {
                if (nn != n - 1 && dis[nn] == 0) {
                    dis[nn] = cur;
                    q2.add(nn);
                }
            }
        }
    }
    TreeSet<Integer> tree = new TreeSet<>(new Comparator<Integer>() {

        public int compare(Integer a, Integer b) {
            if (dis[a] == dis[b]) {
                return a - b;
            }
            return dis[a] - dis[b];
        }
    });
    for (int i = 0; i < n; i++) {
        if (set.contains(i)) {
            tree.add(i);
        }
    }
    boolean[] vis = new boolean[n];
    int ret = 0;
    q1.add(0);
    vis[0] = true;
    cur = 0;
    while (q1.size() > 0) {
        int len = q1.size();
        while (len-- > 0) {
            int node = q1.poll();
            tree.remove(node);
            if (set.contains(node) && tree.size() > 0) {
                int d = dis[tree.last()];
                ret = Math.max(ret, d + cur + 1);
            }
            for (int nn : graph[node]) {
                if (!vis[nn]) {
                    vis[nn] = true;
                    q1.add(nn);
                }
            }
        }
        cur++;
    }
    if (ret > dis[0]) {
        ret = dis[0];
    }
    out.println(ret);
}