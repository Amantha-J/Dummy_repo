import java.io.*;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;

/**
 * Driver Class for comparing efficiencies of hashtables using linear probing vs hashtables using double probing
 * @author Amanda Migliori
 */

public class HashtableExperiment {


    /**
     * Private usage statement printer
     */
    private static void printUsageStatement() {
        System.out.println("Usage: java HashtableExperiment <dataSource> <loadFactor> [<debugLevel>]\n" +
                "       <dataSource>: 1 ==> random numbers\n" +
                "                     2 ==> date value as a long\n" +
                "                     3 ==> word list\n" +
                "       <loadFactor>: The ratio of objects to table size, \n" +
                "                       denoted as a float a S.T. 0 < a < 1\n" +
                "       <debugLevel>: 0 ==> print summary of experiment\n" +
                "                     1 ==> save the two hash tables to a file at the end\n" +
                "                     2 ==> print debugging output for each insert\n");
    }


    public static void main(String[] args) {

        //Args Validation
        if (args.length < 2 || args.length > 3) {
            printUsageStatement();
            System.exit(1);
        }

        double loadFactor = Double.parseDouble(args[1]);

        if(loadFactor > 1) {
            printUsageStatement();
            System.exit(1);
        }

        int tableSize = TwinPrimeGenerator.generateTwinPrime(95500, 96000);
        int numInserts = (int)Math.ceil(tableSize*Double.parseDouble(args[1]));

        System.out.println("Twin prime " + tableSize + " found");


        //getting other Arg Values
        int dataType = Integer.parseInt(args[0]);
        int output = 0;
        if (args.length == 3) {
            output = Integer.parseInt(args[2]);
        }

        //Establishing Hashtables
        LinearProbing<HashObject<Object>> linear = new LinearProbing<>(tableSize);
        DoubleHashing<HashObject<Object>> doubleP = new DoubleHashing<>(tableSize);

        //Switching to determine the dataType
        switch (dataType) {
            case 1:
                if(output ==2){
                    testWithIntegersDebug(linear, doubleP, numInserts);
                }
                else {
                    testWithIntegers(linear, doubleP, numInserts);
                }
                break;
            case 2:
                if(output == 2) {
                    testWithDateDebug(linear, doubleP, numInserts);
                }
                else {
                    testWithDate(linear, doubleP, numInserts);
                }
                break;
            case 3:
                if (output == 2) {
                    testWithWordsDebug(linear,doubleP,numInserts);
                }
                else {
                    testWithWords(linear,doubleP,numInserts);
                }
                break;
            default:
                System.exit(1);
        }


        switch (output) {
            case 0:
                printTableStats(linear,doubleP);
                break;
            case 1:
                printAndDumpTable(linear,doubleP);
                break;
        }
    }

    /**
     * Private method that prints the results of the Hashtable Experiment and dumps the tables into a file
     * @param linear linear probing hash table
     * @param doubleP double probing hash table
     */
    private static void printAndDumpTable(Hashtable linear, Hashtable doubleP) {
        DecimalFormat format = new DecimalFormat("0.00");
        System.out.println("Using Linear Probing\n" +
                "HashtableExperiment: size of hash table is "+ linear.numElements +"\n" +
                "        Inserted "+linear.numInserts+ " elements, of which "+ linear.numDupes +" were duplicates\n" +
                "        Avg. no. of probes = "+ format.format((double)linear.numProbes/(double)linear.numElements));
        linear.dumpToFile("linear-dump.txt");
        System.out.println("\n");
        System.out.println("Using Double Hashing\n" +
                "HashtableExperiment: size of hash table is "+ doubleP.numElements +"\n" +
                "        Inserted "+doubleP.numInserts+ " elements, of which "+ doubleP.numDupes +" were duplicates\n" +
                "        Avg. no. of probes = "+ format.format((double)doubleP.numProbes/(double)doubleP.numElements));
        doubleP.dumpToFile("double-dump.txt");
        System.out.println();
    }


    /**
     * Prints the statistics for both hashtables
     * @param linear linear Probing Hash Table
     * @param doubleP double probing hash table
     */
    private static void printTableStats(Hashtable linear, Hashtable doubleP) {
        DecimalFormat format = new DecimalFormat("0.00");
        System.out.println("Using Linear Probing\n" +
                "HashtableExperiment: size of hash table is "+ linear.numElements +"\n" +
                "        Inserted "+linear.numInserts+ " elements, of which "+ linear.numDupes +" were duplicates\n" +
                "        Avg. no. of probes = "+ format.format((double)linear.numProbes/(double)linear.numElements) + "\n");
        System.out.println();
        System.out.println("Using Double Hashing\n" +
                "HashtableExperiment: size of hash table is "+ doubleP.numElements +"\n" +
                "        Inserted "+doubleP.numInserts+ " elements, of which "+ doubleP.numDupes +" were duplicates\n" +
                "        Avg. no. of probes = "+ format.format((double)doubleP.numProbes/(double)doubleP.numElements) + "\n");
    }


