public static void PH(String s, boolean reverse) {
    prelen = s.length();
    HashsArray[HashsArrayInd] = new int[prelen + 1];
    prepow = new int[prelen];
    if (HashsArrayInd == 0) {
        int[] mods = { 1173017693, 1173038827, 1173069731, 1173086977, 1173089783, 1173092147, 1173107093, 1173114391, 1173132347, 1173144367, 1173150103, 1173152611, 1173163993, 1173174127, 1173204679, 1173237343, 1173252107, 1173253331, 1173255653, 1173260183, 1173262943, 1173265439, 1173279091, 1173285331, 1173286771, 1173288593, 1173298123, 1173302129, 1173308827, 1173310451, 1173312383, 1173313571, 1173324371, 1173361529, 1173385729, 1173387217, 1173387361, 1173420799, 1173421499, 1173423077, 1173428083, 1173442159, 1173445549, 1173451681, 1173453299, 1173454729, 1173458401, 1173459491, 1173464177, 1173468943, 1173470041, 1173477947, 1173500677, 1173507869, 1173522919, 1173537359, 1173605003, 1173610253, 1173632671, 1173653623, 1173665447, 1173675577, 1173675787, 1173684683, 1173691109, 1173696907, 1173705257, 1173705523, 1173725389, 1173727601, 1173741953, 1173747577, 1173751499, 1173759449, 1173760943, 1173761429, 1173762509, 1173769939, 1173771233, 1173778937, 1173784637, 1173793289, 1173799607, 1173802823, 1173808003, 1173810919, 1173818311, 1173819293, 1173828167, 1173846677, 1173848941, 1173853249, 1173858341, 1173891613, 1173894053, 1173908039, 1173909203, 1173961541, 1173968989, 1173999193 };
        mod = RandomPick(mods);
        int[] primes = { 59, 61, 67, 71, 73, 79, 83, 89, 97, 101 };
        prime = RandomPick(primes);
    }
    prepow[0] = 1;
    if (!reverse) {
        for (int i = 1; i < prelen; i++) {
            prepow[i] = (int) ((1l * prepow[i - 1] * prime) % mod);
        }
        for (int i = 0; i < prelen; i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                HashsArray[HashsArrayInd][i + 1] = (int) ((1l * HashsArray[HashsArrayInd][i] + ((1l * s.charAt(i) - 'a' + 1) * prepow[i]) % mod) % mod);
            else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                HashsArray[HashsArrayInd][i + 1] = (int) ((1l * HashsArray[HashsArrayInd][i] + ((1l * s.charAt(i) - 'A' + 27) * prepow[i]) % mod) % mod);
            else
                HashsArray[HashsArrayInd][i + 1] = (int) ((1l * HashsArray[HashsArrayInd][i] + ((1l * s.charAt(i) - '0' + 1) * prepow[prelen - 1 - i]) % mod) % mod);
        }
    } else {
        for (int i = 1; i < prelen; i++) {
            prepow[i] = (int) ((1l * prepow[i - 1] * prime) % mod);
        }
        for (int i = 0; i < prelen; i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                HashsArray[HashsArrayInd][i + 1] = (int) ((1l * HashsArray[HashsArrayInd][i] + ((1l * s.charAt(i) - 'a' + 1) * prepow[prelen - 1 - i]) % mod) % mod);
            else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                HashsArray[HashsArrayInd][i + 1] = (int) ((1l * HashsArray[HashsArrayInd][i] + ((1l * s.charAt(i) - 'A' + 27) * prepow[prelen - 1 - i]) % mod) % mod);
            else
                HashsArray[HashsArrayInd][i + 1] = (int) ((1l * HashsArray[HashsArrayInd][i] + ((1l * s.charAt(i) - '0' + 1) * prepow[prelen - 1 - i]) % mod) % mod);
        }
    }
    HashsArrayInd++;
}