void add(int a) {
    mas[tk++] = a;
    if (tk >= size) {
        int[] k = new int[2 * (tk - first)];
        for (int i = first; i < tk; i++) {
            k[i - first] = mas[i];
        }
        tk -= first;
        first = 0;
        size = k.length;
        mas = k;
    }
}