void anss(int color1, int color2, int color3) {
    int[] ansss = new int[n];
    for (int i = 0; i < n; i++) {
        if (i % 3 == 0) {
            ansss[mas.get(i)] = color1;
        } else if (i % 3 == 1) {
            ansss[mas.get(i)] = color2;
        } else {
            ansss[mas.get(i)] = color3;
        }
    }
    System.out.println(check(color1, color2, color3));
    for (int i = 0; i < n; i++) {
        System.out.print(ansss[i] + " ");
    }
}