public boolean dfs(Vertex curr) {
    if (curr.finished) {
        return false;
    }
    if (curr.started) {
        return true;
    }
    curr.started = true;
    boolean cycle = false;
    for (Vertex v : curr.others) {
        cycle |= dfs(v);
    }
    curr.finished = true;
    return cycle;
}