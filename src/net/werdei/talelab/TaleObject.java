package net.werdei.talelab;

import java.util.Random;

public abstract class TaleObject {

    public static Random random; //TODO

    static
    {
        random = new Random();
    }

    private String name;
    private String[] nicknames;
    private Place location;

    public TaleObject(String Name, Place Location, String... Nicknames)
    {
        name = Name;
        nicknames = Nicknames;

        location = Location;
        Location.letIn(this);
    }

    public abstract void reactToEvent(TaleEvent event);

    protected void moveTo(Place newLocation)
    {
        if (location != null)
            location.letOut(this);
        newLocation.letIn(this);
    }

    public String getName()
    {
        return name;
    }

    public String getNickname()
    {
        if(nicknames.length != 0)
        {
            int name = random.nextInt(nicknames.length);
            return nicknames[name];
        }
        else
            return name;
    }

    public Place getLocation()
    {
        return location;
    }

    @Override
    public String toString() {
        // Combine a name and a list of nicknames and pick one of them at random
        String[] names = new String[nicknames.length + 1];
        names[0] = name;
        for (int i = 0; i < nicknames.length; i++) {
            names[i + 1] = nicknames[i];
        }

        return names[random.nextInt(names.length)];
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}