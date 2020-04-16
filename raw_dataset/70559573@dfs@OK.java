public static void dfs(ArrayList<ArrayList<Integer>> gr, int i, boolean[] visit) {
    visit[i] = true;
    ArrayList<Integer> nbr = gr.get(i);
    for (int s : nbr) {
        if (!visit[s]) {
            max = Math.max(s, max);
            dfs(gr, s, visit);
        }
    }
}