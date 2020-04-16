char[][] cmas2(int n, int m) throws IOException {
    char[][] mas = new char[n][m];
    for (int i = 0; i < n; i++) mas[i] = nextLine().toCharArray();
    return mas;
}