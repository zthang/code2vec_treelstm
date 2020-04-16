public boolean remove(int x) {
    int pos = h(x) & mask;
    while (allocated[pos] != null) {
        if (x == keys[pos]) {
            size--;
            // take last and fill rmpos
            int last = pos;
            pos = pos + 1 & mask;
            while (allocated[pos] != null) {
                int lh = h(keys[pos]) & mask;
                // lh <= last < pos
                if (lh <= last && last < pos || pos < lh && lh <= last || last < pos && pos < lh) {
                    keys[last] = keys[pos];
                    allocated[last] = allocated[pos];
                    last = pos;
                }
                pos = pos + 1 & mask;
            }
            keys[last] = 0;
            allocated[last] = null;
            return true;
        }
        pos = pos + 1 & mask;
    }
    return false;
}