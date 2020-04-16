public static void solve() {
    for (ArrayList n : graph) {
        if (n.size() >= 3) {
            System.out.println(-1);
            return;
        }
    }
    String[] perms = { "123", "132", "213", "231", "312", "321" };
    long maxCost = Long.MAX_VALUE;
    String finalSelectedPerm = null;
    int[] finalColors = new int[n + 1];
    // Find starting node
    int starting = -1;
    for (int i = 1; i <= n; i++) {
        if (graph[i].size() == 1) {
            starting = i;
            break;
        }
    }
    for (int i = 0; i < 6; i++) {
        String selectedPerm = perms[i];
        boolean[] visited = new boolean[n + 1];
        int[] tempColors = new int[n + 1];
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(starting);
        long curCost = 0;
        int cur;
        int index = 0;
        int selectedColor;
        while (!bfs.isEmpty()) {
            selectedColor = selectedPerm.charAt(index) - '0';
            cur = bfs.remove();
            visited[cur] = true;
            curCost += cost[selectedColor][cur];
            tempColors[cur] = selectedColor;
            index = (index + 1) % 3;
            for (Integer n : graph[cur]) {
                if (!visited[n]) {
                    bfs.add(n);
                }
            }
        }
        if (curCost < maxCost) {
            maxCost = curCost;
            finalSelectedPerm = selectedPerm;
            for (int j = 1; j <= n; j++) {
                finalColors[j] = tempColors[j];
            }
        }
    }
    System.out.println(maxCost);
    for (int i = 1; i <= n; i++) {
        System.out.print(finalColors[i] + " ");
    }
}