

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length - 1;
        if(target >= letters[r]) return letters[0];
        int mid;
        while(l < r){
            mid = (l + r) / 2;
            if(letters[mid] <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return letters[l];
    }
}