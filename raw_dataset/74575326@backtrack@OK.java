public static void backtrack(int idx, int upperBound, String str) {
    if (idx == n) {
        ts.add(str);
        return;
    }
    for (int i = 0; i <= upperBound + 1; i++) {
        backtrack(idx + 1, Math.max(upperBound, i), str + (char) ('a' + i));
    }
}