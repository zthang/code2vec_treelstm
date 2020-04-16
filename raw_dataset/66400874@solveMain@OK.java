void solveMain() {
    int n = in.nextInt(), m = in.nextInt();
    ArrayList<ArrayList<Integer>> g = new ArrayList<>();
    for (int i = 0; i < n; i++) g.add(new ArrayList<>());
    for (int i = 0; i < m; i++) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        g.get(a).add(b);
        g.get(b).add(a);
    }
    int idx = 0;
    int[] max = new int[n], min = new int[n];
    Arrays.fill(max, -1);
    Arrays.fill(min, Integer.MAX_VALUE);
    boolean[] visited = new boolean[n];
    ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
    for (int i = 0; i < n; i++) {
        if (visited[i])
            continue;
        visited[i] = true;
        queue.addLast(i);
        max[idx] = Math.max(max[idx], i);
        min[idx] = Math.min(min[idx], i);
        while (!queue.isEmpty()) {
            int v = queue.removeFirst();
            for (int next : g.get(v)) {
                if (visited[next])
                    continue;
                visited[next] = true;
                queue.addLast(next);
                max[idx] = Math.max(max[idx], next);
                min[idx] = Math.min(min[idx], next);
            }
        }
        idx++;
    }
    ArrayList<int[]> seg = new ArrayList<>();
    for (int i = 0; i < idx; i++) {
        seg.add(new int[] { 0, min[i], i });
        seg.add(new int[] { 1, max[i], i });
    }
    Collections.sort(seg, (e1, e2) -> Integer.compare(e1[1], e2[1]));
    int ans = 0, d = 0, num = 0;
    for (int[] a : seg) {
        if (a[0] == 0) {
            d++;
            num++;
        } else {
            d--;
            if (d == 0) {
                ans += num - 1;
                num = 0;
            }
        }
    }
    out.println(ans);
}