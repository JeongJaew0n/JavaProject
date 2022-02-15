package hardLevel;

/* I'm going to use A* algorithm. */

/* 1. move the #.
   2. heuristic is more correct sort of the numbers.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N11112_EightPuzzle {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer stringBuffer = new StringBuffer();
    static PriorityQueue<Node> puzzlePath = new PriorityQueue<>();
    static HashSet<String> impossibleBoard = new HashSet<>();
    static HashMap<String, Integer> visitBoard = new HashMap<>();
    static int[] dirRow = {0, 0, -1, 1};    // 순서대로 상 하 좌 우.
    static int[] dirCol = {1, -1, 0, 0};

    /* 1.퍼즐에 대해서 4방향으로 이동해본다.
     * 2. 이동 되는 곳에 대해서 이동할 경우 f값을 구해서 가장 작은 값을 넣는다.(이미 방문한 곳은 빼고)
     *
     * */

    public static void main(String[] args) {
        char[][] inputPuzzle = setPuzzle();

    }

    static class Node {
        String board;
        int f; // g + h.
        int g; // cost of current to next.

        Node(String board, int f, int g) {
            this.board = board;
            this.f = f;
            this.g = g;
        }
    }

    static void findWithAStar() {
        while (!puzzlePath.isEmpty()) {
            Node currentNode = puzzlePath.poll();

            int currentRow = currentNode.board.indexOf('#') % 3;    // 현재 공백 위치의 행.
            int currentCol = currentNode.board.indexOf('#') / 3;    // 현재 공백 위치의 열.

            /* now, move the # and find better way. */
            String nextBoard = "";
            for (int i = 0; i < 4; i++) {   // 순서대로 상 하 좌 우.
                int nextRow = currentRow + dirCol[i];
                int nextCol = currentCol + dirRow[i];
                StringBuilder currentBoard = new StringBuilder(currentNode.board);
                if(isCorrectPath(nextRow,nextCol)){
                    nextBoard = moveNext(currentBoard,currentRow,currentCol,nextRow,nextCol);
                }
                if(visitBoard.containsKey(nextBoard)) continue;
                else{
                    int g = currentNode.g + 1;
                    int h = getHeuristicValue(nextBoard);
                    int f = g+h;
                    puzzlePath.add(new Node(nextBoard,f,g));
                    visitBoard.put(nextBoard,g);
                }
            }
        }
    }

    static String moveNext(StringBuilder next, int currentRow, int currentCol, int nextRow, int nextCol) {
        int currentIndex = currentCol * 3 + currentRow;
        int nextIndex = nextCol * 3 + nextRow;
        /* Here are two ways for change string. replace and StringBuffer or StringBuilder. */
        /* StringBuilder is better performance than StringBuffer in single-thread. so in this code, I'm going to use SB */
        next.setCharAt(currentCol,next.charAt(nextIndex));
        next.setCharAt(nextIndex,'#');

        return next.toString();
    }

    static boolean isCorrectPath(int nextRow, int nextCol) {
        if (nextRow > 0 && nextRow < 3 && nextCol > 0 && nextCol <= 3) {
            return true;
        }
        return false;
    }

    /* Make a char array to save the input. */
    static char[][] setPuzzle() {
        char[][] newBoard = new char[3][3];
        try {
            for (int i = 0; i < 3; i++) {
                newBoard[i] = br.readLine().toCharArray();
            }
            puzzlePath.add(new Node(newBoard.toString(), 0, 0));
            return newBoard;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static int getHeuristicValue(String data) {
        //이미 목표 위치에 있는 숫자가 많을수록 더 가치있다고 판단하였다.
        //Manhattan Distance나 다른 어떤 가치 판단 로직을 세워
        //더 효율적인 휴리스틱 펑션을 만들어도 된다.
        int count = 0;
        for (int i = 0; i < data.length(); i++) {
            if ("123456789".charAt(i) != data.charAt(i)) count++;//같은 위치에 다른 숫자면 conut++
        }
        return count;
    }

}
