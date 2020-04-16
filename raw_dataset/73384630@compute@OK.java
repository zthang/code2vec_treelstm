static void compute(int v, int u, int j, int i) {
    int index = 6 - i - j;
    visited[v] = true;
    for (int k = 0; k < graph.get(v).size(); k++) {
        int nodee = graph.get(v).get(k);
        if (visited[nodee] == false) {
            buffer[nodee] = index;
            answer += c[index - 1][nodee];
            compute(nodee, v, index, j);
        }
    }
}