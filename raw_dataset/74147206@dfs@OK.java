public static void dfs(int curr, boolean[] seen, ArrayList<Integer> path, int[] arr) {
    seen[curr] = true;
    int next = arr[curr];
    path.add(curr);
    if (!seen[next])
        dfs(next, seen, path, arr);
}