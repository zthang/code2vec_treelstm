private List<Integer> maxLIS(int n, String s) {
    List<Integer> max = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
        max.add(null);
    }
    int l = 1;
    for (int i = 0; i < n - 1; i++) {
        if (s.charAt(i) == '>') {
            int start = i + 1;
            while (i < n - 1 && s.charAt(i) == '>') {
                i++;
            }
            int end = i;
            for (int j = 0; j < end - start + 1; j++) {
                max.set(end - j, l);
                l++;
            }
        }
    }
    for (int i = 0; i < n; i++) {
        if (max.get(i) == null) {
            max.set(i, l);
            l++;
        }
    }
    return max;
}