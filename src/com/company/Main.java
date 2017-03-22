package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {

        Scanner inputS = new Scanner(System.in);
        Scanner inputI = new Scanner(System.in);
        ArrayList extraNames = new ArrayList();
        ArrayList extraAmounts = new ArrayList();
        ArrayList facesar = new ArrayList();

        System.out.println("How many of each suit?");
        int suitAmount = inputI.nextInt();
        System.out.println("How many different suits?");
        int suitN = inputI.nextInt();
        System.out.println("Names of each suit? (Separate by spaces)");
        String suitNames = inputS.nextLine();
        String[] suitNamesar = suitNames.split(" ");
        System.out.println("Lowest card and highest card(non face card)?");
        int low= inputS.nextInt();
        int high = inputI.nextInt();
        System.out.println("Standard face? Ace, Jack, King and Queen? (yes or no)");
        String face = inputS.nextLine();
        if(face.equalsIgnoreCase("yes"))
        {
            String [] faces = {"Ace", "Jack", "King", "Queen"};
            for(int i = 0; i<faces.length; i++)
            {
                facesar.add(faces[i]);
            }
        }
        else
        {
            System.out.println("Names of each face? (Separate by spaces)");
            String faceNames = inputS.nextLine();
            String[] faces = faceNames.split(" ");
        }
        System.out.println("Extra cards and amount? (Enter " + '"' + "none" + '"' + " if there are none)");
        String extra = inputS.next();
        if(extra.equalsIgnoreCase("none"))
        {
            extraNames.add("No extra cards");
        }
        else
        {
            int extraAmount = inputI.nextInt();
            extraNames.add(extra);
            extraAmounts.add(extraAmount);
            boolean more = true;
            while(more)
            {
                System.out.println("Extra cards and amount? (Enter " + '"' + "none" + '"' + " if there are none)");
                String extra2 = inputS.next();
                if(extra2.equalsIgnoreCase("none"))
                {
                    more = false;
                }
                else
                {
                    int extraAmount2 = inputI.nextInt();
                    extraNames.add(extra2);
                    extraAmounts.add(extraAmount2);
                }
            }
        }
        String[]ranks = new String[high-low+1+facesar.size()];
        for(int x = 0; x<ranks.length; x++)
        {
            for(int i = low; i<=high; i++)
            {
                ranks[x] = Integer.toString(i);
                break;
            }
        }
        //add face ranks
        Deck dobj = new Deck(ranks, )

    }
}
