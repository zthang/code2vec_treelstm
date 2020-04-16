public void solve(int testNumber, InputReader in, PrintWriter out) {
    while (testNumber-- > 0) {
        int n = in.nextInt();
        long[] c1 = new long[n + 1];
        long[] c2 = new long[n + 1];
        long[] c3 = new long[n + 1];
        for (int i = 0; i < n; i++) c1[i + 1] = in.nextLong();
        for (int i = 0; i < n; i++) c2[i + 1] = in.nextLong();
        for (int i = 0; i < n; i++) c3[i + 1] = in.nextLong();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for (int i = 0; i <= n; i++) a.add(new ArrayList<>());
        int[] visited = new int[n + 1];
        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            a.get(u).add(v);
            a.get(v).add(u);
            visited[u]--;
            visited[v]--;
            if (visited[u] == -3 || visited[v] == -3) {
                out.println(-1);
                out.close();
                System.exit(0);
            }
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i] == -1) {
                index = i;
                break;
            }
        }
        // out.println(index);
        b = new int[n + 1];
        // out.println(a);
        for (int i = 1; i <= 3; i++) {
            long a1 = 0;
            if (i == 1)
                a1 = c1[index];
            else if (i == 2)
                a1 = c2[index];
            else
                a1 = c3[index];
            int[] ans1 = new int[n + 1];
            ans1[index] = i;
            int[] ans2 = new int[n + 1];
            ans2[index] = i;
            if (a.get(index).size() == 1) {
                int p = a.get(index).get(0);
                int p2 = (i + 1) % 3 == 0 ? i + 1 : (i + 1) % 3;
                visited = new int[n + 1];
                visited[index] = 1;
                visited[p] = 1;
                long a2 = 0;
                if (p2 == 1)
                    a2 = c1[p];
                else if (p2 == 2)
                    a2 = c2[p];
                else
                    a2 = c3[p];
                // out.println(i + " " + a1 + " " + a2);
                ans1[p] = p2;
                for (int j = 0; j < a.get(p).size(); j++) {
                    if (visited[a.get(p).get(j)] == 0)
                        a2 += dfs(a, visited, a.get(p).get(j), ans1, c1, c2, c3, i, p2);
                }
                if (min > a1 + a2) {
                    min = a1 + a2;
                    b = ans1;
                }
                // out.println(min);
                // print1d(b , out);
                int p3 = (i + 2) % 3 == 0 ? i + 2 : (i + 2) % 3;
                visited = new int[n + 1];
                visited[index] = 1;
                visited[p] = 1;
                a2 = 0;
                if (p3 == 1)
                    a2 = c1[p];
                else if (p3 == 2)
                    a2 = c2[p];
                else
                    a2 = c3[p];
                // out.println(i + " " + a1 + " " + a2);
                ans2[p] = p3;
                for (int j = 0; j < a.get(p).size(); j++) {
                    if (visited[a.get(p).get(j)] == 0)
                        a2 += dfs(a, visited, a.get(p).get(j), ans2, c1, c2, c3, i, p3);
                }
                if (min > a1 + a2) {
                    min = a1 + a2;
                    b = ans2;
                }
            // out.println(min);
            // print1d(b , out);
            }
        }
        out.println(min);
        for (int i = 1; i <= n; i++) out.print(b[i] + " ");
        out.println();
    }
}