public void dfs(int depth) {
    this.depth = depth;
    for (Node n : children) n.dfs(depth + 1);
}