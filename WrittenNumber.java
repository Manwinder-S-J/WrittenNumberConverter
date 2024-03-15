// Class to convert a numeric value into its written English counterpart
public class WrittenNumber {
    // Numeric value to be converted
    private int number;
    
    // Arrays holding the string representations for ones, teens, tens, and large numbers
    private String[] ones = {"", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine "};
    private String[] teens = {"ten ", "eleven ", "twelve ", "thirteen ", "fourteen ", "fifteen ", "sixteen ", "seventeen", "eighteen ", "nineteen "};
    private String[] tens = {"", "", "twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ", "ninety "};
    private String[] large = {"", " thousand "};

    // Constructor initializes the number to 0
    public WrittenNumber() {
        number = 0;
    }

    // Setter for the number field
    public void setNumber(int num) {
        number = num;
    }

    // Getter for the number field
    public int getNumber() {
        return number;
    }

    // Converts the entire number to its string representation
    public String convertToString() {
        // Handle the special case of 0 directly
        if (number == 0) {
            return "zero";
        }

        String writtenNum = "";
        int count = 0;
        int num = number;

        // Break the number into chunks of 3 digits and convert each chunk
        while (num > 0) {
            writtenNum = converter(num % 1000) + large[count] + writtenNum;
            num /= 1000;
            count++;
        }

        return writtenNum.trim();
    }

    // Converts a 3-digit number chunk to its string representation
    private String converter(int num) {
        String writtenBlock = "";

        // Process hundreds place
        if (num >= 100) {
            writtenBlock = ones[num / 100] + "hundred ";
            num %= 100;
        }

        // Process tens and ones place
        if (num >= 10 && num <= 19) {
            writtenBlock += teens[num - 10];
        } else {
            writtenBlock += tens[num / 10];
            num %= 10;
        }

        // Process ones place
        if (num >= 1 && num <= 9) {
            writtenBlock += ones[num];
        }

        return writtenBlock;
    }
}
