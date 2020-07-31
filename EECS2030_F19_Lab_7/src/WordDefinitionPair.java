
public class WordDefinitionPair {
	private String word;
	private String definition;

	public WordDefinitionPair(String s, String def) {
		this.word = s;
		this.definition = def;
	}

	public String getWord() {
		return this.word;
	}

	public String getDefinition() {
		return this.definition;
	}

	public void setWord(String s) {
		this.word = s;
	}

	public void setDefinition(String d) {
		this.definition = d;
	}

	@Override
	public String toString() {
		return "Word: " + this.word + "| Definition: " + this.definition;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		WordDefinitionPair other = (WordDefinitionPair) obj;

		return this.word == other.word && this.definition == other.definition;
	}

}
