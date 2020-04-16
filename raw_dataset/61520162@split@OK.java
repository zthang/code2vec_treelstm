void split(int x) {
    boolean[] ban = new boolean[n];
    for (int i = 0; i < n; i++) {
        if (ans[i] == 0 && !ban[i]) {
            // Чекаем, что пока вершина i не в множестве и еще может входить в сет x
            // Пусть она будет в множестве x
            ans[i] = x;
            for (int j = 0; j < g[i].size(); j++) {
                // находим вершины, которые не входят в этот сет и помечаем,что их не берем
                ban[g[i].get(j)] = true;
            }
        }
    }
}