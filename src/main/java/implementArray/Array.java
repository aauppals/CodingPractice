package implementArray;

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        //if array full, resize it - make new array 2x size
        if (items.length == count) {
            int[] newItems = new int[2 * count];
            //copy over elements to new array
            for (int i = 0; i < count; i++)
                newItems[i] = items[i];
            //set items to this new array
            items = newItems;
        }
        //add element to last index
        items[count] = item;
        count++;

    }

    public void removeAt(int index) {
        //validate index
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        //shift items to left to fill the hole
        for (int i = index; i < count; i++)
            items[i] = items[i + 1];

        count--;
    }

    public int index(int item) {
        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;

        return -1;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    public static void main(String[] args) {
        Array numbers = new Array(3);
        numbers.insert(1);
        numbers.insert(10);
        numbers.insert(40);
        numbers.insert(60);
        numbers.insert(80);
        numbers.removeAt(0);
        numbers.print();
    }
}

