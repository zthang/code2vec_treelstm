public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt(), M = in.nextInt();
    graph = new ArrayList<>();
    for (int i = 0; i < N; i++) {
        graph.add(new HashSet<>());
    }
    int[] setNumber = new int[N];
    int[] setCount = new int[4];
    visited = new boolean[N];
    for (int i = 0; i < M; i++) {
        int u = in.nextInt() - 1, v = in.nextInt() - 1;
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    setNumber[0] = 1;
    setCount[1]++;
    for (int i = 1; i < N; i++) {
        if (!graph.get(0).contains(i)) {
            setNumber[i] = 1;
            setCount[1]++;
        }
    }
    for (int i = 1; i < N; i++) {
        if (setNumber[i] == 0) {
            setNumber[i] = 2;
            setCount[2]++;
            for (int j = i + 1; j < N; j++) {
                if (!graph.get(i).contains(j)) {
                    setNumber[j] = 2;
                    setCount[2]++;
                }
            }
            break;
        }
    }
    for (int i = 1; i < N; i++) {
        if (setNumber[i] == 0) {
            setNumber[i] = 3;
            setCount[3]++;
            for (int j = i + 1; j < N; j++) {
                if (!graph.get(i).contains(j)) {
                    setNumber[j] = 3;
                    setCount[3]++;
                }
            }
            break;
        }
    }
    for (int i = 0; i < N; i++) {
        if (setNumber[i] == 0) {
            out.printLine(-1);
            return;
        }
    }
    for (int i = 1; i <= 3; i++) {
        int count = 0;
        if (setCount[i] == 0) {
            out.printLine(-1);
            return;
        }
        for (int j = 0; j < N; j++) {
            if (setNumber[j] == i) {
                int degeee = graph.get(j).size();
                if (degeee != N - setCount[i]) {
                    out.printLine(-1);
                    return;
                }
                if (!visited[j]) {
                    dfs(j, setNumber, i);
                    count++;
                }
            }
        }
        if (count != setCount[i]) {
            out.printLine(-1);
            return;
        }
    }
    for (int i = 0; i < N; i++) {
        out.print(setNumber[i] + " ");
    }
}