static void output() {
    for (int i = 1; i <= nFridges; i++) {
        if (i < nFridges)
            System.out.println(i + " " + (i + 1));
        else
            System.out.println(i + " " + 1);
    }
    if (nFridges < nChains)
        System.out.println((min + 1) + " " + (min2 + 1));
}