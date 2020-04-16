static void sort(int[] ar) {
    int n = ar.length;
    ArrayList<Integer> a = new ArrayList<>();
    for (int i = 0; i < n; i++) a.add(ar[i]);
    Collections.sort(a);
    for (int i = 0; i < n; i++) ar[i] = a.get(i);
}