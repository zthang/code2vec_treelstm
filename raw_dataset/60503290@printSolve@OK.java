public static void printSolve(StringBuilder str, int[] colors, int n, int color) {
    for (int i = 1; i <= n; ++i) if (colors[i] == color)
        str.append(i + " ");
    str.append('\n');
}