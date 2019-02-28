package net.werdei.talelab;

public class Leaves extends TaleObject{

    public Leaves(String Name, Place Location, String... Nicknames)
    {
        super(Name, Location, Nicknames);
    }

    void tremble()
    {
        System.out.println(this.toString() + " трепещет");
    }

    @Override
    public void reactToEvent(TaleEvent event) {
        if(event == TaleEvent.Wind)
            tremble();
    }
}
