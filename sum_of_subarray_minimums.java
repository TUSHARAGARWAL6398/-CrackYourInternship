class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        int[]nge=next(arr);
        int pge[]=prev(arr);
        int ans=0;
        int mod=1_000_000_007;
        for(int i=0;i<arr.length;i++){
            int range=(nge[i]-i)*(i-pge[i])%mod;
            int value=(range*arr[i])%mod;
           
            ans=(ans+value)%mod;
        }
        return ans;
        
    }

    public static int[] next(int[]arr){
        Stack<Integer> st=new Stack<>();
        int ans[]=new int[arr.length];
        Arrays.fill(ans,arr.length);
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                ans[st.pop()]=i;

            }
            st.push(i);
        }
        return ans;
    }

    public static int[] prev(int[]arr){
        Stack<Integer> st=new Stack<>();
        int ans[]=new int[arr.length];
        Arrays.fill(ans,-1);
        for(int i=arr.length-1;i>-1;i--){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                ans[st.pop()]=i;

            }
            st.push(i);
        }
        return ans;
    }
}