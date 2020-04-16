public static Pair<D, D> split(D v, int k) {
    if (v == null) {
        return new Pair<>(null, null);
    }
    if ((v.left == null ? 0 : v.left.c) >= k) {
        Pair<D, D> pair = split(v.left, k);
        v.left = pair.getValue();
        v.c = 1 + (v.left == null ? 0 : v.left.c) + (v.right == null ? 0 : v.right.c);
        return new Pair<>(pair.getKey(), v);
    } else {
        Pair<D, D> pair = split(v.right, k - (v.left == null ? 0 : v.left.c) - 1);
        v.right = pair.getKey();
        v.c = 1 + (v.left == null ? 0 : v.left.c) + (v.right == null ? 0 : v.right.c);
        return new Pair<>(v, pair.getValue());
    }
}