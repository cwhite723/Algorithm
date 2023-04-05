import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] numArr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        numArr[1] = Integer.parseInt(st.nextToken());
        for(int i=2; i<=n; i++) {
            numArr[i] = numArr[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int k=0; k<m; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int sum = numArr[j]-numArr[i-1];
            sb.append(sum).append("\n");
        }

        System.out.println(sb.toString());
    }
}