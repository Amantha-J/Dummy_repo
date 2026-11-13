/**
 * Hashtable built off the abstract Hashtable class that uses linear probing
 * @param <E> object type to be stored in the hash table
 * @author Amanda Migliori
 */

public class LinearProbing<E> extends Hashtable<E>{

    /**
     * Makes a new hashtable that uses linear probing
     * @param size hashtable size
     */
    public LinearProbing(int size) {
        super(size);
    }

    /**
     * uses linear probing to find a possible location of a probe object
     * @param object hashObject to be used for probing
     * @return possible location for the hashobject in the hash table
     */
    @Override
    public int probe(HashObject object) {
        E key = (E) object.getKey();
        return (positiveMod(key.hashCode(), tableSize) + object.getProbeCount()) % tableSize;

    }
}
