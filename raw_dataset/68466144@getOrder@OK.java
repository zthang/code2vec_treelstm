private static D getOrder(V v) {
    D order = null;
    int l = 0;
    for (V to : v.to) {
        D t2 = getOrder(to);
        if (t2 == null) {
            return null;
        }
        l += t2.c;
        order = merge(order, t2);
    }
    if (l < v.c) {
        return null;
    }
    order = add(order, new D(1, new Random().nextInt(), v), v.c);
    return order;
}