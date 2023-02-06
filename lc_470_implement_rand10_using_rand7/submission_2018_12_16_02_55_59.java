

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int index;
        do{
           index = (rand7() - 1) * 7 + (rand7() - 1); 
        } while(index > 39);        
        return index % 10 + 1;
    }
}