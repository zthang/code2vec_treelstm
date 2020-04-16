// **just change the name of class from Main to reuquired**
public void run() {
    InputReader sc = new InputReader(System.in);
    PrintWriter w = new PrintWriter(System.out);
    int t = sc.nextInt();
    while (t-- > 0) {
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] arr = new int[n + 1][2];
        int cost = 0, counter = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = i;
        }
        sortbyColumn(arr, 0);
        int sumOfAll = 0;
        for (int i = 1; i <= n; i++) {
            sumOfAll += arr[i][0];
        }
        if (n == 2 || m < n) {
            w.println("-1");
        } else {
            for (int i = 1; i < n; i++) {
                ans.append(i + " " + (i + 1) + "\n");
            }
            ans.append(n + " 1");
            cost += (2 * sumOfAll);
            if (m > n) {
                while (m > n) {
                    ans.append("\n" + arr[1][1] + " " + arr[2][1]);
                    cost += arr[1][0] + arr[2][0];
                    m--;
                }
            }
            w.println(cost);
            w.println(ans);
        }
    /*else
			{
				for(int i=1;i<=n;i++)
				{
					if(i==1)
					{
						cost+=arr[1][0]+arr[2][0];
						cost+=arr[1][0]+arr[3][0];
						counter+=2;
						ans.append(arr[1][1]+" "+arr[2][1]+"\n");
						ans.append(arr[1][1]+" "+arr[3][1]+"\n");
					}
					else if(i==2)
					{
						cost+=arr[2][0]+arr[3][0];
						counter++;
						if(n!=3)
						{
							ans.append(arr[2][1]+" "+arr[3][1]+"\n");	
						}
						else
						{
							ans.append(arr[2][1]+" "+arr[3][1]);
						}
						
					}
					else if(i==3)
					{
						continue;
					}
					else if(i==n)
					{
						cost+=arr[i][0]+arr[1][0];
						cost+=arr[i][0]+arr[2][0];
						counter+=2;
						ans.append(arr[i][1]+" "+arr[1][1]+"\n");
						ans.append(arr[i][1]+" "+arr[2][1]);
					}
					else
					{
						cost+=arr[i][0]+arr[1][0];
						cost+=arr[i][0]+arr[2][0];
						counter+=2;
						ans.append(arr[i][1]+" "+arr[1][1]+"\n");
						ans.append(arr[i][1]+" "+arr[2][1]+"\n");
					}
				}
				
				if(counter>m)
				{
					w.println("-1");
				}
				else
				{
					cost+=((m-counter)*(arr[1][0]+arr[2][0]));
					
					//System.out.println("m:"+m+"\tcounter"+counter);
					
					for(int i=0;i<(m-counter);i++)
					{
						ans.append("\n"+arr[1][1]+" "+arr[2][1]);
					}
					w.println(cost);
					w.println(ans);
				}
			}*/
    }
    System.out.flush();
    w.close();
}