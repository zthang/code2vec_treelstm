void dfs(int c, int b, HashSet<Integer> seen) {
    seen.add(c);
    for (int x : a[c]) {
        if (x == b || seen.contains(x))
            continue;
        dfs(x, b, seen);
    }
}