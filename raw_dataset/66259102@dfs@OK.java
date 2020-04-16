public static int[] dfs(int at, int[] went, ArrayList<ArrayList<Integer>> connect) {
    for (int i = 0; i < connect.get(at).size(); i++) {
        if (went[connect.get(at).get(i)] == 0) {
            went[connect.get(at).get(i)] = 1;
            went = dfs(connect.get(at).get(i), went, connect);
        }
    }
    return went;
}