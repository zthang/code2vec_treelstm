static int prince(boolean[] used) {
    for (int i = 1; i < used.length; i++) if (!used[i])
        return i;
    return -1;
}