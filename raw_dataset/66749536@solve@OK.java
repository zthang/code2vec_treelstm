private static void solve(int q, FastScanner in, PrintWriter out) {
    for (int qq = 0; qq < q; qq++) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        // move[i]: the min moves needed for position i to reach an opposite parity position
        int[] moves = new int[n];
        Arrays.fill(moves, -1);
        List<List<Integer>> dg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dg.add(new ArrayList<>());
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (i - a[i] >= 0) {
                dg.get(i - a[i]).add(i);
                if (a[i] % 2 != (a[i - a[i]]) % 2) {
                    moves[i] = 1;
                }
            }
            if (i + a[i] < n) {
                dg.get(i + a[i]).add(i);
                if (a[i] % 2 != (a[i + a[i]]) % 2) {
                    moves[i] = 1;
                }
            }
            if (moves[i] == 1) {
                queue.add(i);
            }
        }
        while (queue.size() > 0) {
            int curr = queue.poll();
            for (int neighbor : dg.get(curr)) {
                // neighbor has not been explored yet
                if (moves[neighbor] < 0) {
                    moves[neighbor] = moves[curr] + 1;
                    queue.add(neighbor);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(moves[i] + " ");
        }
    }
    out.close();
}