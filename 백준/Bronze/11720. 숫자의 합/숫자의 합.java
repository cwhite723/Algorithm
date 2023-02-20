import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int sum = 0;

        String number = br.readLine();
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(Character.toString(number.charAt(i)));
            sum += arr[i];
        }

        System.out.println(sum);
    }
}