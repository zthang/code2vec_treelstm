static void swap(char[] a, char[] b, int i, int j, ArrayList<Pair> ans) {
    char tmp = b[j];
    b[j] = a[i];
    a[i] = tmp;
    ans.add(new Pair(i + 1, j + 1));
}