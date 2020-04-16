public void dfs(int a, int b, Triangle t, FastOutput out) {
    if (t.handled) {
        return;
    }
    t.handled = true;
    boolean flip;
    if (a != t.vertexes[0] && b != t.vertexes[0]) {
        flip = a == t.vertexes[2];
    } else if (a != t.vertexes[1] && b != t.vertexes[1]) {
        flip = a == t.vertexes[2];
    } else {
        flip = a == t.vertexes[1];
    }
    if (flip) {
        SequenceUtils.swap(t.vertexes, 0, 2);
    }
    dfs(t.vertexes[0], t.vertexes[1], out);
    out.append(t.vertexes[1]).append(' ');
    dfs(t.vertexes[1], t.vertexes[2], out);
    dfs(t.vertexes[2], t.vertexes[0], out);
}