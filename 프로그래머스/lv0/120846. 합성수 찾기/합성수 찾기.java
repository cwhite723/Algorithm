class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=3; i<=n; i++) {
            int count=0;
            for(int k=1; k<=i; k++) {
                if(i%k==0) count++;
            }
            if(count>=3) answer++;
        }
        return answer;
    }
}