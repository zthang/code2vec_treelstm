public void dfss(int node, int parent, int dis) {
    if (dis >= this.dis) {
        this.dis = dis;
        farthest = node;
    }
    for (int i : G[node]) {
        if (i == parent)
            continue;
        dfss(i, node, dis + 1);
    }
    if (G[node].length > 2)
        flag = false;
}