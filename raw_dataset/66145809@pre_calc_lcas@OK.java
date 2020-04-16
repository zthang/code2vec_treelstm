static void pre_calc_lcas() {
    for (int which = 0; which < 2; ++which) {
        for (int i = 1; i <= n; ++i) {
            int idx = 0;
            for (int j = 1; j < i; ++j) {
                while (idx + 1 < path[which][arr[which][i]].size() && path_set[which][arr[which][j]][path[which][arr[which][i]].get(idx + 1)]) {
                    idx++;
                }
                lca[which][arr[which][i]][arr[which][j]] = path[which][arr[which][i]].get(idx);
            }
        }
    }
}