public int father(int i) {
    if (father[i] == i)
        return i;
    int ret = father(father[i]);
    father[i] = ret;
    return ret;
}