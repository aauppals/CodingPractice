package implementHashMap;

import java.util.LinkedList;

class Entry {
    public int key;
    public int val;

    public Entry(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
//Each hashmap has following functions:
//i. Put
//ii. Get
//iii. Remove
//iv. Contains Key
//Can do all above in constant time, O(1), making it very efficient
//how is containsKey O(1) ?
//get key; mod it with the array's length;gives index to store key-value pair in
//hash collisions occur less often as array size gets larger
//when array size changes, index can change
//implement get, put, remove
//hashmap is an array of 'buckets'; key-value pairs are stored in buckets as linked list
//generally array is of size 16; good to use a large prime number for efficient hashing & storing

//get (int key):
// search the bucket index (using haschode); search in all entries for given key
//hashcode = key % size

//put (int key, int value)
//search bucket index using hashcode
//if hashmap [bucket] is null : create a new linked list and add current entry in it
// else, search all Entries for key given;
// if current key is present, override its value
// else add a new entry with current key, value


//remove (int key)
//search the bucket index using hashcode
// If hashmap[bucket] is null - no key found
// Else search in all entries for given key; if current key is present, remove the entry from bucket's linked list


//Time complexity for put, get & remove remains O(1)
//Space complexity - number of entries made into the map

public class implementHashmap {
    LinkedList<Entry>[] map;
    public static int SIZE = 769; //large prime number

    public implementHashmap() {
        map = new LinkedList[SIZE];
    }

    public int get(int key) {
        int bucket = key % SIZE;
        LinkedList<Entry> entries = map[bucket];
        if (map[bucket] == null) return -1;

        for (Entry entry : entries) {
            if (entry.key == key) return entry.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        //hash function to get bucket in ArrayList
        int bucket = key % SIZE;
        //check if bucket is empty
        if (map[bucket] == null) {
            map[bucket] = new LinkedList<Entry>();
            map[bucket].add(new Entry(key, value));
        } else {
            //if key is already present for entry, update value with new value, and exit put method
            //if put method not exited, then key was not found, and need to add value to current bucket
            for (Entry entry : map[bucket]) {
                if (entry.key == key) { //if key is the same but not hashcode, need to compare hashcode as well with
                    entry.val = value;
                    return;
                }
            }
            map[bucket].add(new Entry(key, value));
        }
    }

    public void remove(int key) {
        int bucket = key % SIZE;
        Entry toRemove = null;
        if (map[bucket] == null) return;
        else {
            for (Entry entry : map[bucket]) {
                if (entry.key == key) {
                    toRemove = entry;
                }
            }
            if (toRemove == null) return;
            map[bucket].remove(toRemove);
            //linkedlist remove works on an object
        }
    }

    public static void main(String[] args) {
        implementHashmap MyHashmap = new implementHashmap();
        MyHashmap.put(1, 50);
        MyHashmap.put(2, 100);

        System.out.println("For key = int (1):" + MyHashmap.get(1));
        System.out.println("For key = int (2):" + MyHashmap.get(2));

    }
}



