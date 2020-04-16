public void solve(int testNumber, InputReader in, PrintWriter out) {
    int cnt = 1;
    int N = in.nextInt();
    int[][] edge = new int[N][2];
    for (int i = 0; i < N; i++) {
        int a = in.nextInt();
        ArrayList<Integer> div = new ArrayList<>();
        for (int d = 2; d <= Math.sqrt(a); d++) {
            if (a % d == 0) {
                int tot = 0;
                while (a % d == 0) {
                    tot++;
                    a /= d;
                }
                if (tot % 2 == 1) {
                    if (!map.containsKey(d)) {
                        map.put(d, cnt++);
                        rev.put(cnt - 1, d);
                    }
                    div.add(d);
                }
            }
        }
        if (a > 1) {
            div.add(a);
            if (!map.containsKey(a)) {
                map.put(a, cnt++);
                rev.put(cnt - 1, a);
            }
        }
        if (div.size() == 0) {
            out.println(1);
            return;
        }
        if (seen.contains(prod(div))) {
            two = true;
        } else {
            seen.add(prod(div));
        }
        if (div.size() > 1) {
            edge[i] = new int[] { map.get(div.get(0)), map.get(div.get(1)) };
        } else {
            edge[i] = new int[] { 0, map.get(div.get(0)) };
        }
    }
    rev.put(0, 1);
    if (two) {
        out.println(2);
        return;
    }
    graph = new ArrayList[cnt];
    for (int i = 0; i < cnt; i++) {
        graph[i] = new ArrayList<>();
    }
    for (int i = 0; i < N; i++) {
        graph[edge[i][0]].add(new Edge(edge[i][1], i));
        graph[edge[i][1]].add(new Edge(edge[i][0], i));
    }
    out.println(shortest_cycle(cnt));
}