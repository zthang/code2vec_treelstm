public int dad(int child) {
    if (parent[child] == child)
        return child;
    else
        return dad(parent[child]);
}