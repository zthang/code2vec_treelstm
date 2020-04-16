void solveMain() {
    int n = in.nextInt();
    int[] a = in.nextIntArray(n);
    int[] ans = new int[n];
    Arrays.fill(ans, -1);
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    ArrayList<ArrayList<Integer>> rg = new ArrayList<>();
    for (int i = 0; i < n; i++) rg.add(new ArrayList<>());
    for (int i = 0; i < n; i++) {
        if (i - a[i] >= 0) {
            if (a[i] % 2 != a[i - a[i]] % 2) {
                ans[i] = 1;
                queue.addLast(i);
            } else {
                rg.get(i - a[i]).add(i);
            }
        }
        if (i + a[i] < n) {
            if (a[i] % 2 != a[i + a[i]] % 2) {
                ans[i] = 1;
                queue.addLast(i);
            } else {
                rg.get(i + a[i]).add(i);
            }
        }
    }
    while (!queue.isEmpty()) {
        int to = queue.removeFirst();
        for (int from : rg.get(to)) {
            if (ans[from] != -1)
                continue;
            ans[from] = ans[to] + 1;
            queue.addLast(from);
        }
    }
    for (int e : ans) out.print(e + " ");
    out.println();
}