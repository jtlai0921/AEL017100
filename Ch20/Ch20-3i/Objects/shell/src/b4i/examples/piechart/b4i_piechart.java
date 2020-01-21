
package b4i.examples.piechart;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;

public class b4i_piechart implements IRemote{
	public static b4i_piechart mostCurrent;
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
		mostCurrent = new b4i_piechart();
        remoteMe = RemoteObject.declareNull("b4i.examples.piechart.b4i_piechart");
        //anywheresoftware.b4a.pc.RapidSub.moduleToObject.put("b4i.examples.piechart.b4i_piechart", "b4i.examples.piechart.b4i_piechart");
	}
    public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
		RDebug.INSTANCE.waitForTask();

	}
    private static PCBA pcBA = new PCBA(null, b4i_piechart.class, true);
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
		pcBA = new PCBA(this, b4i_piechart.class, true);
        try {
            BA.init();
            b4i_piechart_subs_0._process_globals();

        } catch(Exception e) {
            throw new RuntimeException(e);
        }
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("B4ICommon");
public static RemoteObject _q1 = RemoteObject.createImmutable(0);
public static RemoteObject _q2 = RemoteObject.createImmutable(0);
public static RemoteObject _q3 = RemoteObject.createImmutable(0);
public static RemoteObject _q4 = RemoteObject.createImmutable(0);
public static RemoteObject _piechartpage = RemoteObject.declareNull("B4IPage");
public static RemoteObject _pnlpie = RemoteObject.declareNull("B4IPanelWrapper");
public static b4i_main _main = null;
public static b4i_piechartmodule _piechartmodule = null;
  public Object[] GetGlobals() {
		return new Object[] {"Main",Debug.moduleToString(b4i_main.class),"PieChartModule",Debug.moduleToString(b4i_piechartmodule.class),"PieChartPage",b4i_piechart._piechartpage,"pnlPie",b4i_piechart._pnlpie,"Q1",b4i_piechart._q1,"Q2",b4i_piechart._q2,"Q3",b4i_piechart._q3,"Q4",b4i_piechart._q4};
}
}