package problemEZ;

/* 빙고 판 생성
* - 5x5에 1~25 랜덤 값 생성.
* - hashset 사용해서 중복제거하면 되지만 쓰기 싫음.
*  왜냐면 set 에 중복값이 들어가지 않는다고 하더라도
*  똑같은 값이 random 에서 계속해서 나올 수 있기 때문.
*
* */

// int a = (int)(Math.random() & (num - i) + i) // i ~ num-i까지 임의의 정수

public class BingoWithoutSet {
    public static void main(String[] args) throws InterruptedException {
        int[][] bingo = new int[5][5];

        for (int i = 0; i < 25; i++) {
            int randomNumber = (int)(Math.random() * 24);
            System.out.println("randomNumber:" + randomNumber);
            Thread.sleep(500);

            while(bingo[randomNumber/5][randomNumber%5] != 0) {
                System.out.println("중복발생 재탐색:" + randomNumber);
                if(randomNumber == 0) randomNumber = 24;
                randomNumber--;
            }
            bingo[randomNumber/5][randomNumber%5] = i;
            System.out.println(String.format("Successful -> bingo[%d][%d]",randomNumber/5,randomNumber%5));
        }

        for (int i = 0; i < 25; i++) {
            if(i!=0 && i%5 == 0) System.out.println();
            System.out.print(String.format("%-3d",bingo[i/5][i%5]));
        }
    }
}
