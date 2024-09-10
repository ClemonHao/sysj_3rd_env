public class Controller
{
    private String name;
    private String ip;
    private int port;
    private boolean isIdle;
    private boolean isForbidden;

    Controller(String controller_name)
    {
        this.name = controller_name;
        this.ip = "127.0.0.1";
        this.port = 40000;
        this.isIdle = false;
        this.isForbidden = false;
    }

    public String GetName()
    {
        return this.name;
    }

    public boolean IsIdle()
    {
        return this.isIdle;
    }

    public void SetIdle()
    {
        this.isIdle = true; 
    }

    public void ResetIdle()
    {
        this.isIdle = false; 
    }

    public void Forbidden() { this.isForbidden = true; }

    public void SetAvailable() { this.isForbidden = false; }

    public boolean IsForbidden() { return this.isForbidden; }
}
