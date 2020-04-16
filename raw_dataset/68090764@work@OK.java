void work() {
    int n = in.nextInt();
    int[] A = new int[n];
    ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[n];
    for (int i = 0; i < n; i++) {
        A[i] = in.nextInt();
        graph[i] = new ArrayList<>();
    }
    int[] ret = new int[n];
    Arrays.fill(ret, -1);
    LinkedList<Integer> queue = new LinkedList<>();
    boolean[] vis = new boolean[n];
    for (int i = 0; i < n; i++) {
        int x1 = i - A[i];
        int x2 = i + A[i];
        if (x1 >= 0) {
            graph[x1].add(i);
            if (A[x1] % 2 != A[i] % 2 && !vis[i]) {
                queue.add(i);
                vis[i] = true;
            }
        }
        if (x2 < n) {
            graph[x2].add(i);
            if (A[x2] % 2 != A[i] % 2 && !vis[i]) {
                queue.add(i);
                vis[i] = true;
            }
        }
    }
    int cnt = 1;
    while (queue.size() > 0) {
        int len = queue.size();
        while (len-- > 0) {
            int node = queue.poll();
            ret[node] = cnt;
            for (int nn : graph[node]) {
                if (!vis[nn]) {
                    vis[nn] = true;
                    queue.add(nn);
                }
            }
        }
        cnt++;
    }
    for (int i = 0; i < n; i++) {
        out.print(ret[i] + " ");
    }
}