import java.util.HashMap;

public class ControllerList
{
    private final HashMap<String, Controller> map;

    ControllerList()
    {
        this.map = new HashMap<String, Controller>();
    }

    public boolean AddController(String str)
    {
        if (this.map.containsKey(str))
            return false;

        Controller ctler = new Controller(str);
        System.out.println("Controller " + ctler.GetName() + " was added");
        this.map.put(ctler.GetName(), ctler);
        return true;
    }

    public boolean AddController(Controller controller)
    {
        System.out.println("AddController " + controller.GetName());
        if (this.map.containsKey(controller.GetName()))
        {
            System.out.println("Controller " + controller.GetName() + "already exists");
            return false;
        }

        //create a new object
        System.out.println("Controller " + controller.GetName() + " was added");
        Controller c = new Controller(controller.GetName());
        this.map.put(c.GetName(), c);
        return true;
    }

    public boolean CheckAllIdleState()
    {

        for (Controller v : this.map.values())
        {
            //System.out.println("Controller current status " + (v.IsIdle()? "IDLE" : "BUSY"));
            if (v.IsForbidden())
                continue;

            if (!v.IsIdle())
                return false;
        }

        return true;
    }

    public boolean CheckAllIdleStateTest()
    {

        for (Controller v : this.map.values())
        {
            //System.out.println("Controller current status " + (v.IsIdle()? "IDLE" : "BUSY"));
            if (v.IsForbidden())
                continue;

            if (v.IsIdle())
                return true;
        }

        return true;
    }

    public void ResetAllIdleState()
    {
        for (Controller v : this.map.values())
            v.ResetIdle();
    }

    public boolean SetSpecificState(Controller controller) {
        if (this.map.containsKey(controller.GetName()))
            return false;

        this.map.get(controller.GetName()).SetIdle();
        return true;
    }

    public boolean SetSpecificState(String name)
    {
        if (this.map.containsKey(name))
            return false;

        this.map.get(name).SetIdle();

        System.out.println("SetSpecificState " + this.map.get(name).GetName() + " = " + this.map.get(name).IsIdle());
        return true;
    }

    public boolean SetSpecificStateForbidden(String name)
    {
        if (this.map.containsKey(name))
            return false;

        this.map.get(name).Forbidden();
        return true;
    }

    public boolean SetSpecificStateAvailable(String name)
    {
        if (this.map.containsKey(name))
            return false;

        this.map.get(name).SetAvailable();
        return true;
    }

    //true : forbidden
    public boolean SetSpecificForbiddenState(String name, boolean state)
    {
        if (this.map.containsKey(name))
            return false;

        if (state)
            this.map.get(name).Forbidden();
        else
            this.map.get(name).SetAvailable();

        return true;
    }

    public int GetListSize()
    {
        return this.map.size();
    }

}
