/* Make sure the instructions document is read carefully.
 * 
 * You are required to use the given `words` and `definitions` arrays to implement the methods.
 * See test_two_array_implementation_insert and test_two_array_implementation_remove 
 * in class TestArrayImplementations.
 * 
 * Requirements:
 * 		- You are not allowed to add new attributes to this class.
 * 		- You are not allowed to use any Java collection library (no import statements).
 * 
 * The idea is that both `words` and `definitions` are initialized as arrays of size `MAX_CAPACITY` with each slot storing null.
 * Entries (words and definitions) are added from left to right, whereas all free slots remain null.
 * When an entry is removed, all slots to its right are shifted to the left to close the gap.
 * 
 * For example, given a dictionary with four entries:
 * words:       {w1, w2, w3, w4, null, null, ...}
 * definitions: {d1, d2, d3, d4, null, null, ...}
 * Removing the entry for word `w2` has the resulting dictionary:
 * words:       {w1, w3, w4, null, null, null, ...}
 * definitions: {d1, d3, d4, null, null, null, ...}
 * 
 * You may consider studying this note on manipulating basic array:
 * https://www.eecs.yorku.ca/~jackie/teaching/lectures/2019/F/EECS2030/notes/EECS2030_F19_Notes_Tracing_PointCollectorTester.pdf
 */

public class TwoArrayDictionary implements Dictionary {

	/*
	 * Use these attributes only to implement the methods.
	 */
	int MAX_CAPACITY = 100;
	int count = 0; // number of entries in dictionary

	String[] words;
	String[] definitions;

	/*
	 * Your tasks: declare and implement methods from the Dictionary interface.
	 */
	public TwoArrayDictionary() {
		this.words = new String[MAX_CAPACITY];
		this.definitions = new String[MAX_CAPACITY];
		this.count = 0;
	}

	public int size() {
		return this.count;
	}

	public boolean isEmpty() {
		if (this.count == 0) {
			return true;
		}
		return false;
	}

	public String getDefinition(String word) throws WordNotInDictionaryException {
		for (int i = 0; i < this.count; i++) {
			if (this.words[i].equals(word)) {
				return this.definitions[i];
			}
		}
		throw new WordNotInDictionaryException("Word Not In Dictionary Exception");
	}

	public void insertEntry(String word, String definition)
			throws WordAlreadyExistsInDictionaryException, DictionaryFullException {
		if (this.count == MAX_CAPACITY) {
			throw new DictionaryFullException("Dictionary Full Exception");
		}
		for (int i = 0; i < this.count; i++) {
			if (this.words[i].equals(word)) {
				throw new WordAlreadyExistsInDictionaryException("Word Already Exists In Dictionary Exception");
			}
		}
		this.words[this.count] = word;
		this.definitions[this.count] = definition;
		this.count++;
	}

	public String removeWord(String word) throws WordNotInDictionaryException {
		for (int i = 0; i < this.count; i++) {
			if (this.words[i].equals(word)) {
				String temp = this.definitions[i];
				for (int j = i; j < MAX_CAPACITY - 1; j++) {
					this.definitions[j] = this.definitions[j + 1];
					this.words[j] = this.words[j + 1];
				}
				this.count--;
				return temp;
			}
		}
		throw new WordNotInDictionaryException("Word Not In Dictionary Exception");
	}

	public String[] getWords() {
		String[] temp = new String[this.count];
		for (int i = 0; i < this.count; i++) {
			temp[i] = this.words[i];
		}
		return temp;
	}

	public String[] getDefinitions() {
		String[] temp = new String[this.count];
		for (int i = 0; i < this.count; i++) {
			temp[i] = this.definitions[i];
		}
		return temp;
	}

	public WordDefinitionPair[] getEntries() {
		WordDefinitionPair[] dict = new WordDefinitionPair[this.count];
		for (int i = 0; i < this.count; i++) {
			dict[i] = new WordDefinitionPair(this.words[i], this.definitions[i]);
		}
		return dict;
	}
}
