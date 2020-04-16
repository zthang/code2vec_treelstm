public int compareTo(B01MST.Node o) {
    if (paths == o.paths)
        return Integer.compare(index, o.index);
    return Integer.compare(paths, o.paths);
}