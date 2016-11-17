package edu.neumont.teamgift.clue.cards;

import java.util.ArrayList;
import java.util.Random;

public class Dealer {
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Card> killerCaseFile = new ArrayList<>();

    public void createCards() {
        String[] weapons = {"Rope", "Lead Pipe", "Knife", "Wrench", "Candlestick", "Pistol"};
        String[] people = {"Colonel Mustard", "Miss Scarlet", "Professor Plum", "Mr. Green", "Mrs. White",
                "Mrs. Peacock"};
        String[] rooms = {"Ballroom", "Kitchen", "Dining Room", "Lounge", "Hall", "Study", "Library", "Billiard Room",
                "Conservatory"};
        final int TOTAL = weapons.length + people.length + rooms.length;

        for (int i = 0; i < TOTAL; i++) {
            if (i < weapons.length) {
                Card c = new Card();
                c.setName(weapons[i]);
                c.setType(Type.Weapon);
                cards.add(c);
            } else if (i < weapons.length + people.length) {
                Card c = new Card();
                c.setName(people[i - weapons.length]);
                c.setType(Type.Player);
                cards.add(c);
            } else {
                Card c = new Card();
                c.setName(rooms[i - weapons.length - people.length]);
                c.setType(Type.Room);
                cards.add(c);
            }
        }
    }

    public void shuffle() {
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            int randomIndex = r.nextInt(cards.size());
            int randomIndex2 = r.nextInt(cards.size());
            Card savedOffCard = cards.get(randomIndex);
            cards.set(randomIndex, cards.get(randomIndex2));
            cards.set(randomIndex2, savedOffCard);
        }

    }

    public void printCards() {
        for (int i = 0; i < cards.size(); i++) {
            System.out.println(i + ". " + cards.get(i).getName() + " Type: " + cards.get(i).getType());
        }
    }

    public void printKillerCaseFile() {
        for (int i = 0; i < killerCaseFile.size(); i++) {
            System.out.println(i + ". " + killerCaseFile.get(i).getName() + " Type: " + killerCaseFile.get(i).getType());
        }
    }

    public void setKiller() {
        boolean weaponPicked = false;
        boolean roomPicked = false;
        boolean personPicked = false;
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getType() == Type.Weapon && !weaponPicked) {
                killerCaseFile.add(cards.get(i));
                cards.remove(i);
                weaponPicked = true;
            }
            if (cards.get(i).getType() == Type.Player && !personPicked) {
                killerCaseFile.add(cards.get(i));
                cards.remove(i);
                personPicked = true;
            }
            if (cards.get(i).getType() == Type.Room && !roomPicked) {
                killerCaseFile.add(cards.get(i));
                cards.remove(i);
                roomPicked = true;
            }

        }
    }

}
