private static int f(int[] array, int i, ArrayList<ArrayList<Integer>> edges) {
    if (i == array.length)
        return check(array, edges);
    int max = 0;
    for (int j = 1; j <= 6; j++) {
        array[i] = j;
        max = Math.max(f(array, i + 1, edges), max);
    }
    return max;
}