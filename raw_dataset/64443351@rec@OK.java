public static void rec(ArrayList<Integer> path, int[] build, int[] bitmask, int i) {
    if (!(i >= 0 && i < bitmask.length)) {
        return;
    }
    if (bitmask[i] != -1) {
        path.add(bitmask[i]);
    } else {
        rec(path, build, bitmask, build[i]);
        rec(path, build, bitmask, i ^ build[i]);
    }
}