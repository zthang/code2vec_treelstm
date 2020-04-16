int[][] next(String s) {
    int len = s.length();
    int[][] ne = new int[len + 1][26];
    Arrays.fill(ne[len], -1);
    for (int i = len - 1; i >= 0; --i) {
        ne[i] = ne[i + 1].clone();
        ne[i][s.charAt(i) - 'a'] = i + 1;
    }
    return ne;
}