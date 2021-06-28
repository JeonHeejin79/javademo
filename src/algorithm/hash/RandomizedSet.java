package algorithm.hash;

import java.util.*;

/**
 * Insert Delete GetRandom O(1)
 * Design a data structure that supports all flowing operations in average O(1) time
 * 1. insert(val) : Insert an item val to the set if not already present.
 * 2. remove(val) : Removes an item val from the set if present
 * 3. getRandom : Returns a random element from current set of elements.
 *                Each element must have the same probability of being returned
 *
 * Example
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // Inserts 1 to the set. Returns true as
 * 1 was inserted successfully.
 * randomSet.insert(1);
 *
 * // Returns false as 2 does not exist in
 * randomSet.remove(2);
 *
 * // Insert 2 to the set, return true. Set now contains [1, 2]
 * randomSet.insert(2);
 *
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 *
 * // Removes 1 from the set, returns true. Set now conains[2].
 * randomSet.remove(1);
 *
 */
class RandomSet {

    // key : element, value: index in the list
    Map<Integer, Integer> map;
    ArrayList<Integer> list;
    // size  valid elements number in the list
    int size;
    Random r = new Random();

    /** Initialize your data structure here*/
    public RandomSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        size = 0;
    }

    /**
     * Insert a value to the set. Returns true if the set did not already
     * contain the specific element
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, size++);
        list.add(val);
        return true;
    }

    /**
     * Remove a value from the set. Returns true if the set contained
     * the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int idx = map.get(val);
        map.remove(val);

        if (idx != size -1) {
            int swap = list.get(size-1);
            list.set(idx, swap);
            map.put(swap, idx);
        }
        list.remove(--size); //마지막을 지움
        return true;
    }

    /**
     * Get a random element from the set
     */
    public int getRandom() {

        int idx = r.nextInt(size);
        System.out.println("getRandom > r.nextInt("+size+") = " + idx+ ", list.get("+idx+") = " + list.get(idx));
        return list.get(idx);
    }
}

class RandomSet2 {
    Map<Integer, Integer> map;
    ArrayList<Integer> list;
    int size;
    Random random = new Random();

    /** Initialize your data structure here*/
    public RandomSet2() {
        map = new HashMap<>();
        list = new ArrayList<>();
        size = 0;
    }

    /**
     * Insert a value to the set. Returns true if the set did not already
     * contain the specific element
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, size++);
        list.add(val);
        return true;
    }

    /**
     * Remove a value from the set. Returns true if the set contained
     * the specified element.
     * List : 1 2 3 4  Map : {1=0, 2=1, 3=2, 4=3}
     * List : 1 4 3  Map : {1=0, 3=2, 4=1}
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int idx = map.get(val);
        map.remove(val);
        if (idx+1 != size) {
            int last = list.get(size-1);
            map.put(last, idx);
            list.set(idx, last);
        }
        list.remove(--size);
        return true;
    }

    /**
     * Get a random element from the set
     */
    public int getRandom() {
        int a = random.nextInt(size);
        int rs = list.get(a);
        return rs;
    }
}

public class RandomizedSet {

    public static void main(String[] args) {

        int random1 = 0;
        int random2 = 0;

        RandomSet randomSet = new RandomSet();
        randomSet.insert(1);
        randomSet.insert(2);
        randomSet.insert(3);
        randomSet.insert(4);

        System.out.print("List : ");
        randomSet.list.stream().forEach( i-> System.out.print(i.toString() + " "));
        System.out.print(" Map : ");
        Arrays.asList(randomSet.map).stream().forEach(v -> System.out.print(v.toString() + " "));
        System.out.println();

        random1= randomSet.getRandom();
        random2 = randomSet.getRandom();
        System.out.println("random : " + random1 + " " + random2);

        randomSet.remove(2);
        System.out.println("remove 2---------------------------");
        System.out.print("List : ");
        randomSet.list.stream().forEach( i-> System.out.print(i.toString() + " "));
        System.out.print("Map : ");
        Arrays.asList(randomSet.map).stream().forEach(v -> System.out.print(v.toString() + " "));
        System.out.println();

        random1= randomSet.getRandom();
        random2 = randomSet.getRandom();
        System.out.println("random : " + random1 + " " + random2);

        System.out.println("===============================================");

        RandomSet2 randomSet2 = new RandomSet2();
        randomSet2.insert(1);
        randomSet2.insert(2);
        randomSet2.insert(3);
        randomSet2.insert(4);

        System.out.print("List : ");
        randomSet2.list.stream().forEach( i-> System.out.print(i.toString() + " "));
        System.out.print("Map : ");
        Arrays.asList(randomSet2.map).stream().forEach(v -> System.out.print(v.toString() + " "));
        System.out.println();

        random1= randomSet.getRandom();
        random2 = randomSet.getRandom();
        System.out.println("random : " + random1 + " " + random2);

        randomSet2.remove(2);
        System.out.println("remove 2---------------------------");
        System.out.print("List : ");
        randomSet2.list.stream().forEach( i-> System.out.print(i.toString() + " "));
        System.out.print("Map : ");
        Arrays.asList(randomSet2.map).stream().forEach(v -> System.out.print(v.toString() + " "));
        System.out.println();

        random1= randomSet.getRandom();
        random2 = randomSet.getRandom();
        System.out.println("random : " + random1 + " " + random2);

    }

}
