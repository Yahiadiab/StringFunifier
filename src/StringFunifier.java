import java.util.Arrays;

public class StringFunifier {

    private String boringString;
    private int[] startIndexes;
    private int[] endIndexes;
    private String[] operations;

    public StringFunifier(String boringString, int[] startIndexes, int[] endIndexes, String[] operations) {
        this.boringString = boringString;
        this.startIndexes = startIndexes;
        this.endIndexes = endIndexes;
        this.operations = operations;
    }

    public String getFunnyString() {
        StringBuilder funnyString = new StringBuilder(boringString);

        for (int i = startIndexes.length - 1; i >= 0; i--) {
            int start = startIndexes[i];
            int end = endIndexes[i];
            String substring = funnyString.substring(start, end + 1);
            String modifiedSubstring = applyOperation(substring, operations[i]);
            funnyString.replace(start, end + 1, "(" + modifiedSubstring + ")");
        }

        return funnyString.toString();
    }

    public String applyOperation(String substring, String operation) {
        switch (operation) {
            case "REVERSE":
                return new StringBuilder(substring).reverse().toString();
            case "LOWERCASE":
                return substring.toLowerCase();
            case "UPPERCASE":
                return substring.toUpperCase();
            case "COMPRESSION":
                return compress(substring);
            case "SORT":
                return sort(substring); 
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }

    public String compress(String str) {
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(str.charAt(i - 1));
                if (count > 1) {
                    compressed.append(count);
                }
                count = 1;
            }
        }
        compressed.append(str.charAt(str.length() - 1));
        if (count > 1) {
            compressed.append(count);
        }
        return compressed.toString();
    }

    public String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
