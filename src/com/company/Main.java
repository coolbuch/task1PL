package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) throws Exception {
	    //task1();
        //task2();
        //task3();
        //task4();
        //task5();
        //task6();
        //task8();
        task9();
    }

    static void task1()
    {
        String s;
        String[] arr = new String[3];
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        s = s.replace(" ", "");
        char ch = '&';
        for(char c: s.toCharArray())
        {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                switch(c)
                {
                    case '+' : arr = s.split("\\+"); break;
                    case '-' : arr = s.split("\\-"); break;
                    case '*' : arr = s.split("\\*"); break;
                    case '/' : arr = s.split("\\/"); break;
                }
                ch = c;
                break;
            }
        }
        if (arr[0].contains(".") || arr[1].contains(".") || arr[0].contains(",") || arr[1].contains(","))
        {
            arr[0] = arr[0].replace(',', '.');
            arr[1] = arr[1].replace(',', '.');
            switch (ch)
            {
                case '+' : System.out.println("result: " + (Double.parseDouble(arr[0]) + Double.parseDouble(arr[1])));  break;
                case '-' : System.out.println("result: " + (Double.parseDouble(arr[0]) - Double.parseDouble(arr[1]))); break;
                case '*' : System.out.println("result: " + (Double.parseDouble(arr[0]) * Double.parseDouble(arr[1]))); break;
                case '/' : System.out.println("result: " + (Double.parseDouble(arr[0]) / Double.parseDouble(arr[1]))); break;
            }
        }
        else
        {
            switch (ch)
            {
                case '+' : System.out.println("result: " + (Integer.parseInt(arr[0]) + Integer.parseInt(arr[1])));  break;
                case '-' : System.out.println("result: " + (Integer.parseInt(arr[0]) - Integer.parseInt(arr[1]))); break;
                case '*' : System.out.println("result: " + (Integer.parseInt(arr[0]) * Integer.parseInt(arr[1]))); break;
                case '/' : System.out.println("result: " + (Integer.parseInt(arr[0]) / Integer.parseInt(arr[1]))); break;
            }
        }
    }

    static void task2()
    {
        int vowel = 0, nvowel = 0;
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toLowerCase();
        for (char c: s.toCharArray())
        {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y')
                vowel++;
            else
                nvowel++;
        }
        System.out.println("vowel: " + vowel + " " + "not vowel: " + nvowel);
    }

    static void task3() throws FileNotFoundException {
        int count = 0;
        String word = "", savedWord = "";
        Scanner sc = new Scanner(new File("words.txt"));
        while (sc.hasNextLine())
        {
            word = sc.nextLine();
            if (savedWord.length() <= word.length())
                savedWord = word;
        }
        System.out.println(savedWord); // >>> dichlorodiphenyltrichloroethane
    }

    static void task4()
    {
        Random r = new Random();
        double[] array = new double[10];
        for (int i = 0; i < 10; i ++)
        {
            array[i] = ThreadLocalRandom.current().nextDouble(-100d, 100d);
        }
        for (int i = 0; i < 10; i ++)
        {
            for (int j = i; j < 10; j ++)
            {
                double d = 0.0;
                if (Math.abs(array[j] % 1) <= Math.abs(array[i] % 1))
                {
                    d = array[j];
                    array[j] = array[i];
                    array[i] = d;
                }
            }

        }
        System.out.println(Arrays.toString(array));
    }

    static void task5() throws FileNotFoundException
    {
        HashMap<Character, Integer> map = new HashMap<>(26);
        Scanner sc = new Scanner(new File("lorem.txt"));
        while(sc.hasNextLine())
        {
            String s = sc.nextLine().toLowerCase();
            for (char c: s.toCharArray())
            {

                if (!map.containsKey(c))
                {
                    map.put(c, 1);
                }
                else
                    map.put(c, map.get(c) + 1);

            }
        }
        System.out.println(map.toString());
        //>>> { =1213, a=568, b=85, c=288, d=219, e=805, f=53, g=94, h=39, i=758, j=8,
        // l=341, ,=2, m=313, n=432, .=158, o=268, p=168, q=129, r=395, s=624, t=609, u=594, v=119}
    }

    static void task6()
    {
        String s1, s2;
        Scanner sc = new Scanner(System.in);
        s1 = sc.nextLine();
        s2 = sc.nextLine();
        double nC = 0, nA = s1.length(), nB = s2.length();
        for (int i = 0; i < s1.length(); i++)
        {
            if (s2.contains(Character.toString(s1.charAt(i))))
            {
                nC++;
            }
        }
        System.out.println(nC / (nA + nB - nC));
    }

    static void task8() throws Exception // не все функции реализованы
    {
        Byte b = new Byte("11110010", true);
        Byte a = new Byte("11001101", true);
        System.out.println(b.toString());
        System.out.println(b.getNumber());
        //Byte c = b.and(a);
        //System.out.println(c.toString());
        //System.out.println(c.getNumber());
        //b.setSingleByte(3, 1);
        //.setSingleByte(3, 0);
        //System.out.println(b.getNumber());

    }

    static void task9() throws FileNotFoundException
    {

        Scanner sc = new Scanner(new File("island.txt"));
        ArrayList<Integer> arr = new ArrayList<>();
        int waterBlocks = 0;
        int maxH = 0;
        while (sc.hasNextInt())
        {
            arr.add(sc.nextInt());
            if (maxH < arr.get(arr.size() - 1))
                maxH = arr.get(arr.size() - 1);
        }
        int w = arr.size(), h = maxH;
        int[][] matrix = new int[h][w];

        for (int i = 0; i < w; i++)
        {
            for (int j = 0; j < arr.get(i); j++)
            {
                matrix[j][i] = 1;
            }
        }


        int lastIndex = 0;
        for (int i = 0; i < h; i++)
        {
            lastIndex = Integer.MAX_VALUE;
            for (int j = 1; j < w - 1; j++)
            {

                if (matrix[i][j - 1] == 1 && matrix[i][j] == 0)
                {
                    lastIndex = j-1;
                }
                if (matrix[i][j] == 0 && matrix[i][j + 1] == 1)
                {
                    for (int k = lastIndex; k < j; k++)
                    {
                        matrix[i][k + 1] = 2;
                        waterBlocks++;
                    }
                }
            }
        }

        System.out.println();
        for (int i = h - 1; i >= 0; i--)
        {
            for (int j = 0; j < w; j++)
            {
                if (matrix[i][j] == 2)
                    System.out.print("~" + " ");
                else
                    System.out.print(Integer.toString(matrix[i][j]) + ' ');
            }
            System.out.println();
        }
        System.out.println("total water block found: " + waterBlocks);
    }


}


