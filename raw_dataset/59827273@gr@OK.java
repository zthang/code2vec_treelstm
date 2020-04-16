static int gr(int a) {
    if (baap[a] == a)
        return a;
    return baap[a] = gr(baap[a]);
}