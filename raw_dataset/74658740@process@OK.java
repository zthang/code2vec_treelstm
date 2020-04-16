public void process() {
    int d = depth(1, 1, 0);
    block_size = (int) Math.sqrt(d);
    arr[0][1] = -1;
    arr[0][2] = -1;
    bfs(1, 0);
}