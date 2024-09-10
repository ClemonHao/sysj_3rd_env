public class FillerHandler {

    // Static variable to hold the single instance of the class (Singleton)
    private static FillerHandler instance = null;

    // Instance variables for liquid queues
    public FillerLiquidQueue liquid_queue_A;
    public FillerLiquidQueue liquid_queue_B;
    public FillerLiquidQueue liquid_queue_C;
    public FillerLiquidQueue liquid_queue_D;

    // Private constructor to prevent instantiation from outside the class
    private FillerHandler() {
        // Initialize the liquid queues in the constructor
        liquid_queue_A = new FillerLiquidQueue();
        liquid_queue_B = new FillerLiquidQueue();
        liquid_queue_C = new FillerLiquidQueue();
        liquid_queue_D = new FillerLiquidQueue();
    }

    // Public method to provide access to the single instance of the class (Singleton)
    public static FillerHandler getInstance() {
        if (instance == null) {
            synchronized (FillerHandler.class) { // Thread-safe Singleton
                if (instance == null) {
                    instance = new FillerHandler();
                }
            }
        }
        return instance;
    }
}
