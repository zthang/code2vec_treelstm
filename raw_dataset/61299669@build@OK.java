void build() {
    if (v.size() == 7) {
        int cur = 0;
        dominos = new HashSet<>();
        for (int i = 1; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                dominos.add(new Pair(i, j));
            }
        }
        for (int i = 0; i < edges.size(); i++) {
            Pair dom = new Pair(v.get(edges.get(i).a), v.get(edges.get(i).b));
            if (dominos.contains(dom)) {
                dominos.remove(dom);
                cur++;
            }
        }
        max = Math.max(max, cur);
    } else {
        for (int i = 1; i < 7; i++) {
            v.add(i);
            build();
            v.remove(v.size() - 1);
        }
    }
}