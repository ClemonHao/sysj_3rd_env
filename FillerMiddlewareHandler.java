public class FillerMiddlewareHandler {

    private static FillerMiddlewareHandler instance = null;

    public ControllerList filler_list;
    public LiquidIngredient ingredient;

    private FillerMiddlewareHandler() {
        // Initialize the variables
        filler_list = new ControllerList();
        ingredient = new LiquidIngredient();
    }

    public static FillerMiddlewareHandler getInstance() {
        if (instance == null) {
            synchronized (FillerMiddlewareHandler.class) { // Ensure thread safety
                if (instance == null) { // Double-checked locking
                    instance = new FillerMiddlewareHandler();
                }
            }
        }
        return instance;
    }
}
