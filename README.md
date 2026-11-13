# Project 3: Hashtable Experiment

* Author: Amanda Migliori
* Class: CS321 Section 01
* Semester: Fall


## Overview

HashtableExpeeriment compares the effectiveness of linear vs double probing by
inserting a defined large number of elements into 2 different hashtables, one using linear probing
and the other using double hashing. And then averaging the number of probes it takes per table
to insert an element.

## Reflection

The 'ah ha' moment for this project came really early. The biggest problem I had with this
was with pulling data from the file and the moment I stopped using a scanner and moved to a 
Buffered Reader literally all my problems went away. After that I had to find out why every single
line was different despite them looking the same and then realizing that I was capitalizing the t in
table. 

I feel like my writing went really well. I tried to be proactive about my javadocs so I didn't have
to go back and comment all of it and that really paid of for when I returned and could instantly
parse what everything did. I really only had minor understanding problems, like adding loadfactor
number of items instead of filling till we had loadfactor items in the table.

## Compiling and Using

To compile, compile the main program HashtableExperiment.java with the command:
javac HashtableExperiment.java

For usage: java HashtableExperiment <dataSource> <loadFactor> \[\<debugLevel>]

\<dataSource>: \
1 ==> random numbers \
2 ==> date value as a long\
3 ==> word list\
\<loadFactor>: \
The ratio of objects to table size, denoted by alpha = n/m \
\<debugLevel>: \
0 ==> print summary of experiment \
1 ==> save the two hash tables to a file at the end\
2 ==> print debugging output for each insert


## Results 

### Random Numbers:

--------------------------------------------------------------------------------
Twin prime 95791 found
Using Linear Probing
HashtableExperiment: size of hash table is 47896
Inserted 47897 elements, of which 1 were duplicates
Avg. no. of probes = 1.50


Using Double Hashing
HashtableExperiment: size of hash table is 47896
Inserted 47897 elements, of which 1 were duplicates
Avg. no. of probes = 1.39

--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
Twin prime 95791 found
Using Linear Probing
HashtableExperiment: size of hash table is 57475
Inserted 57475 elements, of which 0 were duplicates
Avg. no. of probes = 1.75


Using Double Hashing
HashtableExperiment: size of hash table is 57475
Inserted 57475 elements, of which 0 were duplicates
Avg. no. of probes = 1.53

--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
Twin prime 95791 found
Using Linear Probing
HashtableExperiment: size of hash table is 67054
Inserted 67054 elements, of which 0 were duplicates
Avg. no. of probes = 2.16


Using Double Hashing
HashtableExperiment: size of hash table is 67054
Inserted 67054 elements, of which 0 were duplicates
Avg. no. of probes = 1.73

--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
Twin prime 95791 found
Using Linear Probing
HashtableExperiment: size of hash table is 76633
Inserted 76634 elements, of which 1 were duplicates
Avg. no. of probes = 3.01


Using Double Hashing
HashtableExperiment: size of hash table is 76633
Inserted 76634 elements, of which 1 were duplicates
Avg. no. of probes = 2.01

--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
Twin prime 95791 found
Using Linear Probing
HashtableExperiment: size of hash table is 86212
Inserted 86213 elements, of which 1 were duplicates
Avg. no. of probes = 5.49


Using Double Hashing
HashtableExperiment: size of hash table is 86212
Inserted 86213 elements, of which 1 were duplicates
Avg. no. of probes = 2.56

--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
Twin prime 95791 found
Using Linear Probing
HashtableExperiment: size of hash table is 91002
Inserted 91003 elements, of which 1 were duplicates
Avg. no. of probes = 10.40


Using Double Hashing
HashtableExperiment: size of hash table is 91002
Inserted 91003 elements, of which 1 were duplicates
Avg. no. of probes = 3.13

--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
Twin prime 95791 found
Using Linear Probing
HashtableExperiment: size of hash table is 94834
Inserted 94835 elements, of which 1 were duplicates
Avg. no. of probes = 70.26


Using Double Hashing
HashtableExperiment: size of hash table is 94834
Inserted 94835 elements, of which 1 were duplicates
Avg. no. of probes = 4.63

--------------------------------------------------------------------------------

### Dates:

--------------------------------------------------------------------------------
Twin prime 95791 found
Using Linear Probing
HashtableExperiment: size of hash table is 47896
Inserted 47896 elements, of which 0 were duplicates
Avg. no. of probes = 1.49


Using Double Hashing
HashtableExperiment: size of hash table is 47896
Inserted 47896 elements, of which 0 were duplicates
Avg. no. of probes = 1.55

--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
Twin prime 95791 found
Using Linear Probing
HashtableExperiment: size of hash table is 57475
Inserted 57475 elements, of which 0 were duplicates
Avg. no. of probes = 1.55


