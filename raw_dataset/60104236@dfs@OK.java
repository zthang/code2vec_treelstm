void dfs() {
    for (Node n : to) {
        n.inDegree--;
        if (n.inDegree == 0)
            n.dfs();
    }
}