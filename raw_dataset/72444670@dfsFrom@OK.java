static void dfsFrom(int x, int y, char cameFrom) {
    if (visited[x][y])
        return;
    visited[x][y] = true;
    ans[x][y] = cameFrom;
    for (int d = 0; d < 4; d++) {
        int nx = x + dx[d], ny = y + dy[d];
        if (!valid(nx, ny))
            continue;
        if (board[x][y].eq(board[nx][ny]))
            dfsFrom(nx, ny, directions[d]);
    }
}