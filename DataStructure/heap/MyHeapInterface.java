package heap;

public interface MyHeapInterface<E> {
//
    /* 힙에 제네릭 타입의 데이터를 추가합니다.
    * @param <E> 타입 데이터를 추가하고 추가한 데이터를 반환합니다.
    */
    public E add(E e);

    /* 힙에서 데이터를 삭제합니다.
    * @param root 노드의 데이터를 삭제하고 반환합니다.
    * */
    public E remove();
}
