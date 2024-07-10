public class StringFunifier {

    String boringString;
    int[] startIndexes;
    int[] endIndexes;



    public StringFunifier(String boringString, int[] startIndexes, int[] endIndexes) {
        this.boringString = boringString;
        this.startIndexes = startIndexes;
        this.endIndexes = endIndexes;
    }

    public String getFunnyString() {
        StringBuilder funnyString = new StringBuilder(boringString);

        // Adjust ranges in reverse order to prevent indexing issues
        for (int i = startIndexes.length - 1; i >= 0; i--) {
            int start = startIndexes[i];
            int end = endIndexes[i];
            String substring = funnyString.substring(start, end + 1);
            String reversedSubstring = new StringBuilder(substring).reverse().toString();
            funnyString.replace(start, end + 1, "(" + reversedSubstring + ")");
        }

        return funnyString.toString();
    }
}
