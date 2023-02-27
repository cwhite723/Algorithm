import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            int result = 0;
            if(num==1) continue;
            if(num==2) {
                count++;
                continue;
            }
            for(int j=2; j<num; j++) {
                if(num%j==0) result = 1;
            }
            if(result==0) count++;
        }

        System.out.println(count);
    }
}