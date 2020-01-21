package b4i.examples.lifecycle;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class b4i_main_subs_0 {


public static RemoteObject  _application_active() throws Exception{
try {
		Debug.PushSubsStack("Application_Active (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,35);
if (RapidSub.canDelegate("application_active")) return b4i_main.remoteMe.runUserSub(false, "main","application_active");
 BA.debugLineNum = 35;BA.debugLine="Private Sub Application_Active";
Debug.ShouldStop(4);
 BA.debugLineNum = 36;BA.debugLine="Log(\"執行Application_Active...\")";
Debug.ShouldStop(8);
b4i_main.__c.runVoidMethod ("Log:",(Object)(BA.ObjectToString("執行Application_Active...")));
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _application_background() throws Exception{
try {
		Debug.PushSubsStack("Application_Background (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,43);
if (RapidSub.canDelegate("application_background")) return b4i_main.remoteMe.runUserSub(false, "main","application_background");
 BA.debugLineNum = 43;BA.debugLine="Private Sub Application_Background";
Debug.ShouldStop(1024);
 BA.debugLineNum = 44;BA.debugLine="Log(\"執行Application_Background...\")";
Debug.ShouldStop(2048);
b4i_main.__c.runVoidMethod ("Log:",(Object)(BA.ObjectToString("執行Application_Background...")));
 BA.debugLineNum = 45;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _application_foreground() throws Exception{
try {
		Debug.PushSubsStack("Application_Foreground (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,31);
if (RapidSub.canDelegate("application_foreground")) return b4i_main.remoteMe.runUserSub(false, "main","application_foreground");
 BA.debugLineNum = 31;BA.debugLine="Private Sub Application_Foreground";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 32;BA.debugLine="Log(\"執行Application_Foreground...\")";
Debug.ShouldStop(-2147483648);
b4i_main.__c.runVoidMethod ("Log:",(Object)(BA.ObjectToString("執行Application_Foreground...")));
 BA.debugLineNum = 33;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _application_inactive() throws Exception{
try {
		Debug.PushSubsStack("Application_Inactive (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,39);
if (RapidSub.canDelegate("application_inactive")) return b4i_main.remoteMe.runUserSub(false, "main","application_inactive");
 BA.debugLineNum = 39;BA.debugLine="Private Sub Application_Inactive";
Debug.ShouldStop(64);
 BA.debugLineNum = 40;BA.debugLine="Log(\"執行Application_Inactive...\")";
Debug.ShouldStop(128);
b4i_main.__c.runVoidMethod ("Log:",(Object)(BA.ObjectToString("執行Application_Inactive...")));
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _application_start(RemoteObject _nav) throws Exception{
try {
		Debug.PushSubsStack("Application_Start (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,18);
if (RapidSub.canDelegate("application_start")) return b4i_main.remoteMe.runUserSub(false, "main","application_start", _nav);
Debug.locals.put("Nav", _nav);
 BA.debugLineNum = 18;BA.debugLine="Private Sub Application_Start (Nav As NavigationController)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 19;BA.debugLine="NavControl = Nav";
Debug.ShouldStop(262144);
b4i_main._navcontrol = _nav;
 BA.debugLineNum = 20;BA.debugLine="Page1.Initialize(\"Page1\")";
Debug.ShouldStop(524288);
b4i_main._page1.runVoidMethod ("Initialize::",b4i_main.ba,(Object)(BA.ObjectToString("Page1")));
 BA.debugLineNum = 21;BA.debugLine="Page1.Title = \"iOS App的生命周期\"";
Debug.ShouldStop(1048576);
b4i_main._page1.runMethod(true,"setTitle:",BA.ObjectToString("iOS App的生命周期"));
 BA.debugLineNum = 22;BA.debugLine="Page1.RootPanel.Color = Colors.White";
Debug.ShouldStop(2097152);
b4i_main._page1.runMethod(false,"RootPanel").runMethod(true,"setColor:",b4i_main.__c.runMethod(false,"Colors").runMethod(true,"White"));
 BA.debugLineNum = 23;BA.debugLine="NavControl.ShowPage(Page1)";
Debug.ShouldStop(4194304);
b4i_main._navcontrol.runVoidMethod ("ShowPage:",(Object)(((b4i_main._page1).getObject())));
 BA.debugLineNum = 24;BA.debugLine="Log(\"執行Application_Start...\")";
Debug.ShouldStop(8388608);
b4i_main.__c.runVoidMethod ("Log:",(Object)(BA.ObjectToString("執行Application_Start...")));
 BA.debugLineNum = 25;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _page1_resize(RemoteObject _width,RemoteObject _height) throws Exception{
try {
		Debug.PushSubsStack("Page1_Resize (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,27);
if (RapidSub.canDelegate("page1_resize")) return b4i_main.remoteMe.runUserSub(false, "main","page1_resize", _width, _height);
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 27;BA.debugLine="Private Sub Page1_Resize(Width As Int, Height As Int)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 28;BA.debugLine="Log(\"執行Page1_Resize...\")";
Debug.ShouldStop(134217728);
b4i_main.__c.runVoidMethod ("Log:",(Object)(BA.ObjectToString("執行Page1_Resize...")));
 BA.debugLineNum = 29;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 10;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 13;BA.debugLine="Public App As Application";
b4i_main._app = RemoteObject.createNew("B4IApplicationWrapper");
 //BA.debugLineNum = 14;BA.debugLine="Public NavControl As NavigationController";
b4i_main._navcontrol = RemoteObject.createNew("B4INavigationControllerWrapper");
 //BA.debugLineNum = 15;BA.debugLine="Private Page1 As Page";
b4i_main._page1 = RemoteObject.createNew("B4IPage");
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}