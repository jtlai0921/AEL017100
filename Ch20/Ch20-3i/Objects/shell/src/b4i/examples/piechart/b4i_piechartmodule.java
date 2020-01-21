
package b4i.examples.piechart;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;

public class b4i_piechartmodule implements IRemote{
	public static b4i_piechartmodule mostCurrent;
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
		mostCurrent = new b4i_piechartmodule();
        remoteMe = RemoteObject.declareNull("b4i.examples.piechart.b4i_piechartmodule");
        //anywheresoftware.b4a.pc.RapidSub.moduleToObject.put("b4i.examples.piechart.b4i_piechartmodule", "b4i.examples.piechart.b4i_piechartmodule");
	}
    public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
		RDebug.INSTANCE.waitForTask();

	}
    private static PCBA pcBA = new PCBA(null, b4i_piechartmodule.class, true);
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
		pcBA = new PCBA(this, b4i_piechartmodule.class, true);
        try {
            BA.init();
            b4i_piechartmodule_subs_0._process_globals();

        } catch(Exception e) {
            throw new RuntimeException(e);
        }
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("B4ICommon");
public static b4i_main _main = null;
public static b4i_piechart _piechart = null;
  public Object[] GetGlobals() {
		return new Object[] {"Main",Debug.moduleToString(b4i_main.class),"PieChart",Debug.moduleToString(b4i_piechart.class)};
}
}