
package b4i.examples.bmi3;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;

public class b4i_page2module implements IRemote{
	public static b4i_page2module mostCurrent;
    public static RemoteObject ba;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
    static {
		mostCurrent = new b4i_page2module();
        remoteMe = RemoteObject.declareNull("b4i.examples.bmi3.b4i_page2module");
        //anywheresoftware.b4a.pc.RapidSub.moduleToObject.put("b4i.examples.bmi3.b4i_page2module", "b4i.examples.bmi3.b4i_page2module");
	}
    public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
		RDebug.INSTANCE.waitForTask();

	}
    private static PCBA pcBA = new PCBA(null, b4i_page2module.class, true);
	public static RemoteObject runMethod(boolean notUsed, String method, Object... args) throws Exception{
		return (RemoteObject) pcBA.raiseEvent(method.substring(1), args);
	}
    public static void runVoidMethod(String method, Object... args) throws Exception{
		runMethod(false, method, args);
	}
	public static RemoteObject getObject() {
		return remoteMe;
	 }
	public PCBA create(Object[] args) throws ClassNotFoundException{
		ba = (RemoteObject) args[1];
        remoteMe = (RemoteObject) args[2];
        __c = (RemoteObject)args[3];
		pcBA = new PCBA(this, b4i_page2module.class, true);
        try {
            BA.init();
            b4i_page2module_subs_0._process_globals();

        } catch(Exception e) {
            throw new RuntimeException(e);
        }
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("B4ICommon");
public static RemoteObject _page2 = RemoteObject.declareNull("B4IPage");
public static RemoteObject _lbloutput = RemoteObject.declareNull("B4ILabelWrapper");
public static b4i_main _main = null;
public static b4i_page1module _page1module = null;
  public Object[] GetGlobals() {
		return new Object[] {"lblOutput",b4i_page2module._lbloutput,"Main",Debug.moduleToString(b4i_main.class),"Page1Module",Debug.moduleToString(b4i_page1module.class),"Page2",b4i_page2module._page2};
}
}