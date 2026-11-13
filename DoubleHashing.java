/**
 * A hashtable built from the Abstract Hashtable that uses double hashing
 * @param <E> object type to be stored
 * @author Amanda Migliori
 */
public class DoubleHashing<E> extends Hashtable {


    public DoubleHashing(int size) {
        super(size);
    }

    /**
     * finds a potential spot for a hashobject in the hashtable
     * @param object HashObject containing the key
     * @return possible location for the hashobject in the hashtable
     */
    @Override
    public int probe(HashObject object) {
        E key = (E) object.getKey();

        //these will both be positive and thus there's no reason to positvemod them
        return ((hash1(key) + (object.getProbeCount() * hash2(key))) % tableSize);

    }


    private int hash1(E key) {
        return positiveMod(key.hashCode(), tableSize);
    }

    private int hash2(E key) {
        return (1 + positiveMod(key.hashCode(),tableSize-2));
    }
}
