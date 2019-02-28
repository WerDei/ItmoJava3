package net.werdei.talelab;

import java.util.ArrayList;

public class Sky extends TaleObject implements Place {

    private int clouds;
    private ArrayList<TaleObject> taleObjects;

    public Sky(String Name, Place Location, int Clouds, String... Nicknames)
    {
        super(Name, Location, Nicknames);

        taleObjects = new ArrayList<>();

        clouds = Clouds;
    }


    public int getCouds()
    {
        return clouds;
    }


    @Override
    public void reactToEvent(TaleEvent event) {
        executeEvent(event);
    }


    @Override
    public boolean letIn(TaleObject o) {
        return taleObjects.add(o);
    }

    @Override
    public boolean letOut(TaleObject o) {
        return taleObjects.remove(o);
    }

    @Override
    public void executeEvent(TaleEvent event) {
        for (TaleObject tObject: taleObjects) {
            tObject.reactToEvent(event);
        }
    }
}
