public static boolean equal(int[] a, int al, int ar, int[] b, int bl, int br) {
    if ((ar - al) != (br - bl)) {
        return false;
    }
    for (int i = al, j = bl; i <= ar; i++, j++) {
        if (a[i] != b[j]) {
            return false;
        }
    }
    return true;
}