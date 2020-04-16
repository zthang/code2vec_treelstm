private void solve(Scanner in, PrintWriter out) {
    int N = in.nextInt();
    int M = in.nextInt();
    int K = in.nextInt();
    int max = 4 * N * M - 2 * N - 2 * M;
    if (K > max) {
        out.println("NO");
        return;
    }
    int left = K;
    sb = new StringBuilder();
    int count = 0;
    if (left <= N - 1) {
        sb.append(left + " D\n");
        count++;
        end(count, out);
        return;
    }
    if (N != 1) {
        sb.append((N - 1) + " D\n");
        left -= (N - 1);
        count++;
    }
    if (left <= N - 1) {
        sb.append(left + " U\n");
        count++;
        end(count, out);
        return;
    }
    if (N != 1) {
        sb.append((N - 1) + " U\n");
        left -= (N - 1);
        count++;
    }
    if (left <= 1) {
        sb.append(left + " R\n");
        count++;
        end(count, out);
        return;
    }
    sb.append((1) + " R\n");
    left -= (1);
    count++;
    for (int m = 0; m < M - 1; m++) {
        // sb.append("m = "+m);
        if (left == 0) {
            end(count, out);
            return;
        }
        if (left <= (N - 1) * 3) {
            int has = left / 3;
            int remain = left % 3;
            if (has > 0) {
                sb.append(has + " DLR\n");
                count++;
            }
            if (remain == 1) {
                sb.append(1 + " D\n");
                count++;
            } else if (remain == 2) {
                sb.append(1 + " DL\n");
                count++;
            }
            end(count, out);
            return;
        }
        if (N != 1) {
            sb.append((N - 1) + " DLR\n");
            left -= (N - 1) * 3;
            count++;
        }
        if (left <= N - 1) {
            sb.append(left + " U\n");
            count++;
            end(count, out);
            return;
        }
        if (N != 1) {
            sb.append((N - 1) + " U\n");
            left -= (N - 1);
            count++;
        }
        if (left == 0) {
            end(count, out);
            return;
        }
        if (m != M - 2) {
            sb.append((1) + " R\n");
            left -= 1;
            count++;
        }
    }
    if (left <= M - 1) {
        sb.append(left + " L");
        count++;
        end(count, out);
        return;
    }
    if (M != 1) {
        sb.append((M - 1) + "L");
        count++;
    }
    end(count, out);
}