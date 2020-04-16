public int hashCode() {
    int hash = 0;
    for (int el : list) {
        hash = el ^ hash;
    }
    return hash;
}