class Byte
{
    private String binary = "";
    private int number = 0;
    private boolean unsigned = false;
    Byte(int number,  boolean unsigned) throws Exception
    {
        if (number > 255 || number < -127)
            throw new Exception();
        else
        {
            this.unsigned = unsigned;
            this.number = number;
            toBinary(number);

        }

    }
    Byte(String bin, boolean unsigned) throws Exception
    {
        if (bin.length() > 8 || bin.length() == 0)
            throw new Exception();
        else
        {
            this.unsigned = unsigned;
            fromBinary(bin);
            this.binary = bin;

        }
    }

    void fromBinary(String bin) throws Exception
    {
        if (bin.length() > 8 || bin.length() == 0)
            throw new Exception();
        else
        {
            if (bin.length() < 8)
            {
                for (int i = 0; i < 8 - bin.length(); i++)
                    bin += "0";
                bin = new StringBuilder(bin).reverse().toString();
            }
            for (int i = 7; i >= 0; i--)
            {
                if (bin.charAt(i) == '1')
                    if (unsigned)
                        this.number += Math.pow(2, 7 - i);
                    else
                        this.number -= Math.pow(2, 6 - i);
            }
        }
    }

    void toBinary(int num) throws Exception
    {
        if (num > 255 || num < -127)
            throw new Exception();
        else
        {
            if (Integer.toString(num, 2).length() < 8)
                for (int i = 0; i < 8 - Integer.toString(num, 2).length(); i++)
                {
                    binary += "0";
                }
            binary += Integer.toString(num, 2);
            binary = binary.replace("-", "");
            unsigned = true;
            if (num < 0)
            {
                binary = new StringBuilder(binary).replace(0,0, "1").toString();
                unsigned = false;
            }
        }
    }

    int getSingleByte(int number) throws Exception
    {
        if (number < 0 || number > 7)
            throw new Exception();
        else
        {
            return Integer.parseInt((Character.toString(binary.charAt(number))));
        }
    }

    void setSingleByte(int number, int value) throws Exception
    {
        if (number < 0 || number > 7 || value > 1 || value < 0)
            throw new Exception();
        else
        {
            if (unsigned)
            {
                if (value == 1)
                    this.number += Math.pow(2, 7 - number);
                else
                    this.number -= Math.pow(2, 7 - number);
                binary = "";
                toBinary(this.number);
            }
            else
            {
                if (value == 1)
                    this.number += Math.pow(2, 6 - number);
                else
                    this.number -= Math.pow(2, 6 - number);
                binary = "";
                toBinary(this.number);
            }
        }
    }

    Byte or(Byte b) throws Exception {
        String s = "";
        for (int i = 0; i < 8; i++)
        {
            int num = Integer.parseInt(Character.toString(b.getBinaryPart().toCharArray()[i]))
                    | Integer.parseInt(Character.toString(this.getBinaryPart().toCharArray()[i]));
            s += num;
        }
        System.out.println(s);
        return new Byte(s, this.unsigned);
    }

    Byte and(Byte b) throws Exception
    {
        String s = "";
        for (int i = 0; i < 8; i++)
        {
            int num = Integer.parseInt(Character.toString(b.getBinaryPart().toCharArray()[i]))
                    & Integer.parseInt(Character.toString(this.getBinaryPart().toCharArray()[i]));
            s += num;
        }
        System.out.println(s);
        return new Byte(s, this.unsigned);
    }
    @Override
    public String toString()
    {
        return "0b" + binary;
    }

    String getBinaryPart()
    {
        return binary;
    }

    int getNumber()
    {
        return number;
    }

}