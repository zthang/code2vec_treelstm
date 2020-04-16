public void solve(Scanner sc, PrintWriter pw) throws IOException {
    // int T = sc.nextInt();
    // while (T-- > 0) {
    int n = sc.nextInt();
    int[][] segs = new int[n * 2][2];
    int[] end = new int[n];
    for (int i = 0; i < n; i++) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        segs[i * 2] = new int[] { a, i + 1 };
        segs[i * 2 + 1] = new int[] { b, -i - 1 };
        end[i] = b;
    }
    Arrays.sort(segs, new Comparator<int[]>() {

        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    });
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            return end[o1] - end[o2];
        }
    });
    boolean[] remove = new boolean[n];
    DJS djs = new DJS(n);
    int edges = 0;
    for (int i = 0; i < 2 * n; i++) {
        int v = segs[i][1];
        if (v < 0) {
            remove[-v - 1] = true;
        } else {
            v--;
            Set<Integer> intersec = new HashSet<>();
            while (!pq.isEmpty()) {
                int x = pq.peek();
                if (remove[x]) {
                    pq.poll();
                    continue;
                }
                if (end[x] > end[v])
                    break;
                intersec.add(x);
                pq.poll();
            }
            for (int x : intersec) {
                if (!djs.union(v, x)) {
                    pw.println("NO");
                    return;
                }
                edges++;
                if (edges > n - 1) {
                    pw.println("NO");
                    return;
                }
            }
            pq.addAll(intersec);
            pq.add(v);
        }
    }
    if (edges == n - 1) {
        pw.println("YES");
    } else {
        pw.println("NO");
    }
// }
}