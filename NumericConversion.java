import java.util.Scanner;
public class NumericConversion
{
    public static void main(String[] args)
    {
        int menu;
        boolean running = true;  //calculator will continue to run while true
        String stringConversion = "";  //will hold the string that is wanted to be converted
        char charConversion[];  // will be used to look at individual characters within stringConversion
        Scanner scn = new Scanner(System.in);

        while(running == true)
        {
            System.out.print("Decoding Menu\n" + "-------------\n" + "1. Decode hexadecimal\n" + "2. Decode binary\n" + "3. Convert binary to hexadecimal\n" + "4. Quit\n\nPlease enter an option: ");
            menu = scn.nextInt();
            if (menu != 4) //to prevent this from being run when the user wants to exit
            {
                System.out.print("Please enter the numeric string to convert: ");
                stringConversion = scn.next();
                stringConversion = stringConversion.toLowerCase();
            }
            switch (menu)
            {
                case 1: //Will convert a string of a hex value into a decimal value
                    if(stringConversion.length() == 1 ) // will check if the string only contains one character
                    {
                        charConversion = stringConversion.toCharArray();
                        System.out.println("Result: " + hexCharDecode(charConversion[0]));
                    }
                    else
                    {
                        System.out.println("Result: " + hexStringDecode(stringConversion));
                    }
                    break;
                case 2:
                    System.out.println("Result: " + binaryStringDecode(stringConversion));
                    break;
                case 3:
                    System.out.println("Result: " + binaryToHex(stringConversion));
                    break;
                case 4:
                    System.out.print("Goodbye!");
                    running = false;
                    break;
            }
        }

    }

    public static long hexStringDecode(String hex) //will convert hex into decimal
    {
        String hexFinal;
        long value = 0;
        long totalValue = 0;
        hexFinal = hex.toLowerCase().trim();
        if (hexFinal.charAt(0) == '0' && hexFinal.charAt(1) == 'x')
        {
            hexFinal = hexFinal.substring(2);
        }
       for(int i = hexFinal.length(); i > 0; i--)
       {
           if (Character.getNumericValue(hexFinal.charAt(i-1)) <= 9 && Character.getNumericValue(hexFinal.charAt(i-1)) >= 0)
           {
               value = Double.valueOf(Character.getNumericValue(hexFinal.charAt(i-1)) * Math.pow(16, (hexFinal.length() - i))).longValue();
           }

            else
                switch (hexFinal.charAt(i-1)){
                    case('a'):value = Double.valueOf(10* Math.pow(16,(hexFinal.length()- i))).longValue();
                        break;
                    case('b'):value = Double.valueOf(11* Math.pow(16,(hexFinal.length()- i))).longValue();
                        break;
                    case('c'):value = Double.valueOf(12* Math.pow(16,(hexFinal.length()- i))).longValue();
                        break;
                    case('d'):value = Double.valueOf(13* Math.pow(16,(hexFinal.length()- i))).longValue();
                        break;
                    case('e'):value = Double.valueOf(14* Math.pow(16,(hexFinal.length()- i))).longValue();
                        break;
                    case('f'):value = Double.valueOf(15* Math.pow(16,(hexFinal.length()- i))).longValue();
                        break;
                }
                totalValue = totalValue + Double.valueOf(value).longValue();
        }
        return Double.valueOf(totalValue).longValue();
    }

    public static short hexCharDecode(char digit) // will convert a single hex character into dicimal
    {
        short value = 0;
         if (Character.getNumericValue(digit) <= 9 && Character.getNumericValue(digit) >= 0)
           {
               value = (short)Character.getNumericValue(digit);
           }
            else
                switch (digit){
                    case('a'):value = 10;
                        break;
                    case('b'):value = 11;
                        break;
                    case('c'):value = 12;
                        break;
                    case('d'):value = 13;
                        break;
                    case('e'):value = 14;
                        break;
                    case('f'):value = 15;
                        break;
                    case('A'):value = 10;
                        break;
                    case('B'):value = 11;
                        break;
                    case('C'):value = 12;
                        break;
                    case('D'):value = 13;
                        break;
                    case('E'):value = 14;
                        break;
                    case('F'):value = 15;
                        break;
                }
        return value;
    }

    public static short binaryStringDecode(String binary) //will convert binary to decimal
    {
        String binaryFinal;
        short value = 0;
        short totalValue = 0;
        binaryFinal = binary.toLowerCase().trim();
        if (binaryFinal.startsWith("0b"))
        {
            binaryFinal = binaryFinal.substring(2);
        }
        for(int i = binaryFinal.length(); i > 0; i--)
        {
            if (Character.getNumericValue(binaryFinal.charAt(i-1)) <= 1 && Character.getNumericValue(binaryFinal.charAt(i-1)) >= 0)
            {
                value = (short)(Character.getNumericValue(binaryFinal.charAt(i-1)) * Math.pow(2, (binaryFinal.length() - i)));
            }
           totalValue += value;
        }

        return totalValue;
    }

    public static String binaryToHex (String binary) // will convert binary to heximal
    {
        String binaryFinal = binary.toLowerCase().trim();
        if (binaryFinal.startsWith("0b"))
        {
            binaryFinal = binaryFinal.substring(2);
        }
        int decimal = binaryStringDecode(binaryFinal); // calls a previous method to turn binary to decimal

        int rem;

        String result = "";

        // Digits in hexadecimal number system
        char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        while(decimal > 0)
        {
            rem= decimal % 16;
            result = hex[rem] + result;
            decimal = decimal / 16;
        }
        return result;

    }
}
