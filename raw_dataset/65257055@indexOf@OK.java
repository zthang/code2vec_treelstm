public static int indexOf(Object[] arr, Object of) {
    for (int i = 0; i < arr.length; i++) {
        if (Utils.equals(arr[i], of))
            return i;
    }
    return -1;
}