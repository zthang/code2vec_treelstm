public V remove(long x) {
    int h = hash(x);
    int s = h & mask;
    if (slot[s] == 0) {
        return null;
    }
    int pre = 0;
    int index = slot[s];
    while (keys[index] != x) {
        pre = index;
        if (next[index] != 0) {
            index = next[index];
        } else {
            break;
        }
    }
    if (keys[index] != x) {
        return null;
    }
    if (slot[s] == index) {
        slot[s] = next[index];
    } else {
        next[pre] = next[index];
    }
    removed[index] = true;
    size--;
    return (V) values[index];
}