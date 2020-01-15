package at.patrick.petzmann.verleihplattform.Klassen.Other;

public class ArrayExt {

    public static int[] add(int[] array, int newValue)
    {
        int[] rArray = new int[array.length+1];

        for (int i = 0; i < array.length ; i++) {
            rArray[i] = array[i];
        }
        rArray[rArray.length-1] = newValue;

        return rArray;
    }

    public static String[] add(String[] array, String newValue)
    {

        String[] rArray = new String[array.length+1];

        for (int i = 0; i < array.length ; i++) {
            rArray[i] = array[i];
        }
        rArray[rArray.length-1] = newValue;

        return rArray;
    }
}
