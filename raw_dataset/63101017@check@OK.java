private static int check(int[] array, ArrayList<ArrayList<Integer>> edges) {
    int[][] domino = new int[6][6];
    int counter = 0;
    for (int v1 = 0; v1 < edges.size(); v1++) {
        for (int v2 : edges.get(v1)) {
            int d1 = Math.max(array[v1], array[v2]) - 1, d2 = Math.min(array[v1], array[v2]) - 1;
            if (domino[d1][d2] == 0) {
                counter++;
                domino[d1][d2] = -1;
            }
        }
    }
    return counter;
}