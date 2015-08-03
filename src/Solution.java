class Solution {
	
    public int solution(int[] A) {
        // write your code in Java SE 8
        int sum = 0, count = 0;
        for (int i = 0; i < A.length; i++) {
            for(int j = i; j < A.length;j++){
                if (sum > 0) {
                    sum += A[j];
                    if(sum == 0){
                        count++;
                        break;
                    }    
                }
                else {
                    sum = A[j];
                }
            }            
        }
        return count;
    }
}


