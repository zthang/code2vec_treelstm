public void solve(int testNumber, Scanner in, PrintWriter out) {
    int testCases = in.nextInt();
    while (testCases-- != 0) {
        int n, m;
        n = in.nextInt();
        m = in.nextInt();
        ArrayList<TaskB.Node> a = new ArrayList<TaskB.Node>(n + 1);
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            TaskB.Node node = new TaskB.Node();
            node.index = i;
            node.weight = in.nextInt();
            a.add(node);
            // a.set(i, node);
            sum += node.weight;
        }
        if (m != n || (n == 2)) {
            out.println("-1");
            continue;
        }
        out.println(sum * 2);
        Collections.sort(a, new Comparator<TaskB.Node>() {

            public int compare(TaskB.Node o1, TaskB.Node o2) {
                return o1.weight - o2.weight;
            }
        });
        for (int i = 0; i < n - 1; ++i) {
            out.println(a.get(i).index + " " + a.get(i + 1).index);
        }
        out.println(a.get(n - 1).index + " " + a.get(0).index);
    }
}