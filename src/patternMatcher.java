import java.util.ArrayList;

public class patternMatcher {

    public static String[] patternMatcher(String word, String pattern, String playaLetters) {
        return new String[]{String.valueOf(doesStringMatchPattern(word, pattern)), usedLettersFromPattern(word, pattern)};
    }

    public static String usedLettersFromPattern(String matchedWord, String pattern) {
        StringBuilder out = new StringBuilder();

        

        return out.toString();
    }

    public static boolean doesStringMatchPattern(String word, String pattern){
        // Preliminary checks:
        if(pattern.isBlank()){ // If the pattern is blank, true is returned. Otherwise, if there's no pattern this method would always return false, blocking all words in the Algo.canWordBeUsed
            return true;
        }
        if (!checkedWordContainsAtLeastOneLetterFromPattern(word, pattern)){ // If the word doesn't contain any letters from the pattern, then the word cannot be used.
            return false;
        }
        if (pattern.length() < word.length()){ // If the word is longer than the pattern, it won't fit.
            return false;
        }

        // Actual pattern matching:
        if (pattern.length() == word.length()) {
            return doesCheckedWordMatchPatternOfSameLength(word, pattern);
        }
        else {
            return doesCheckedWordMatchPatternOfDifferentLength(word, pattern);
        }
    }

    public static boolean doesCheckedWordMatchPatternOfDifferentLength(String word, String pattern){
        // This function piggybacks of off doesCheckedWordMatchPatternOfSameLength.
        // It the pattern cut up into pieces that match the length of the word and checks one by one.

        ArrayList<String> AcceptableFragmentsOfPattern = AcceptableFragmentsOfPattern(word, pattern);

        for (String patternFragment : AcceptableFragmentsOfPattern) {
            if (doesCheckedWordMatchPatternOfSameLength(word, patternFragment)) {
                return true;
            }
        }

        return false;
    }

    public static ArrayList<String> AcceptableFragmentsOfPattern(String word, String pattern){
        // This method returns an ArrayList of Strings, which are word-sized fragments of the supplied pattern.
        // These fragments are used by the doesCheckedWordMatchPatternOfDifferentLength method to piggyback of off doesCheckedWordMatchPatternOfSameLength - that's why the chunks are word-sized.
        ArrayList<String> out = new ArrayList<>();

        for (int i = 0; i < pattern.length() - word.length()+1; i++) {
            String proposedFragment = pattern.substring(i, i+word.length());
            if (isJustUnderscores(proposedFragment)) {
                continue;
            }

            if (i == 0) {
//                char before = pattern.charAt(i-1);
                char after = pattern.charAt(i + word.length());
                if (!isLetter(after)) {
                    out.add(proposedFragment);
                }
                continue;
            }

            if (i == pattern.length() - word.length()) {
                char before = pattern.charAt(i-1);
//                char after = pattern.charAt(i + word.length());
                if (!isLetter(before)) {
                    out.add(proposedFragment);
                }
                continue;
            }

            char before = pattern.charAt(i-1);
            char after = pattern.charAt(i + word.length());
            if (!isLetter(before) && !isLetter(after)) {
                out.add(proposedFragment);
            }

        }

        return out;
    }



    public static boolean doesCheckedWordMatchPatternOfSameLength(String word, String pattern){
        for (int i = 0; i < word.length(); i++) {

            if (!(word.charAt(i) == pattern.charAt(i) || pattern.charAt(i) == '_')) {
                return false;
            }
        }

        return true;
    }

    public static boolean isJustUnderscores(String pattern){
        return pattern.matches("^_+$");
    }

    public static boolean isLetter(char letter) {
        return Character.isLetter(letter);
    }


    public static boolean checkedWordContainsAtLeastOneLetterFromPattern(String word, String pattern){
        char[] patternArray = extractLettersFromPattern(pattern).toCharArray();
        for (char c : patternArray) {
            if(word.contains(String.valueOf(c))){
                return true;
            }
        }

        return false;
    }

    public static String extractLettersFromPattern(String pattern){
        return pattern.replace("_", "");
    }
}
