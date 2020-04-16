public static void DFS(int s, int par, int dep, ArrayList<ArrayList<Integer>> g) {
    parent[s] = par;
    depth[s] = dep;
    time_in[s] = time;
    time = time + 1;
    Iterator<Integer> it = g.get(s).listIterator();
    while (it.hasNext()) {
        int i = it.next();
        if (i == par) {
            continue;
        }
        DFS(i, s, dep + 1, g);
    }
    time_out[s] = time;
    time = time + 1;
}