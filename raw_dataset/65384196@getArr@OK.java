static int[] getArr(BigInteger num) {
    String str = num.toString();
    int[] arr = new int[str.length()];
    for (int i = 0; i < arr.length; i++) arr[i] = str.charAt(i) - '0';
    return arr;
}