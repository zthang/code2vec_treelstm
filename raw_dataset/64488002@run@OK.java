public void run() {
    InputReader sc = new InputReader(System.in);
    PrintWriter w = new PrintWriter(System.out);
    int n = sc.nextInt();
    map = new HashMap[n];
    for (int i = 0; i < n; ++i) map[i] = new HashMap<>();
    int m = sc.nextInt();
    for (int i = 0; i < m; ++i) {
        int u = sc.nextInt() - 1;
        int v = sc.nextInt() - 1;
        map[u].put(v, 1);
        map[v].put(u, 1);
    }
    int[] vis = new int[n];
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
        if (vis[i] == 0) {
            int cnt = 1;
            vis[i] = 1;
            // StringBuilder sb1=new StringBuilder();
            Queue<Integer> queue = new LinkedList<>();
            TreeSet<Integer> set = new TreeSet<>();
            for (int j = 0; j < n; ++j) {
                if (vis[j] == 0)
                    set.add(j);
            }
            queue.add(i);
            while (!queue.isEmpty() && set.size() != 0) {
                int cur = queue.poll();
                ArrayList<Integer> removeList = new ArrayList<>();
                for (int j : set) {
                    if (map[cur].get(j) == null) {
                        removeList.add(j);
                        queue.add(j);
                        cnt++;
                        vis[j] = 1;
                    }
                }
                for (int j : removeList) set.remove(j);
            }
            list.add(cnt);
        }
    }
    Collections.sort(list);
    w.println(list.size() - 1);
    w.close();
}