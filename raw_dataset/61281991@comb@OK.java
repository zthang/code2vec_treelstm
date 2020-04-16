static void comb(int n, int k, int ind, ArrayList<Integer> list) {
    if (k == 0) {
        l.add(new ArrayList<>(list));
        return;
    }
    for (int i = ind; i <= n; i++) {
        list.add(i);
        comb(n, k - 1, ind + 1, list);
        list.remove(list.size() - 1);
    }
}