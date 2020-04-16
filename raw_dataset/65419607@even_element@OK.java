public static int even_element(int[] b, int n) {
    int[] c = new int[n / 2 + 1];
    int l = 0;
    for (int i = 1; i < n; i += 2) {
        c[l] = b[i];
        System.out.print(c[l] + " ");
        l++;
    }
    System.out.println();
    if (c.length != 1) {
        return even_element(c, n / 2);
    } else
        return c[0];
}