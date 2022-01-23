package heap;

/* 배열로 구현합니다.
*   최소 힙을 구현합니다.(최대 힙도 가능)
* */

import java.util.Arrays;

public class MyHeap implements  MyHeapInterface<Integer>{

    int[] datas;    // 데이터들이 저장된 배열 입니다.
    int capacity = 10;  // 초기 저장 용량입니다.

    int last = 0; // 데이터가 추가돼야할 마지막 인덱스를 기억합니다.

    MyHeap() {
        datas = new int[capacity];
    }

    MyHeap(int capacity){
        datas = new int[capacity];
    }

    private void resize() {     // 배열의 용량을 재설정합니다. 2배씩 증가합니다.
        if(datas != null) {
            if (datas.length == last+1) {  // 만약 용량이 꽉 찬 경우
                datas = Arrays.copyOf(datas,datas.length * 2);
                return;
            }

            if(last+1 < datas.length/2){  // 가용량의 절반 미만으로 쓰고 있을 경우
                datas = Arrays.copyOf(datas,datas.length/2);
                return;
            }

        }
        System.out.println("재설정할 배열이 없습니다!");
    }

    @Override
    public Integer add(Integer integer) {
        if(last == 0) {
            datas[last] = integer;
            last++;
            return integer;
        }
        datas[last] = integer;
        for(int i=last; i==1; i/=2) {       // 최소 힙이므로 오름차순 정렬. 부모보다 작으면 위치 바꿈.
            if(datas[last] > datas[last/2]) {
                break;
            }
            int temp = datas[last];
            datas[last] = datas[last/2];
            datas[last/2] = temp;
        }
        last++;
        return integer;
    }

    @Override
    public Integer remove() {
        if(last == 0) {
            System.out.println("제거할 요소가 없습니다");
            return null;
        }
        int removedData = datas[0];
        datas[0] = datas[last - 1];

        // 여기서 비교를 해야 하는데... 위에서도 실수했지만 Comparable 혹은 Comparator 를 추가해서 비교가 가능하게 해야한다.
        // 이 코드는 Integer 이므로 그냥 비교 연산자를 사용해도 되지만... 다른 클래스를 사용 시에는 꼭 비교가능 하도록 구현해주자.

        /* 왼쪽과 자식의 값을 가져와서 비교를 한 뒤 더 작은놈의 인덱스와 값을 저장해 뒀다가 부모와 비교함
        *  부모가 더 작다면 거기서 끝이지만 부모가 크다면 계속 반복.
        * 왼쪽 자식노드의 인덱스가 더 작으므로 왼쪽 자식의 인덱스가 힙의 사이즈보다 커지면 종료.
        * */

        return removedData;
    }
}
