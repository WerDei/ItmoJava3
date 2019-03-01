package net.werdei.talelab;

public interface Place {

    static void CreateEvent(TaleEvent event, Place location)
    {
        switch (event)
        {
            case Wind:
                System.out.println("Подул лёгкий ветерок");
                break;
            case Magic:
                System.out.println("Что-то необычное произошло...");
                break;
            case Sound:
                System.out.println("Раздался странный звук");
                break;
            case LoudSound:
                System.out.println("Раздался громкий, свистящий звук");
                break;
        }
        location.executeEvent(event);
    }

    boolean letIn(TaleObject o);
    boolean letOut(TaleObject o);
    void executeEvent(TaleEvent event);
}
