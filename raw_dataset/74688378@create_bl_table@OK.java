public static void create_bl_table(int n) {
    for (int i = 1; i < bl.length; i++) {
        for (int j = 0; j < n; j++) {
            int mid = bl[i - 1][j];
            if (mid != -1)
                bl[i][j] = bl[i - 1][mid];
        }
    }
}