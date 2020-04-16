private static void dfs(int tek) {
    mar[tek] = 1;
    for (int i = 0; i < mas.length; i++) {
        if (mas[i][0] == tek) {
            int to = mas[i][1];
            if (mar[to] == 1)
                mas[i][2] = 2;
            else {
                mas[i][2] = 1;
                if (mar[to] == 0)
                    dfs(to);
            }
        }
    }
    mar[tek] = 2;
}