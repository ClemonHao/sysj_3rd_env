public class ControllerHandler
{
    private static ControllerHandler instance = null;

    public static int bottle_count;
    public static BottleQueue bottle_queue;
    public static ControllerList controller_list;
    public static BottleWaitingList waiting_list;

    private ControllerHandler()
    {
        bottle_count = 7;
        bottle_queue = new BottleQueue(bottle_count);
        controller_list = new ControllerList();
        waiting_list = new BottleWaitingList();
    }

    public static ControllerHandler getInstance()
    {
        if (instance == null)
        {
            synchronized (ControllerHandler.class)
            {
                if (instance == null)
                {
                    instance = new ControllerHandler();
                }
            }
        }
        return instance;
    }
}

