public int[] calculateZ(char[] input) {
    int[] Z = new int[input.length];
    int left = 0;
    int right = 0;
    for (int k = 1; k < input.length; k++) {
        if (k > right) {
            left = right = k;
            while (right < input.length && input[right] == input[right - left]) {
                right++;
            }
            Z[k] = right - left;
            right--;
        } else {
            // we are operating inside box
            int k1 = k - left;
            // if value does not stretches till right bound then just copy it.
            if (Z[k1] < right - k + 1) {
                Z[k] = Z[k1];
            } else {
                // otherwise try to see if there are more matches.
                left = k;
                while (right < input.length && input[right] == input[right - left]) {
                    right++;
                }
                Z[k] = right - left;
                right--;
            }
        }
    }
    return Z;
}