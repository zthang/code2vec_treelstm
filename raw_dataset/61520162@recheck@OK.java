void recheck() {
    int[] set = new int[3];
    for (int i = 0; i < n; i++) {
        if (ans[i] == 0)
            impossible();
        // проверка, вдруг мы не нашли сета для вершины i, тогда ответа нет
        set[ans[i] - 1]++;
    }
    for (int i = 0; i < 3; i++) {
        if (set[i] == 0)
            impossible();
    // проверка, что множества непустые
    }
    // проверка, что количество ребер совпадает
    if ((long) set[0] * set[1] + set[1] * set[2] + set[0] * set[2] != m)
        impossible();
    // если выполняются эти условия, то ответ есть
    for (int i = 0; i < n; i++) {
        System.out.print(ans[i] + " ");
    }
}