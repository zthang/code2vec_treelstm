void solve() {
    int used = 0;
    int sum = 0;
    for (int i = 1; i <= 7; i++) {
        if (edge[i].size() > 0) {
            used++;
            sum += edge[i].size();
        }
    }
    if (used > 6) {
        int max = 0;
        for (int i = 1; i < 7; i++) {
            for (int j = i + 1; j <= 7; j++) {
                Graph graph = mergeVertices(i, j);
                sum = 0;
                for (int k = 1; k <= 7; k++) {
                    // System.out.println(edge[k]);
                    sum += graph.edge[k].size();
                }
                max = Math.max(sum, max);
            }
        }
        max = max - 2;
        System.out.println(max / 2 + 1);
    } else {
        System.out.println(sum / 2);
    }
}