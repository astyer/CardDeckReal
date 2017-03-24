package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {

        Scanner inputS = new Scanner(System.in);
        Scanner inputI = new Scanner(System.in);
        ArrayList extraNames = new ArrayList();
        ArrayList extraAmounts = new ArrayList();
        ArrayList facesar = new ArrayList();
        int low = 2;
        int high = 1;

        System.out.println("How many of each suit?");
        int suitAmount = inputI.nextInt();

        System.out.println("Names of each suit? (Separate by spaces)");
        String suitNames = inputS.nextLine();
        String[] suitNamesar = suitNames.split(" ");

        while(low>high)
        {
            System.out.println("Lowest card and highest card (non face card)?");
            low= inputI.nextInt();
            high = inputI.nextInt();
            if(low>high)
            {
                System.out.println("Low must be less than high.");
            }
        }



        System.out.println("Standard face? Jack, Queen, King, and Ace? (yes or no)");
        String face = inputS.nextLine();
        if(face.equalsIgnoreCase("yes"))
        {
            String [] faces = {"Jack", "Queen", "King", "Ace"};
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
            for(int i = 0; i<faces.length; i++)
            {
                facesar.add(faces[i]);
            }
        }

        System.out.println("Extra cards and amount? (Enter " + '"' + "none" + '"' + " if there are none)");
        String extra = inputS.nextLine();
        if(extra.equalsIgnoreCase("none"))
        {
        }
        else
        {
            int extraAmount = inputI.nextInt();
            extraNames.add(extra);
            extraAmounts.add(extraAmount);
            while(true)
            {
                System.out.println("More extra cards and amount? (Enter " + '"' + "done" + '"' + " if there are no more)");
                String extra2 = inputS.nextLine();
                if(extra2.equalsIgnoreCase("done"))
                {
                    break;
                }
                else
                {
                    extraNames.add(extra2);
                    int extraAmount2 = inputI.nextInt();
                    extraAmounts.add(extraAmount2);
                }
            }
        }

        String[]ranks = new String[(high-low)+1+facesar.size()];
        int x = 0;
        int i = low;
        while(x<ranks.length-facesar.size())
        {
            ranks[x] = Integer.toString(i);
            x++;
            i++;
        }
        int count = high-low+1;
        for(int j = 0; j<facesar.size(); j++)
        {
            ranks[count] = (String)facesar.get(j);
            count++;
        }

        Deck theDeck = new Deck(ranks, suitNamesar, suitAmount);

        System.out.println("Your customized deck:");
        for(int k = 0; k<theDeck.cards.size(); k++)
        {
            Card dummy = (Card)theDeck.cards.get(k);
            System.out.println(dummy.printable());
        }

        if(extraAmounts.size()>0)
        {
            for(int p = 0; p<extraNames.size(); p++)
            {
                for(int d = 0; d<(int)extraAmounts.get(p); d++)
                {
                    System.out.println((String)extraNames.get(p));
                }
            }
        }

        System.out.println("");
        while(true)
        {
            System.out.println("Would you like to shuffle your deck?");
            String yn = inputS.nextLine();
            if(yn.equalsIgnoreCase("yes"))
            {
                theDeck.shuffle();
                System.out.println("Shuffled Deck:");
                for(int k = 0; k<theDeck.cards.size(); k++)
                {
                    Card dummy = (Card)theDeck.cards.get(k);
                    System.out.println(dummy.printable());
                }
                if(extraAmounts.size()>0)
                {
                    for(int p = 0; p<extraNames.size(); p++)
                    {
                        for(int d = 0; d<(int)extraAmounts.get(p); d++)
                        {
                            System.out.println((String)extraNames.get(p));
                        }
                    }
                }
                System.out.println("");
            }
            else
            {
                break;
            }
        }

    }
}