public static D add(D root, D ad, int id) {
    Pair<D, D> pair = split(root, id);
    D t1 = merge(pair.getKey(), ad);
    D t2 = merge(t1, pair.getValue());
    return t2;
}