// static int[] a;
public static int[] sort(int[] a) {
    int n = a.length;
    ArrayList<Integer> ar = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
        ar.add(a[i]);
    }
    Collections.sort(ar);
    for (int i = 0; i < n; i++) {
        a[i] = ar.get(i);
    }
    return a;
}