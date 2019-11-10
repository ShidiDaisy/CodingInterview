package String;
/*Given a string, find the first non-repeating character in it. For example, if the input string is “GeeksforGeeks”,
then output should be ‘f’ and if input string is “GeeksQuiz”, then output should be ‘G’.*/
public class FirstNonRepeating {
    static char count[] = new char[256];

    public static void main (String[] args)
    {
        String str = "geeksforgeeks";
        int index =  firstNonRepeating(str);

        System.out.println(index == -1 ? "Either all characters are repeating or string " +
                "is empty" : "First non-repeating character is " +  str.charAt(index));
    }

    static int firstNonRepeating(String str){
        int index = -1;
        getCharCountArray(str);

        for(int i=0; i<str.length(); i++){
            if(count[str.charAt(i)] == 1){
                index = i;
                break;
            }
        }
        return index;
    }

    static void getCharCountArray(String str){
        for(int i=0; i<str.length(); i++){
            count[str.charAt(i)]++;
        }
    }
}
