private boolean dfs(int root) {
    if (visited[root]) {
        if (instk[root]) {
            int index = circular.indexOf(root);
            circular.remove(0, index - 1);
            return true;
        }
        return false;
    }
    visited[root] = true;
    instk[root] = true;
    circular.push(root);
    for (IntegerIterator iterator = edges.iterator(root); iterator.hasNext(); ) {
        int node = iterator.next();
        if (dfs(node)) {
            return true;
        }
    }
    circular.pop();
    instk[root] = false;
    return false;
}