/*
 * You are required to use the given `dict` array to implement the methods.
 * See test_one_array_implementation_insert and test_one_array_implementation_remove 
 * in class TestArrayImplementations.
 *
 * Requirements:
 * 		- You are not allowed to add new attributes to this class.
 * 		- You are not allowed to use any Java collection library (no import statements).
 * 
 * The idea is that `dict` is initialized as an array of size `MAX_CAPACITY` with each slot storing null.
 * Entries are added from left to right, whereas all free slots remain null.
 * When an entry is removed, all slots to its right are shifted to the left to close the gap.
 * 
 * For example, given a dictionary with four entries:
 * {(w1, d1), (w2, d2), (w3, d3), (w4, d4), null, null, ...} 
 * Removing the entry for word `w2` has the resulting dictionary:
 * {(w1, d1), (w3, d3), (w4, d4), null, null, null, ...}
 * 
 * You may consider studying this note on manipulating basic array:
 * https://www.eecs.yorku.ca/~jackie/teaching/lectures/2019/F/EECS2030/notes/EECS2030_F19_Notes_Tracing_PointCollectorTester.pdf
 */

public class OneArrayDictionary implements Dictionary {

	int MAX_CAPACITY = 100;
	int count = 0;
	WordDefinitionPair[] dict;

	/*
	 * Your tasks: declare and implement methods from the Dictionary interface.
	 */

	public OneArrayDictionary() {
		this.dict = new WordDefinitionPair[MAX_CAPACITY];
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
			if (this.dict[i].getWord().equals(word)) {
				return this.dict[i].getDefinition();
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
			if (this.dict[i].getWord().equals(word)) {
				throw new WordAlreadyExistsInDictionaryException("Word Already Exists In Dictionary Exception");
			}
		}
		this.dict[this.count] = new WordDefinitionPair(word, definition);
		this.count++;
	}

	public String removeWord(String word) throws WordNotInDictionaryException {
		for (int i = 0; i < this.count; i++) {
			if (this.dict[i].getWord().equals(word)) {
				String temp = this.dict[i].getDefinition();
				for (int j = i; j < MAX_CAPACITY - 1; j++) {
					this.dict[j] = this.dict[j + 1];
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
			temp[i] = this.dict[i].getWord();
		}
		return temp;
	}

	public String[] getDefinitions() {
		String[] temp = new String[this.count];
		for (int i = 0; i < this.count; i++) {
			temp[i] = this.dict[i].getDefinition();
		}
		return temp;
	}

	public WordDefinitionPair[] getEntries() {
		WordDefinitionPair[] dict2 = new WordDefinitionPair[this.count];
		for (int i = 0; i < this.count; i++) {
			dict2[i] = new WordDefinitionPair(this.dict[i].getWord(), this.dict[i].getDefinition());
		}
		return dict2;
	}

}
