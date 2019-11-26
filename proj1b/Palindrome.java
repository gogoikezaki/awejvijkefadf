public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new ArrayDeque<>();
        for (char c : word.toCharArray()) {
            res.addLast(c);
        }
        return res;
    }
    public boolean isPalindrome(String word) {
        if (word.length() < 2) {
            return true;
        }
        if (word.charAt(0) == word.charAt(word.length()-1)) {
            return isPalindrome(word.substring(1,word.length()-1));
        } else {
            return false;
        }

    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() < 2) {
            return true;
        }
        if (cc.equalChars(word.charAt(0), word.charAt(word.length()-1))) {
            return isPalindrome(word.substring(1,word.length()-1));
        } else {
            return false;
        }

    }


}
