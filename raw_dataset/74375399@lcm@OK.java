static long lcm(int[] element_array) {
    long lcm_of_array_elements = 1;
    int divisor = 2;
    while (true) {
        int counter = 0;
        boolean divisible = false;
        for (int i = 0; i < element_array.length; i++) {
            if (element_array[i] == 0) {
                return 0;
            } else if (element_array[i] < 0) {
                element_array[i] = element_array[i] * (-1);
            }
            if (element_array[i] == 1) {
                counter++;
            }
            // number with quotient; used for find next factor
            if (element_array[i] % divisor == 0) {
                divisible = true;
                element_array[i] = element_array[i] / divisor;
            }
        }
        // else increment divisor
        if (divisible) {
            lcm_of_array_elements = lcm_of_array_elements * divisor;
        } else {
            divisor++;
        }
        // we found all factors and terminate while loop.
        if (counter == element_array.length) {
            return lcm_of_array_elements;
        }
    }
}