private static void addToChars(List<int[]> groups, int j, String word) {
    int[] tmp = groups.get(j);
    for (char c : word.toCharArray()) {
        tmp[c - 'a'] = 1;
    }
    groups.set(j, tmp);
}