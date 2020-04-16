static void bfs(int x, int y) {
    LinkedList<Node> queue = new LinkedList<>();
    queue.add(new Node(x, y, '.'));
    visited[x][y] = true;
    while (!queue.isEmpty()) {
        Node e = queue.removeFirst();
        boolean z = false;
        if (e.i + 1 < n && c[e.i + 1][e.j] == '.' && !visited[e.i + 1][e.j]) {
            c[e.i][e.j] = 'D';
            visited[e.i + 1][e.j] = true;
            z = true;
            queue.add(new Node(e.i + 1, e.j, 'U'));
        }
        if (e.i - 1 >= 0 && c[e.i - 1][e.j] == '.' && !visited[e.i - 1][e.j]) {
            c[e.i][e.j] = 'U';
            visited[e.i - 1][e.j] = true;
            z = true;
            queue.add(new Node(e.i - 1, e.j, 'D'));
        }
        if (e.j + 1 < n && c[e.i][e.j + 1] == '.' && !visited[e.i][e.j + 1]) {
            c[e.i][e.j] = 'R';
            visited[e.i][e.j + 1] = true;
            z = true;
            queue.add(new Node(e.i, e.j + 1, 'L'));
        }
        if (e.j - 1 >= 0 && c[e.i][e.j - 1] == '.' && !visited[e.i][e.j - 1]) {
            c[e.i][e.j] = 'L';
            visited[e.i][e.j - 1] = true;
            z = true;
            queue.add(new Node(e.i, e.j - 1, 'R'));
        }
        if (!z)
            c[e.i][e.j] = e.c;
    }
}