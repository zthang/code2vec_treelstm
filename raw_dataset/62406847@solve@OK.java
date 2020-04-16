public void solve(InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    boolean[] visited = new boolean[n + 1];
    List<List<Integer>> edges = new ArrayList<>(n + 1);
    for (int i = 0; i <= n; i++) {
        edges.add(new ArrayList<>(100));
    }
    for (int i = 1; i <= k; i++) {
        int a = in.nextInt();
        int b = in.nextInt();
        edges.get(a).add(b);
        edges.get(b).add(a);
    }
    int ans = 0;
    for (int i = 1; i <= n; i++) {
        if (visited[i]) {
            continue;
        }
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        while (!stack.empty()) {
            int curr = stack.pop();
            if (visited[curr]) {
                continue;
            }
            visited[curr] = true;
            cnt += 1;
            for (int j = 0; j < edges.get(curr).size(); j++) {
                if (!visited[edges.get(curr).get(j)]) {
                    stack.push(edges.get(curr).get(j));
                }
            }
        }
        ans += cnt - 1;
    }
    out.println(k - ans);
}