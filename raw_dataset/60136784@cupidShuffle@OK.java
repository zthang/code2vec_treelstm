public static Edge[] cupidShuffle(Edge[] arr) {
    Random random = new Random();
    for (int i = 0; i < arr.length; i++) {
        int ind = random.nextInt(arr.length - i) + i;
        Edge temp = arr[i];
        arr[i] = arr[ind];
        arr[ind] = temp;
    }
    return arr;
}