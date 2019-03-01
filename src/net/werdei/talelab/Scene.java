package net.werdei.talelab;

import java.util.ArrayList;

public class Scene implements Place {

    private ArrayList<TaleObject> taleObjects;

    public Scene()
    {
        taleObjects = new ArrayList<>();
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
    public String toString() {
        return "Эпизодическая Сцена";
    }

    @Override
    public int hashCode() {
        return taleObjects.hashCode();
    }
}
