private long func(int src, int col1, int col2, HashMap<Integer, ArrayList<Integer>> map, int[] a, int[] b, int[] c, HashSet<Integer> visited, int[] ans) {
    visited.add(src);
    ArrayList<Integer> neighb = map.get(src);
    int coln1 = col2;
    int coln2;
    if (col1 == 1 && col2 == 2) {
        coln2 = 3;
    } else if (col1 == 1 && col2 == 3) {
        coln2 = 2;
    } else if (col1 == 2 && col2 == 1) {
        coln2 = 3;
    } else if (col1 == 2 && col2 == 3) {
        coln2 = 1;
    } else if (col1 == 3 && col2 == 1) {
        coln2 = 2;
    } else {
        coln2 = 1;
    }
    int[] arr;
    if (col1 == 1) {
        arr = a;
    } else if (col1 == 2) {
        arr = b;
    } else {
        arr = c;
    }
    for (int neigh : neighb) {
        if (!visited.contains(neigh)) {
            ans[src - 1] = col1;
            return (long) arr[src - 1] + func(neigh, coln1, coln2, map, a, b, c, visited, ans);
        }
    }
    ans[src - 1] = col1;
    return arr[src - 1];
}