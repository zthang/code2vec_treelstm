private void ensureMore() {
    if (next(epos) == bpos) {
        expandSpace(n + 1);
    }
}