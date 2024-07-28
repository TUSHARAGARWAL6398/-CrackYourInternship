class Solution {
    public int maximalRectangle(char[][] matrix) {

        int arr[]=new int[matrix[0].length];
        int ans=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    arr[j]=arr[j]+1;
                }
                else{
                    arr[j]=0;
                }
            }
            int area=Area(arr);
            ans=Math.max(ans,area);
        }
        return ans;
        
    }

    public static int Area(int[]arr){
        Stack<Integer> st=new Stack<>();
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                int right=i;
                int height=arr[st.pop()];
                int left=st.isEmpty()?-1:st.peek();
                ans=Math.max(ans,(right-left-1)*height);
                
            }
            st.push(i);
        }
        while(!st.isEmpty()){
             int right=arr.length;
                int height=arr[st.pop()];
                int left=st.isEmpty()?-1:st.peek();
                ans=Math.max(ans,(right-left-1)*height);

        }
        return ans;
    }
}