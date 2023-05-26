import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int minPrice = Integer.MAX_VALUE;
    private static int cntPotion; // 물약 개수
    private static int[] price; // 각 물약의 가격
    private static List<List<Potion>> graph; // 할인 정보 리스트
    private static boolean[] isVisited;

    private static class Potion{
        private int number;
        private int discount;

        public Potion(int number, int discount) {
            this.number = number;
            this.discount = discount;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 1; i <= cntPotion; i++) {
            isVisited[i] = true;
            solve(i, price[i], 1, price);
            isVisited[i] = false;
        }
        output();
    }

    private static void output() {
        System.out.println(minPrice);
    }

    private static void solve(int start, int totalPrice, int depth, int[] originPrice) {
        if (depth == cntPotion) {
            minPrice = Math.min(minPrice, totalPrice);
        }

        for (int k = 1; k <= cntPotion; k++) {
            if (!isVisited[k]) {
                isVisited[k] = true;
                int[] copyPrice = Arrays.copyOf(originPrice, originPrice.length);

                for (int i = 0; i < graph.get(start).size(); i++) {
                    Potion cur = graph.get(start).get(i);
                    copyPrice[cur.number] -= cur.discount;

                    if (copyPrice[cur.number] <= 0) copyPrice[cur.number] = 1;
                }
                solve(k, totalPrice + copyPrice[k], depth + 1, copyPrice);
                isVisited[k] = false;
            }
        }

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cntPotion = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= cntPotion; i++) {
            graph.add(new ArrayList<>());
        }

        price = new int[cntPotion + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cntPotion; i++) {
            price[i + 1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < cntPotion; i++) {
            int cnt = Integer.parseInt(br.readLine());

            for (int k = 0; k < cnt; k++) {
                st = new StringTokenizer(br.readLine());

                int discountNum = Integer.parseInt(st.nextToken());
                int discountPrice = Integer.parseInt(st.nextToken());
                graph.get(i + 1).add(new Potion(discountNum, discountPrice));
            }
        }

        isVisited = new boolean[cntPotion + 1];
    }
}
