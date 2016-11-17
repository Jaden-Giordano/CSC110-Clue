package edu.neumont.teamgift.clue.cards;

@SuppressWarnings("WeakerAccess")
public class Card {
    private String name;
    private Type type;

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        name = Name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type newType) {
        type = newType;
    }
}
