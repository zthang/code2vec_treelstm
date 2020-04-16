private int dfs(int t) {
    this.t1 = t++;
    for (Node child : children) {
        if (child.t1 == 0) {
            t = child.dfs(t);
        }
    }
    this.t2 = t++;
    return t;
}