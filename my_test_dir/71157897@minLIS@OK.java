List<Integer> minLIS(int n, String s) {
    List<Integer> min = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
        min.add(null);
    }
    int h = n;
    for (int i = 0; i < n - 1; i++) {
        if (s.charAt(i) == '<') {
            int start = i + 1;
            while (i < n - 1 && s.charAt(i) == '<') {
                i++;
            }
            int end = i;
            for (int j = 0; j < end - start + 1; j++) {
                min.set(end - j, h);
                h--;
            }
        }
    }
    for (int i = 0; i < n; i++) {
        if (min.get(i) == null) {
            min.set(i, h);
            h--;
        }
    }
    return min;
}