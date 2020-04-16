private static ArrayList<V> getOrder(V v) {
    if (v == null) {
        return new ArrayList<>();
    }
    ArrayList<V> order = new ArrayList<>();
    int c = 0;
    for (V to : v.to) {
        ArrayList<V> orderTo = getOrder(to);
        if (orderTo == null) {
            return null;
        }
        for (V orTo : orderTo) {
            if (c == v.c) {
                order.add(v);
            }
            order.add(orTo);
            c++;
        }
    }
    if (c == v.c) {
        order.add(v);
    } else if (c < v.c) {
        return null;
    }
    return order;
}