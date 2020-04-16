public JN negIf(int toSearch) {
    if (pr2 == -1)
        return this;
    if (uf_rmds.find(pr2, toSearch)) {
        return neg();
    }
    return this;
}