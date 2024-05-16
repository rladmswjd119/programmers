package Solution_1;

import java.util.Objects;
import java.util.Stack;

public class 크레인 {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        크레인 k = new 크레인();
        System.out.println(k.solution(board, moves));
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> basket = new Stack<>();
        for(int m : moves) {
            for(int drawing = 0; drawing < board.length; drawing++) {
                if (board[drawing][m - 1] == 0) {
                    board[drawing][m - 1] = -1;
                    continue;
                }
                if(board[drawing][m - 1] > 0) {
                    basket.push(board[drawing][m - 1]);
                    board[drawing][m - 1] = -1;
                    break;
                }

            }

            System.out.println(m);
            System.out.println(basket);
            if(basket.size() >= 2 && Objects.equals(basket.get(basket.size() - 1), basket.get(basket.size() - 2))) {
                answer++;
                basket.pop();
                basket.pop();
            }
        }

        return answer*2;
    }
}
