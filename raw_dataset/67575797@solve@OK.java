public void solve(Scanner sc, PrintWriter pw) throws IOException {
    int n = sc.nextInt();
    int m = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int[] f1 = new int[a];
    int[] f2 = new int[b];
    int[] deg = new int[n + m];
    for (int i = 0; i < a; i++) {
        f1[i] = sc.nextInt() - 1;
        deg[f1[i]]++;
    }
    for (int i = 0; i < b; i++) {
        f2[i] = sc.nextInt() - 1;
        deg[f2[i]]++;
    }
    PriorityQueue<Integer> canConnectSmall = new PriorityQueue<>(new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });
    PriorityQueue<Integer> canConnectLarge = new PriorityQueue<>(new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });
    for (int i = 0; i < n; i++) {
        if (deg[i] == 0)
            canConnectSmall.add(i);
    }
    for (int i = n; i < n + m; i++) {
        if (deg[i] == 0)
            canConnectLarge.add(i);
    }
    DJS djs = new DJS(n + m);
    List<int[]> edges = new ArrayList<>();
    int f1Idx = 0, f2Idx = 0;
    while (f1Idx < a || f2Idx < b) {
        int choose;
        if (f1Idx == a)
            choose = 2;
        else if (f2Idx == b)
            choose = 1;
        else if (canConnectSmall.size() > 0) {
            choose = 2;
        } else {
            choose = 1;
        }
        if (choose == 1) {
            int v;
            while (true) {
                if (canConnectLarge.size() == 0) {
                    pw.println("No");
                    return;
                }
                v = canConnectLarge.peek();
                if (v == n + m - 1) {
                    pw.println("No");
                    return;
                }
                canConnectLarge.poll();
                break;
            }
            djs.connect(v, f1[f1Idx]);
            edges.add(new int[] { v + 1, f1[f1Idx] + 1 });
            deg[f1[f1Idx]]--;
            if (deg[f1[f1Idx]] == 0)
                canConnectSmall.add(f1[f1Idx]);
            f1Idx++;
        } else {
            int v;
            while (true) {
                if (canConnectSmall.size() == 0) {
                    pw.println("No");
                    return;
                }
                v = canConnectSmall.peek();
                canConnectSmall.poll();
                break;
            }
            djs.connect(v, f2[f2Idx]);
            edges.add(new int[] { v + 1, f2[f2Idx] + 1 });
            deg[f2[f2Idx]]--;
            if (deg[f2[f2Idx]] == 0)
                canConnectLarge.add(f2[f2Idx]);
            f2Idx++;
        }
    }
    for (int i = 0; i < n + m - 1; i++) if (djs.a[i] < 0) {
        if (i < n)
            edges.add(new int[] { i + 1, n + m });
        else {
            if (canConnectSmall.size() == 0) {
                pw.println("No");
                return;
            }
            int last = canConnectSmall.peek();
            edges.add(new int[] { i + 1, last + 1 });
        }
    }
    pw.println("Yes");
    for (int i = 0; i < edges.size(); i++) {
        pw.println(edges.get(i)[0] + " " + edges.get(i)[1]);
    }
}