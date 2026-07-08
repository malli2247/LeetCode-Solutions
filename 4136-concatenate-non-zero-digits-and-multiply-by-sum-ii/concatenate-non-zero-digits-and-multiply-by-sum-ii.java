class Solution {

    public int[] sumAndMultiply(String s, int[][] queries) {

        long MOD = 1000000007L;

        int n=s.length();


        long prefixSum[]=new long[n];
        long prefixStr[]=new long[n];
        int prefixCnt[]=new int[n];

        long power[]=new long[n+1];


        power[0]=1;


        for(int i=1;i<=n;i++)
            power[i]=power[i-1]*10%MOD;



        prefixSum[0]=s.charAt(0)-'0';
        prefixCnt[0]=s.charAt(0)!='0'?1:0;
        prefixStr[0]=s.charAt(0)-'0';



        for(int i=1;i<n;i++){

            int digit=s.charAt(i)-'0';


            prefixSum[i]=(prefixSum[i-1]+digit)%MOD;

            prefixCnt[i]=prefixCnt[i-1]+(digit!=0?1:0);



            if(digit!=0)
                prefixStr[i]=(prefixStr[i-1]*10+digit)%MOD;
            else
                prefixStr[i]=prefixStr[i-1];
        }



        int ans[]=new int[queries.length];

        int idx=0;


        for(int q[]:queries){

            int l=q[0];
            int r=q[1];


            long sum=prefixSum[r];


            if(l>0)
                sum=(sum-prefixSum[l-1]+MOD)%MOD;



            int cnt=prefixCnt[r];


            if(l>0)
                cnt-=prefixCnt[l-1];



            long num=prefixStr[r];


            if(l>0)
                num=(num-prefixStr[l-1]*power[cnt]%MOD+MOD)%MOD;



            ans[idx++]=(int)(num*sum%MOD);
        }


        return ans;
    }
}