private static void printArray(int[] a) {
    if (a != null && a.length > 0) {
        System.out.print(a[0]);
        for (int i = 1; i < a.length - 1; i++) {
            System.out.print(" " + a[i]);
        }
        if (a.length > 1) {
            System.out.println(" " + a[a.length - 1]);
        } else {
            System.out.println();
        }
    }
}