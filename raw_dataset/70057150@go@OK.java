int go(int id, int m, DJSet ds) {
    if (ds.must[ds.root(id)]) {
        return ds.numt[ds.root(id)];
    } else if (ds.must[ds.root(id + m)]) {
        return ds.numt[ds.root(id + m)];
    } else {
        return Math.min(ds.numt[ds.root(id)], ds.numt[ds.root(id + m)]);
    }
}