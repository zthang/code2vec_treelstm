static int find_centroid(int v, int pr, int size) {
    for (edge to : gr[v]) {
        if (to.to == pr || killed[to.to])
            continue;
        if (sz[to.to] > size / 2)
            return find_centroid(to.to, v, size);
    }
    return v;
}