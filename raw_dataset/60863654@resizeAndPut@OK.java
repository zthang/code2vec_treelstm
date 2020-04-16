private void resizeAndPut(int x, Object v) {
    int nscale = scale << 1;
    int nrscale = rscale << 1;
    int nmask = nscale - 1;
    Object[] nallocated = new Object[nscale];
    int[] nkeys = new int[nscale];
    itrreset();
    while (true) {
        int y = next();
        if (end())
            break;
        int pos = h(y) & nmask;
        while (nallocated[pos] != null) pos = pos + 1 & nmask;
        nkeys[pos] = y;
        nallocated[pos] = allocated[itr];
    }
    {
        int pos = h(x) & nmask;
        while (nallocated[pos] != null) pos = pos + 1 & nmask;
        nkeys[pos] = x;
        nallocated[pos] = v;
    }
    allocated = nallocated;
    keys = nkeys;
    scale = nscale;
    rscale = nrscale;
    mask = nmask;
}