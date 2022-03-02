import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Code written by William Ngo as data structure practice
 */

public class WordSearchOperations {
    private String[][] letters;
    private int gridSize;
    private int maxScore;
    private HashChainDictionary dict;
    private HashChainDictionary foundWords;

    public WordSearchOperations(String fileName, String wordTextFile)
            throws IOException, DictionaryException {
        dict = new HashChainDictionary(56130);
        String[] wordValuePair;
        BufferedReader inFile = new BufferedReader(new FileReader(wordTextFile));
        // Read every line into the word dictionary
        for (String line = inFile.readLine(); line != null; line = inFile.readLine()) {
            wordValuePair = line.split(",");
            dict.put(new Word(wordValuePair[0], Integer.parseInt(wordValuePair[1])));
        }
        inFile.close();

        // This file contains all game info ->Grid size, rows, etc.
        BufferedReader inFileTwo = new BufferedReader(new FileReader(fileName));
        // now read the first line for size, then read the letters into the grid, STORED AS STRING
        gridSize = Integer.parseInt(inFileTwo.readLine());
        letters = new String[gridSize][gridSize];

        String line;
        for (int i = 0; i < gridSize; i++) {
            line = inFileTwo.readLine();
            for (int j = 0; j < gridSize; j++) {
                letters[i][j] = Character.toString(line.charAt(j));
            }
            // Read gridSize number of lines into the letter array
            // Then in the next for loop, read the remaining lines into something
            // Then consult the word dictionary to get maxScore value
        }

        ArrayList gameWords = new ArrayList<String>();
        while ((line = inFileTwo.readLine()) != null) {
            maxScore += dict.get(line).getValue();
        }
        inFileTwo.close();

        foundWords = new HashChainDictionary(83);
    }
    public int getNumWordsFound() {
        return this.foundWords.size();
    }

    public int getSize() {
        return this.gridSize;
    }

    public int getMaxScore() {
        return this.maxScore;
    }

    public String getLetter(int i, int j) {
        return this.letters[i][j];
    }

    public ArrayList<Word> checkWords(String string) {
        // double for loop over the string and check substrings against the dictionary?
        ArrayList<Word> validWords = new ArrayList<Word>();
        String potentialWord;
        Word wordObject;
        // Get all substrings of length 4 or greater
        for (int i = 0; i < string.length(); i++) {
            for (int j = i + 4; j <= string.length(); j++) {
                potentialWord = string.substring(i, j);
                // If word exists in the dictionary, add it to the word list
                wordObject = dict.get(potentialWord);
                if (wordObject != null) {
                    validWords.add(wordObject);
                }
            }
        }
        return validWords;
    }

    public ArrayList<Word> findWords(String line) {
        ArrayList<Word> allWords = new ArrayList<Word>();
        ArrayList<Word> lineWords;
        String[] letterGlobs = line.split("\\s+");
        for (String glob: letterGlobs) {
            lineWords = checkWords(glob);
            allWords.addAll(lineWords);
            lineWords.clear();
        }
        return allWords;
    }

    public ArrayList<Word> updateWordList(ArrayList<Word> words) throws DictionaryException {
        ArrayList<Word> addedWords = new ArrayList<Word>();
        for (Word aWord: words) {
            if (dict.get(aWord.getKey()) != null) {
                foundWords.put(aWord);
                addedWords.add(aWord);
            }
        }
        return addedWords;
    }
}
