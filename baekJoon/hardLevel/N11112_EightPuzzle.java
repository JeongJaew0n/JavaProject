package hardLevel;

/* I'm going to use A* algorithm. */

/* 1. move the #.
   2. heuristic is more correct sort of the numbers.
* */

import java.io.*;
import java.util.*;

public class N11112_EightPuzzle {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder stringBuilder = new StringBuilder();
    static PriorityQueue<Node> puzzlePath = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.g - o2.g;
        }
    });     // Node class is made by me. It needs to implement the Comparable or use Inner Class of the Comparator like this.
    static HashSet<String> impossibleBoard = new HashSet<>();
    static HashMap<String, Integer> visitBoard = new HashMap<>();
    static int[] dirRow = {0, 0, -1, 1};    // 순서대로 상 하 좌 우.
    static int[] dirCol = {-1, 1, 0, 0};

    /* 1.퍼즐에 대해서 4방향으로 이동해본다.
     * 2. 이동 되는 곳에 대해서 이동할 경우 f값을 구해서 가장 작은 값을 넣는다.(이미 방문한 곳은 빼고)
     * 생각하는 과정이였음.
     * */

    public static void main(String[] args) {

        try {
            int puzzleCount = Integer.parseInt(br.readLine());

            for( int i=0; i<puzzleCount; i++ ) {
                if(i!=0) bw.append("\n");
                setPuzzle();

                String result = findWithAStar();
                bw.append(result);
                if(result.equals("impossible")){
                    for(String value: visitBoard.keySet()) {
                        impossibleBoard.add(value);
                    }
                }
            }
            bw.flush();
            bw.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
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

    static String findWithAStar() {
        while (!puzzlePath.isEmpty()) {
            Node currentNode = puzzlePath.poll();
            if(currentNode.board.indexOf('#') == -1) {
                continue;
            }
            int currentRow = currentNode.board.indexOf('#') % 3;    // 현재 공백 위치의 행.
            int currentCol = currentNode.board.indexOf('#') / 3;    // 현재 공백 위치의 열.



            if(impossibleBoard.contains(currentNode.board)){
                return "impossible";
            }

            /* now, move the # and find better way. */
            boolean isImpossible = true;
            String nextBoard = "";
            for (int i = 0; i < 4; i++) {   // 순서대로 상 하 좌 우.
                int nextRow = currentRow + dirRow[i];
                int nextCol = currentCol + dirCol[i];
                StringBuilder currentBoard = new StringBuilder(currentNode.board);
                if(isCorrectPath(nextRow,nextCol)){
                    nextBoard = moveNext(currentBoard,currentRow,currentCol,nextRow,nextCol);
                    isImpossible = false;
                }
                if(visitBoard.containsKey(nextBoard)) continue; // 만약 움직일려 하는 곳이 방문한 곳이라면
                else{
                    int g = currentNode.g + 1;
                    int h = getHeuristicValue(nextBoard);
                    int f = g+h;
                    puzzlePath.add(new Node(nextBoard,f,g));    // 이게 어떻게 보면 OpenList.
                    // 우선순위 큐이기 때문에 우선순위대로 정렬하면 우선순위 높은게 바로 ClosedLIst 형태가 됨.
                    visitBoard.put(nextBoard,g);    // 방문한 보드로 추가.
                }
            }
            if(visitBoard.containsKey("12345678#")){
                return visitBoard.get("12345678#") + "";
            }
            if(isImpossible && !nextBoard.equals("12345678#")) impossibleBoard.add(nextBoard);
        }
        return "impossible";
    }

    static String moveNext(StringBuilder next, int currentRow, int currentCol, int nextRow, int nextCol) {
        int currentIndex = currentCol * 3 + currentRow;
        int nextIndex = nextCol * 3 + nextRow;
        /* Here are two ways that change string. replace and StringBuffer or StringBuilder. */
        /* StringBuilder is better performance than StringBuffer in single-thread. so in this code, I'm going to use SB */
        next.setCharAt(currentIndex,next.charAt(nextIndex));
        next.setCharAt(nextIndex,'#');
        return next.toString();
    }

    static boolean isCorrectPath(int nextRow, int nextCol) {
        if (nextRow >= 0 && nextRow < 3 && nextCol >= 0 && nextCol < 3) {
            return true;
        }
        return false;
    }

    /* Make a char array to save the input. */
    static char[][] setPuzzle() {
        char[][] newBoard = new char[3][3];
        puzzlePath.clear();
        visitBoard.clear();
        try {
            String check = "";
            for (int i = 0; i < 3;) {
                if((check = br.readLine()).length() > 2) {
                    newBoard[i] = check.toCharArray();
                    stringBuilder.append(newBoard[i]);
                    i++;
                }
            }
            puzzlePath.add(new Node(stringBuilder.toString(), 0, 0));
            visitBoard.put(stringBuilder.toString(),0);
            stringBuilder.setLength(0);
            return newBoard;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static int getHeuristicValue(String data) {
        int count = 0;
        for (int i = 0; i < data.length(); i++) {
            if ("12345678#".charAt(i) != data.charAt(i)) count++;
        }
        return count;
    }

}
