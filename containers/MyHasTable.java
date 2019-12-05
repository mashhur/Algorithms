package containers;

/**
 * Created by mashhur on 10/21/17.
 */

public class MyHasTable {

    // use current size for optimization
    private static final int MAX_SIZE = 256;
    private LinkedList table[] = new LinkedList[MAX_SIZE];

    public static void main(String args[]) {
        MyHasTable myHasTable = new MyHasTable();
        myHasTable.put(1, 10);
        myHasTable.put(2, 20);
        myHasTable.put(1, 30);
        myHasTable.print();

        try {
            System.out.println(myHasTable.get(1));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static int getHashCode(int key) {
        return key % MAX_SIZE;
    }

    // put, update
    public void put(int key, int value) {
        int idx = getHashCode(key);
        if (table[idx] == null)
            table[idx] = new LinkedList();
        table[idx].put(new Node(key, value));
    }

    // get
    public int get(int key) throws Exception {
        int idx = getHashCode(key);
        if (table[idx] == null) {
            throw new Exception("");
        }

        return (int) table[idx].get(key).data;
    }

    // delete
    public void remove(int key) {
        table[getHashCode(key)].remove(key);
    }

    public void print() {
        for (int i = 0; i < MAX_SIZE; i++) {
            LinkedList list = table[i];
            if (list != null)
                list.print();
        }
    }
}
