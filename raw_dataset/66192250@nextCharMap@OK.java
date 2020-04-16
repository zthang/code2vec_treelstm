public char[][] nextCharMap(int n) {
    char[][] map = new char[n][];
    for (int i = 0; i < n; i++) {
        map[i] = next().toCharArray();
    }
    return map;
}