Using Double Hashing
HashtableExperiment: size of hash table is 57475
Inserted 57475 elements, of which 0 were duplicates
Avg. no. of probes = 1.68

--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
Twin prime 95791 found
Using Linear Probing
HashtableExperiment: size of hash table is 67054
Inserted 67054 elements, of which 0 were duplicates
Avg. no. of probes = 1.60


Using Double Hashing
HashtableExperiment: size of hash table is 67054
Inserted 67054 elements, of which 0 were duplicates
Avg. no. of probes = 1.86

--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
Twin prime 95791 found
Using Linear Probing
HashtableExperiment: size of hash table is 76633
Inserted 76633 elements, of which 0 were duplicates
Avg. no. of probes = 1.80


Using Double Hashing
HashtableExperiment: size of hash table is 76633
Inserted 76633 elements, of which 0 were duplicates
Avg. no. of probes = 2.23

--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
Twin prime 95791 found
Using Linear Probing
HashtableExperiment: size of hash table is 86212
Inserted 86212 elements, of which 0 were duplicates
Avg. no. of probes = 2.33


Using Double Hashing
HashtableExperiment: size of hash table is 86212
Inserted 86212 elements, of which 0 were duplicates
Avg. no. of probes = 2.91

--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
Twin prime 95791 found
Using Linear Probing
HashtableExperiment: size of hash table is 91002
Inserted 91002 elements, of which 0 were duplicates
Avg. no. of probes = 2.85


Using Double Hashing
HashtableExperiment: size of hash table is 91002
Inserted 91002 elements, of which 0 were duplicates
Avg. no. of probes = 3.58

--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
Twin prime 95791 found
Using Linear Probing
HashtableExperiment: size of hash table is 94834
Inserted 94834 elements, of which 0 were duplicates
Avg. no. of probes = 3.98


Using Double Hashing
HashtableExperiment: size of hash table is 94834
Inserted 94834 elements, of which 0 were duplicates
Avg. no. of probes = 5.19

--------------------------------------------------------------------------------

### Word List:

--------------------------------------------------------------------------------
Twin prime 95791 found
Using Linear Probing
HashtableExperiment: size of hash table is 47896
Inserted 1305930 elements, of which 1258034 were duplicates
Avg. no. of probes = 1.60


Using Double Hashing
HashtableExperiment: size of hash table is 47896
Inserted 1305930 elements, of which 1258034 were duplicates
Avg. no. of probes = 1.39

--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
Twin prime 95791 found
Using Linear Probing
HashtableExperiment: size of hash table is 57475
Inserted 1587659 elements, of which 1530184 were duplicates
Avg. no. of probes = 2.15


Using Double Hashing
HashtableExperiment: size of hash table is 57475
Inserted 1587659 elements, of which 1530184 were duplicates
Avg. no. of probes = 1.53

--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
Twin prime 95791 found
Using Linear Probing
HashtableExperiment: size of hash table is 67054
Inserted 1869206 elements, of which 1802152 were duplicates
Avg. no. of probes = 3.60


Using Double Hashing
HashtableExperiment: size of hash table is 67054
Inserted 1869206 elements, of which 1802152 were duplicates
Avg. no. of probes = 1.72

--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
Twin prime 95791 found
Using Linear Probing
HashtableExperiment: size of hash table is 76633
Inserted 2147748 elements, of which 2071115 were duplicates
Avg. no. of probes = 6.71


Using Double Hashing
HashtableExperiment: size of hash table is 76633
Inserted 2147748 elements, of which 2071115 were duplicates
Avg. no. of probes = 2.02

--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
Twin prime 95791 found
Using Linear Probing
HashtableExperiment: size of hash table is 86212
Inserted 2840050 elements, of which 2753838 were duplicates
Avg. no. of probes = 19.81


Using Double Hashing
HashtableExperiment: size of hash table is 86212
Inserted 2840050 elements, of which 2753838 were duplicates
Avg. no. of probes = 2.57

--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
Twin prime 95791 found
Using Linear Probing
HashtableExperiment: size of hash table is 91002
Inserted 3013622 elements, of which 2922620 were duplicates
Avg. no. of probes = 110.59


Using Double Hashing
HashtableExperiment: size of hash table is 91002
Inserted 3013622 elements, of which 2922620 were duplicates
Avg. no. of probes = 3.19

--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
Twin prime 95791 found
Using Linear Probing
HashtableExperiment: size of hash table is 94834
Inserted 3024134 elements, of which 2929300 were duplicates
Avg. no. of probes = 471.67


Using Double Hashing
HashtableExperiment: size of hash table is 94834
Inserted 3024134 elements, of which 2929300 were duplicates
Avg. no. of probes = 4.70

--------------------------------------------------------------------------------



## Sources used

https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html \
I had completely forgotten how to use a buffered reader, and so I had to go
through the Java documentation to get mine working. 


