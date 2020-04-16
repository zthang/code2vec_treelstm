static void explore(ArrayList<Integer>[] components, ArrayList<Integer> bob, int[][] move, ArrayList<int[]>[] howto, int[][] list) {
    for (int x : bob) {
        if (components[x].size() == 1) {
            int[] tm = howto[x].get(0);
            int L = howto[x].size();
            howto[x].add(tm);
            for (int i = 0; i < L; i++) {
                int[] cur = howto[x].get(i);
                int[] nx = howto[x].get(i + 1);
                int a = cur[0];
                int a2 = nx[0];
                int b2 = nx[1];
                move[a2][0] = list[a2][b2];
                move[a2][1] = a;
            }
        } else {
            explore(components, components[x], move, howto, list);
        }
    }
}