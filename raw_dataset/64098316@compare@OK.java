public int compare(edge a, edge b) {
    if (a.w < b.w)
        return -1;
    else if (a.w == b.w)
        return 0;
    else
        return 1;
}