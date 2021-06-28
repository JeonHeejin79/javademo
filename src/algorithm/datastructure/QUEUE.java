package algorithm.datastructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 큐 Queue
 * - First In First Out
 *
 * - LinkedList 로 구현하는게 좋음
 *   > Queue 는 Interface 이고 구현체는 LinkedList 이다.
 *
 * - Queue의 변혼으로 Deque(덱, 또는 디큐) 가 생김.
 *   > Deque 는 양쪽 끝에 추가 삭제가 가능 하며 Dequeue 의 조상은 Queue 이다.
 *
 * - method
 *   element()  : 삭제없이 요소를 읽어온다. 비어있으면 NoSuchElementException 발생
 *   offer(obj) : Queue에 객체를 저장, 성공시 true, 실패시 false 반환
 *   poll()     : Queue에서 객체를 꺼내 반환, 비어있으면 null을 반환(예외 발생 x)
 *   peak()     : 삭제없이 요소를 읽어온다. Queue가 비어있으면 null을 반환(예외 발생 x)
 *   add(obj)   : 지정된 객체를 Queue에 추가함. 성공시 true를 반환한다.
 *                저장공간이 부족하면 IllegalStateException 발생
 *   remove()   : Queue에서 객체를 꺼내 반환, 비었으면 NoSuchElementException 발생
 *
 */
public class QUEUE {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<Integer>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        queue.poll();
    }
}
