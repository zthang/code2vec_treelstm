static boolean isAncestor(int p, int c) {
    if (intime[p] <= intime[c] && outime[p] >= outime[c])
        return true;
    else
        return false;
}