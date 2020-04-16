public int next() {
    while (++itr < scale && allocated[itr] == null) ;
    if (itr == scale) {
        itr = -1;
        return NG;
    }
    return keys[itr];
}