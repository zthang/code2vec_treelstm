        public int function(int i)
        {
            
            if(i-a[i]>=0){
            if(a[i-a[i]]%2!=a[i]%2) return 1;
            else {  left[i]=1+function(i-a[i]); }
            }
         
            if(a[i]+i<n)
            {
            
            if(a[a[i]+i]%2!=a[i]%2) return 1;
            else {  right[i]=1+function(a[i]+i); }
            }
            
            entry[i]=Math.min(left[i],right[i]);
            return entry[i];
        }