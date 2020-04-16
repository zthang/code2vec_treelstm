int bs() {
    // return 1;
    if (tryWith(1))
        return 1;
    for (int[] e : edges) {
        if (e[0] < e[1])
            e[2] = 1;
        else
            e[2] = 2;
    }
    return 2;
// System.out.println(tryWith(2));
// return 1;
}