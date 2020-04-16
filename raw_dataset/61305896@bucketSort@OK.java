public static int[] bucketSort(int[] array, int bucketCount) {
    if (bucketCount <= 0)
        throw new IllegalArgumentException("Invalid bucket count");
    // trivially sorted
    if (array.length <= 1)
        return array;
    int high = array[0];
    int low = array[0];
    for (int i = 1; i < array.length; i++) {
        if (array[i] > high)
            high = array[i];
        if (array[i] < low)
            low = array[i];
    }
    // range of one bucket
    double interval = ((double) (high - low + 1)) / bucketCount;
    ArrayList<Integer>[] buckets = new ArrayList[bucketCount];
    for (int i = 0; i < bucketCount; i++) {
        // initialize buckets
        buckets[i] = new ArrayList();
    }
    for (int i = 0; i < array.length; i++) {
        // partition the input array
        buckets[(int) ((array[i] - low) / interval)].add(array[i]);
    }
    int pointer = 0;
    for (int i = 0; i < buckets.length; i++) {
        // mergeSort
        Collections.sort(buckets[i]);
        for (int j = 0; j < buckets[i].size(); j++) {
            // merge the buckets
            array[pointer] = buckets[i].get(j);
            pointer++;
        }
    }
    return array;
}