public static ArrayList<Integer> solve(int node) {
    ArrayList<Integer> a = new ArrayList<Integer>();
    for (int x : adjList[node]) {
        ArrayList<Integer> temp = solve(x);
        if (temp == null)
            return null;
        for (int y : temp) a.add(y);
    }
    if (c[node] <= a.size()) {
        a.add(c[node], node);
        return a;
    } else
        return null;
}