    /**
     * Tests the hashtables by inserting a specified number of consecutive Date objects
     * @param linear hashtable that uses linear probing
     * @param doubleP hashtable that uses double probing
     * @param numInserts number of unique elements to insert into the table
     */
    private static void testWithDate(Hashtable linear, Hashtable doubleP, int numInserts) {

        long currentTime = new Date().getTime();

        while (linear.numElements < numInserts) {
            Date date = new Date(currentTime);

            linear.insert(date);
            doubleP.insert(date);

            currentTime += 1000;

        }
    }

    /**
     * Tests the hashtables by inserting a specified number of consecutive Date objects.
     * Prints the details of each attempted insertion for debug 2 output
     * @param linear hashtable that uses linear probing
     * @param doubleP hashtable that uses double probing
     * @param numInserts number of unique elements to insert into the table
     */
    private static void testWithDateDebug(Hashtable linear, Hashtable doubleP, int numInserts) {

        long currentTime = new Date().getTime();

        while (linear.numElements < numInserts) {
            Date date = new Date(currentTime);

            System.out.println("Attempting to insert: " + date);

            int in1 = linear.insert(date);
            int in2 = doubleP.insert(date);

            if (linear.getHashObject(in1).getFrequency() > 1) {
                System.out.println("Duplicate Element Stored at: " + in1+ "\n");
            }
            else {
                System.out.println(date + " Inserted at\n" +
                        "Linear: " + in1 + " After " + linear.getHashObject(in1).getProbeCount() +" probes \n" +
                        "Double: " +in2 + " After " + doubleP.getHashObject(in2).getProbeCount() +" probes\n");
            }
            currentTime += 1000;

        }
    }


    /**
     * Private method that tests the hash table by inserting a specified number of randomly generated integer values
     * @param linear hashtable that uses linear probing
     * @param doubleP hashtable that uses double probing
     * @param numInserts number of items to successfully insert into the hash table
     */
    private static void testWithIntegers(Hashtable linear, Hashtable doubleP, int numInserts) {

        Random numGen = new Random();

        while (linear.numElements < numInserts) {
            int inNum = numGen.nextInt();

            linear.insert(inNum);
            doubleP.insert(inNum);
        }
    }

    /**
     * Private method that tests the hash table by inserting a specified number of randomly generated integer values.
     * Prints the details of each attempted insertion for debug 2 output
     * @param linear hashtable that uses linear probing
     * @param doubleP hashtable that uses double probing
     * @param numInserts number of items to successfully insert into the hash table
     */
    private static void testWithIntegersDebug(Hashtable linear, Hashtable doubleP, int numInserts) {

        Random numGen = new Random();

        while (linear.numElements < numInserts) {
            int inNum = numGen.nextInt();
            System.out.println("Attempting to insert: " + inNum);

            int in1 = linear.insert(inNum);
            int in2 = doubleP.insert(inNum);

            if (linear.getHashObject(in1).getFrequency() > 1) {
                System.out.println("Duplicate Element Stored at: " + in1+ "\n");
            }
            else {
                System.out.println(inNum + " Inserted at\n" +
                        "Linear: " + in1 + " After " + linear.getHashObject(in1).getProbeCount() +" probes \n" +
                        "Double: " +in2 + " After " + doubleP.getHashObject(in2).getProbeCount() +" probes\n");
            }
        }
    }

    /**
     * Inserts strings from the WordList.txt file into the hashtables
     * @param linear hashtable that uses linear probing
     * @param doubleP hashtable that uses double probing
     * @param numInserts number of items to successfully insert into the hash table
     */
    public static void testWithWords(Hashtable linear, Hashtable doubleP, int numInserts) {
        try {

            BufferedReader wordReader = new BufferedReader(new FileReader("word-list.txt"));


            while (linear.numElements < numInserts) {
                String inElement = wordReader.readLine();
                linear.insert(inElement);
                doubleP.insert(inElement);
            }

            wordReader.close();

        }
        catch (FileNotFoundException e) {
            System.out.println("Error Reading From File");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Inserts strings from the WordList.txt file into the hashtables.
     * Prints the details of each attempted insertion for debug 2 output
     * @param linear hashtable that uses linear probing
     * @param doubleP hashtable that uses double probing
     * @param numInserts number of items to successfully insert into the hash table
     */
    public static void testWithWordsDebug(Hashtable linear, Hashtable doubleP, int numInserts) {
        try {
            BufferedReader wordReader = new BufferedReader(new FileReader("word-list.txt"));

            while (linear.numElements < numInserts) {
                String inElement = wordReader.readLine();
                System.out.println("Attempting to insert: " + inElement);

                int in1 = linear.insert(inElement);
                int in2 = doubleP.insert(inElement);

                if (linear.getHashObject(in1).getFrequency() > 1) {
                    System.out.println("Duplicate Element Stored at: " + in1+ "\n");
                }
                else {
                    System.out.println(inElement + " Inserted at\n" +
                            "Linear: " + in1 + " After " + linear.getHashObject(in1).getProbeCount() +" probes \n" +
                            "Double: " +in2 + " After " + doubleP.getHashObject(in2).getProbeCount() +" probes\n");
                }
            }
            wordReader.close();

        }
        catch (FileNotFoundException e) {
            System.out.println("Error Reading From File");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}




