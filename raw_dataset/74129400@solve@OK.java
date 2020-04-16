public static int[] solve(int n, int[][] daughters) {
    boolean[] married = new boolean[n];
    int firstUnmarried = 0;
    for (int ix = 0; ix < n; ix++) {
        int[] d = daughters[ix];
        boolean found = false;
        for (int p : d) {
            if (!married[p - 1]) {
                married[p - 1] = true;
                found = true;
                break;
            }
        }
        if (!found) {
            firstUnmarried = ix + 1;
        }
    }
    if (firstUnmarried == 0) {
        return null;
    }
    for (int i = 1; i < n + 1; i++) {
        if (!married[i - 1]) {
            return new int[] { firstUnmarried, i };
        }
    }
    return null;
}