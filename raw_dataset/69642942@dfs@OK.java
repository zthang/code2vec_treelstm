void dfs(int node, int father, TreeSet<Integer>[] adjTree) {
    parent[node] = father;
    for (int neighbor : adjTree[root(node)]) {
        if ((father != -1 && root(neighbor) == root(father)) || root(neighbor) == root(node))
            continue;
        dfs(root(neighbor), root(node), adjTree);
    }
}