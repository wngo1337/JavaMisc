/**
 * Code written by William Ngo as linked list + hash table practice
 * My understanding is that we want to implement a dictionary of Nodes that contain Words and a Next node
 */

public class HashChainDictionary implements DictionaryADT {
    private Node[] hashTable;
    private int tableSize;
    private int numRecords;
    /**
     * 56130 words in the dictionary, want a prime num table size such that 56130/size is about 0.75
     * Maybe we choose a prime like... 74843 since ideal table size is 74840
     */
    public final int DICT_TABLE_SIZE = 74843;

    public HashChainDictionary(int size) {
        this.hashTable = new Node[size];
        this.tableSize = size;
        this.numRecords = 0;
    }

    private int myHashFunction(String word) {
        // Want to hash each character in the string and then mod by the table size
        int hashValue = 0;
        char[] chars = word.toCharArray();

        for (char someChar: chars) {
            hashValue = 37 * hashValue + Character.getNumericValue(someChar);
            hashValue = hashValue % this.tableSize;
        }
        // Overflow case: overflowed to negatives, so increment back into positive
        while (hashValue < 0) {
            hashValue = hashValue + this.tableSize;
        }
        return hashValue;
    }

    public int put(Word word) throws DictionaryException {
        Node newWordNode = new Node(word, null);
        int hashValue = myHashFunction(word.getKey());
        // Possibility of a dupe word
        if (hashTable[hashValue] != null) {
            Node currentNode = hashTable[hashValue];
            Node nextNode = currentNode.getNext();
            // check first node for duplicate word
            if (currentNode.getWord().getKey().equals(word.getKey())) {
                throw new DictionaryException(word.getKey());
            }
            // While there is a next node, point current to it and check it
            while (nextNode != null) {
                currentNode = nextNode;
                if (currentNode.getWord().getKey().equals(word.getKey())) {
                    throw new DictionaryException(word.getKey());
                }
                nextNode = nextNode.getNext();
            }
            // At this point, currentNode should be the last node in the list
            currentNode.setNext(newWordNode);
            numRecords++;
            return 1;
        }
        else {
            hashTable[hashValue] = newWordNode;
        }
        numRecords++;
        return 0;
    }

    public Word get(String inputWord) {
        // Just hash that shit and then get the correct linked list and check the words
        int hashValue = myHashFunction(inputWord);
        Node currentNode = hashTable[hashValue];
        while (currentNode != null) {
            if (currentNode.getWord().getKey().equals(inputWord)) {
                return currentNode.getWord();
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    public Word remove(String inputWord) throws NoKeyException {
        int hashValue = myHashFunction(inputWord);
        Node currentNode = hashTable[hashValue];
        Node prevNode = null;
        Word wantedWord = null;
        if (currentNode == null) {
            throw new NoKeyException(inputWord);
        }
        // Case 1: node to remove is at front of the list
        // Just point head to the next node
        if (currentNode.getWord().getKey().equals(inputWord)) {
            wantedWord = currentNode.getWord();
            currentNode = currentNode.getNext();
            numRecords--;
            return wantedWord;
        }
        else {
            prevNode = currentNode;
            currentNode = currentNode.getNext();
            while (currentNode != null) {
                if (currentNode.getWord().getKey().equals(inputWord)) {
                    if (currentNode.getNext() != null) {
                        prevNode.setNext(currentNode.getNext());
                    }
                    // Current node is the last node, so just make it null
                    else {
                        // Won't have reference to currentNode after, so need to assign it
                        wantedWord = currentNode.getWord();
                        currentNode = null;
                    }
                    numRecords--;
                    return wantedWord;
                }
            }
        }
        throw new NoKeyException(inputWord);
    }

    public int size() {
        return this.numRecords;
    }
}