char draw(int[] c1, int[] c2) {
    if (c1[0] == c2[0]) {
        if (c1[1] < c2[1]) {
            return 'R';
        } else {
            return 'L';
        }
    } else {
        if (c1[0] < c2[0]) {
            return 'D';
        }
        return 'U';
    }
}