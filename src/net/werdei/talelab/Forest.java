package net.werdei.talelab;

import java.util.ArrayList;

public class Forest extends TaleObject implements Place {

    private float size;
    private ArrayList<TaleObject> taleObjects;

    public Forest(String Name, Place Location, float Size, String... Nicknames)
    {
        super(Name, Location, Nicknames);

        taleObjects = new ArrayList<>();

        size = Size;
    }


    public float getSize()
    {
        return size;
    }

    public Leaves growLeaves()
    {
        return new Leaves("Листья", this, "Листва", "Зелёное море");
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

    @Override
    public int hashCode() {
        return super.hashCode() ^ taleObjects.hashCode() ^ Float.floatToIntBits(size);
    }

    public static class Leaves extends TaleObject{

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
}
