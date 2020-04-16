static int insert(int x) {
    int pos = 1, j;
    if (!m1.containsKey(x)) {
        pos = 0;
        ++c1;
        map.put(x, 1);
        for (j = 0; j < adj.get(x).size(); j++) {
            if (!m1.containsKey(adj.get(x).get(j)))
                m1.put(adj.get(x).get(j), 1);
            else
                m1.put(adj.get(x).get(j), m1.get(adj.get(x).get(j)) + 1);
        }
    } else if (!m2.containsKey(x)) {
        pos = 0;
        ++c2;
        map.put(x, 2);
        for (j = 0; j < adj.get(x).size(); j++) {
            if (!m2.containsKey(adj.get(x).get(j)))
                m2.put(adj.get(x).get(j), 1);
            else
                m2.put(adj.get(x).get(j), m2.get(adj.get(x).get(j)) + 1);
        }
    } else if (!m3.containsKey(x)) {
        pos = 0;
        ++c3;
        map.put(x, 3);
        for (j = 0; j < adj.get(x).size(); j++) {
            if (!m3.containsKey(adj.get(x).get(j)))
                m3.put(adj.get(x).get(j), 1);
            else
                m3.put(adj.get(x).get(j), m3.get(adj.get(x).get(j)) + 1);
        }
    }
    return pos;
}