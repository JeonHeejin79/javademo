package algorithm.datastructure;

import java.util.LinkedList;

/*
* Hash table
* F(key)  -> HashCode -> Index -> Value
* 검색하고자하는 Key 값을 입력받아
* 해시함수로 돌려서 반환받은 HashCode 를
* 배열의 Index 로환산해서 데이터에 접근하는 자료구조이다.
*
* Hash Function
* 어떤 특정한 규칙으로 입력받은 Key 값으로
* 그 키값이 얼마나 큰지 상관없이 동일한 해시코드를 만들어준다.
* ex) 블록체인 , 거래기록을 서비스를 이용하는 모든 사용자들의 거래장부를 갖고있다.
*     모든 사람의 거래정보를 다저장하기에는 시간이 오래걸리기때문
*     그 정보를 해시코드를 만들어서 배포하고 사용자들이 거래할떄 그 해시코드가
*     같은지 비교를 한다. 입력데이터가 완벽히 일치해야만 동일한 해시코드를 만들어준다.
*
* 해시 테이블의 장점
*  : 검색속도가 빠르다. O(1)  ~  O(N)
* 해시 테이블의 단점
*  : 서로 다른키를 넣었는데 동일한 해시코드가 만들어져서 한 배열받에 저장되는경우
*    ->  Collision 이 발생한다.
*
* GET HASH CODE
* 1. k e y 입력받은 키값에 문자열의 각 아스키값을 더해서 해시코드를 만든다.
*    s(115) + u(117) + n(110) + g(103) = 445
* 2. 고정된 배열받을 만든다.
* 3. 해시코드를 배열방의 크기로 나누어 환산한다.  445 % 3 = 1
* 4. 배열방 안에  LinkedList 로 선언하고
* 5. 배열방에 데이터가 할당될때마다 LinkedList 에 데이터를 추가한다. 
*
* KEY       HASHCODE    INDEX   LIST
* "sung" --> 445         0   --> jin -> hee -> min
* "jin"  --> 321         1   --> sung
* "hee"  --> 306         2   -->
* "min"  --> 324         3   -->
*/
class HashTable {
    class Node { // 해시테이블에 저장할 데이터를 노드에 담는다.
        String key; // 검색할 키
        String value; // 검색결과
        // 노드를 생성할때 키워 객체를 받아서 값을 할당한다.
        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }
    // 데이터를 LinkedList 를 비열로 선언한다. Node 가 들어갈것이다.
    LinkedList<Node>[] data;
    // 해시테이블을 선언하는 순간 해시테이블을 얼만큼의 크기로 만들지
    // 크기를 미리 정해서 배열방을 미리 만들어 놓는다.
    HashTable(int size) {
        this.data = new LinkedList[size];
    }

    // key 를 받아서 해시코드를 반환하는 함수
    int getHashCode(String key) {
        int hashCode = 0;
        // letter 에 아스키값을 가져와서 더해준다.
        for (char c : key.toCharArray()) {
            hashCode += c;
        }
        return hashCode;
    }

    // hash 코드를받아서 배열방에 index 를 배정해주는 함수
    int convertToIndex(int hashcode) {
        return hashcode % data.length;
    }

    // index 로 배열받을 찾은 이후에 검색키를가지고 해당방의 노드를 찾아오는함수
    Node searchKey(LinkedList<Node> list, String key) {
        if (list == null) return null;
        for(Node node : list) {
            if (node.key.equals(key)) {
                // 같은키가 있어서 찾으면 노드를반호나
                return node;
            }
        }
        // 없으면 null 을 반환
        return null;
    }

    void put(String key, String value) {
        // 1. 해시코드를 가져온다.
        int hashCode = getHashCode(key);
        // 2. 배열방의 인덱스로 반환한다.
        int index = convertToIndex(hashCode);

        System.out.println("key : " + key + ", hashCode : " + hashCode + " , index : " + index);
        // 3. 배열받번호로 기존의 데이터의 배열을 가져온다.
        LinkedList<Node> list = data[index];
        // 배열방이 null 일경우 Linked 리스트를 생성한다.
        if (list == null) {
            list = new LinkedList<Node>();
            // 그리고 해당 리스트를 배열방에 넣어준다.
            data[index] = list;
        }

        // 해당 데이터키로 노드를 가직 있는지 받아온다.
        Node node = searchKey(list, key);
        if (node == null) {
            // 노드가 없다면 해당 배열방 리스트에 노드를 추가한다.
            list.addLast(new Node(key, value));
        } else {
            node.setValue(value);
        }
    }

    // get
    String get(String key) {
        int hash = getHashCode(key);
        int index = convertToIndex(hash);
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);
        return node == null? "Not found" : node.getValue();
    }
}
public class HASH {
    public static void main(String[] args) {
        HashTable h = new HashTable(3);

        h.put("jeon", "je");
        h.put("hee", "h");
        h.put("jin", "ji");
        h.put("min", "m");
        h.put("jeon", "jeon");

        System.out.println(h.get("jeon"));
        System.out.println(h.get("hee"));
        System.out.println(h.get("jin"));
        System.out.println(h.get("min"));
        System.out.println(h.get("jee"));
    }
}
