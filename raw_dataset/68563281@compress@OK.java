int compress(int[][] A) {
    Set<Integer> H = new HashSet<>();
    for (int[] a : A) for (int b : a) H.add(b);
    int[] b = unboxed(H.toArray(new Integer[H.size()]));
    sort(b);
    Map<Integer, Integer> K = new HashMap<>();
    for (int i : rep(b.length)) K.put(b[i], i);
    for (int[] a : A) for (int i : rep(2)) a[i] = K.get(a[i]);
    return b.length;
}