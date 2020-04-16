public static void dfs(int i, boolean[] used, ArrayList<Integer>[] ac) {
    used[i] = true;
    for (int j = 0; j < ac[i].size(); j++) {
        int nextn = ac[i].get(j);
        if (!used[nextn])
            dfs(nextn, used, ac);
    }
}