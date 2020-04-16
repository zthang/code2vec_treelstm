public static ArrayList<Integer> dfs(int at, ArrayList<Integer> went, ArrayList<ArrayList<Integer>> connect) {
    for (int i = 0; i < connect.get(at).size(); i++) {
        if (!(went.contains(connect.get(at).get(i)))) {
            went.add(connect.get(at).get(i));
            went = dfs(connect.get(at).get(i), went, connect);
        }
    }
    return went;
}