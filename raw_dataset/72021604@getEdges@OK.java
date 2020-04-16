private void getEdges(int m) {
    for (int i = 1; i <= m; i++) {
        int a = scanner.nextInt(), b = scanner.nextInt();
        if (a == b)
            continue;
        exitEdges[a].add(b);
        enterEdges[b].add(a);
    }
}