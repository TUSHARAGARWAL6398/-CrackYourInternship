class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> st=new Stack<>();
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){

            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                int height=arr[st.pop()];
                int left=i;
                int right=st.isEmpty()?-1:st.peek();

                ans=Math.max(ans,((left-right-1)*height));
                


            }
            st.push(i);
        }
        while(!st.isEmpty()){
             int height=arr[st.pop()];
                int left=arr.length;
                int right=st.isEmpty()?-1:st.peek();

                ans=Math.max(ans,((left-right-1)*height));

        }
        return ans;
        
    }
}