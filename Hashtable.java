import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * HashTable That stores objects of type E
 * Not meant to actually be used, exists for experimentation purposes
 * @author Amanda Migliori
 * @param <E> type of object to hold
 */
public abstract class Hashtable<E> {

    protected HashObject<E>[] array;
    protected int tableSize;
    protected int numElements;
    protected int numDupes;
    protected int numProbes;
    protected int numInserts;

    /**
     * Creates a hashtable that stores hashobjects each containing an element
     * @param tableSize Size for the hashtable
     */
    public Hashtable(int tableSize) {
        this.array = new HashObject[tableSize];
        this.tableSize = tableSize;
        this.numElements =0;
        this.numDupes = this.numProbes = this.numInserts = 0;
    }


    /**
     * Inserts an item into the hash table by creating a hashobject and probing until it finds an empty spot
     * @param element element to store
     * @return location the element ends up or -1 if the hash table is full
     */
    public int insert(E element) {
        HashObject<E> newObject = new HashObject<>(element);
        int i = 0;
        numInserts++;

        while(i < tableSize) {
            int spot = probe(newObject);
            newObject.incrementProbeCount();

            if(array[spot] == null) {
                array[spot] = newObject;
                numProbes += newObject.getProbeCount();
                numElements++;
                return spot;
            }
            else if (newObject.equals(array[spot])) {
                array[spot].incrementFrequency();
                numDupes++;
                return spot;
            }
            else {
                i++;

            }
        }

        return -1;
    }

    /**
     * Searches the hash table for the specified object
     * @param searchObj object to search for
     * @return the index of the object, or -1 if the element isn't in the table
     */
    public int search(E searchObj) {

        HashObject<E> searchNode = new HashObject<E>(searchObj);
        int i = 0;

        while(i < tableSize) {
            int spot = probe(searchNode);

            if(array[spot].equals(searchNode)) {
                return spot;
            }
            else {
                i++;
                searchNode.incrementProbeCount();
            }
        }

        return -1;
    }

    /**
     * Removes an element from the hash table
     * @param element element to have removed
     * @return true or false based on if the element was removed.
     */
    public boolean delete(E element) {
        HashObject<E> newObject = new HashObject<E>(element);
        int i = 0;

        while(i < tableSize) {
            int spot = probe(newObject);

            if(array[spot].equals(newObject)) {
                array[spot] = null;
                return true;
            }
            else {
                i++;
                newObject.incrementProbeCount();
            }
        }

        return false;
    }

    /**
     * Gets the key for the hashobject at the specified index
     * @param index Index to get the element from
     * @return key of the hashobject at the specified element, or null if the spot is empty
     */
    public E get(int index) {
        if (array[index] == null) {
            return null;
        }
        return (E)array[index].getKey();
    }


    /**
     * Protected method for mod operations while preserving positive integers
     * @param dividend dividend for mod operations
     * @param divisor divisor for mod operations
     * @return remainder
     */
    protected int positiveMod (int dividend, int divisor) {
        int quotient = dividend % divisor;
        if (quotient < 0)
            quotient += divisor;
        return quotient;
    }

    /**
     * Helper method that gives the hash object stored at the specified index
     * @param index Index of the hashobject
     * @return the hash object at the index, or null if the spot is empty
     */
    public HashObject<E> getHashObject(int index) {
        if (array[index] == null) {
            return null;
        }
        return array[index];
    }

    /**
     * Get the number of duplicate items that had been inserted into the table
     * @return number of duplicate items that had been inserted
     */
    public int getDupes() {
        return numDupes;
    }

    /**
     * Prints the non-null contents of the table to a file
     * @param fileName Name of the file to save as
     */
    public void dumpToFile(String fileName) {
        try {
            PrintWriter out = new PrintWriter(fileName);
            for (int i = 0;i<tableSize;i++) {
                if (array[i] != null) {
                    out.print("table[" + i +"]: ");
                    out.println(array[i].toString());
                }
            }
            System.out.println("HashtableExperiment: Saved dump of hash table");
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could Not Create File");
            System.exit(1);
        }
    }

    /**
     * Prints the non-null contents of the table to the console
     */
    public void printTable() {
        int i =0;

        while (i < tableSize) {
            if (array[i] != null) {
                System.out.print("Table [" + i +"]: ");
                System.out.println(array[i]);
            }
            i++;
        }
    }

    /**
     * Probes the table to find an empty spot using the specified hashing method
     * @param object HashObject containing the key
     * @return
     */
    public abstract int probe(HashObject<E> object);

}
