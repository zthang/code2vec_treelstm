    private static void fillMoves(int[] arr, int[] moves, int i, int[] visited) {
        if(moves[i] != 0){
            return;
        }
        if(!isValidIndex(arr, i)) {
            return;
        }
        if(visited[i] == 1){
            return;
        }
        visited[i] = 1;
        // Terminating condition needed
        int left = i-arr[i];
        int right = i+arr[i];

        //diff parity
        if(isValidIndex(arr, left) && !isSameParity(left, i, arr)){
            moves[i] = 1;
            return;
        }
        if(isValidIndex(arr, right) && !isSameParity(right, i, arr)) {
            moves[i] = 1;
            return;
        }

        //same parity
        fillMoves(arr, moves, left, visited);
        fillMoves(arr, moves, right, visited);

        int leftValue = isValidIndex(arr, left) ? moves[left] : -1;
        int rightValue = isValidIndex(arr, right) ? moves[right] : -1;

        if( leftValue <= 0 && rightValue <=0){
            moves[i] = -1;
            return;
        } else if(leftValue <= 0){
            moves[i] = rightValue + 1;
        } else if(rightValue <= 0){
            moves[i] = leftValue + 1;
        } else {
            moves[i] = Math.min(leftValue, rightValue) + 1;
        }
        return;
    }