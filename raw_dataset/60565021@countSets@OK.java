int countSets() {
    int nSets = 0;
    for (int i = 0; i < id.length; i++) if (id[i] == i)
        nSets++;
    return nSets;
}