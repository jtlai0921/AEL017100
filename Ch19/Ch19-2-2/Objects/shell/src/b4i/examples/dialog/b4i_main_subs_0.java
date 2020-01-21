package b4i.examples.dialog;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class b4i_main_subs_0 {


public static RemoteObject  _application_background() throws Exception{
try {
		Debug.PushSubsStack("Application_Background (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,33);
if (RapidSub.canDelegate("application_background")) return b4i_main.remoteMe.runUserSub(false, "main","application_background");
 BA.debugLineNum = 33;BA.debugLine="Private Sub Application_Background";
Debug.ShouldStop(1);
 BA.debugLineNum = 35;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("Application_Start (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,20);
if (RapidSub.canDelegate("application_start")) return b4i_main.remoteMe.runUserSub(false, "main","application_start", _nav);
Debug.locals.put("Nav", _nav);
 BA.debugLineNum = 20;BA.debugLine="Private Sub Application_Start (Nav As NavigationController)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 21;BA.debugLine="NavControl = Nav";
Debug.ShouldStop(1048576);
b4i_main._navcontrol = _nav;
 BA.debugLineNum = 22;BA.debugLine="Page1.Initialize(\"Page1\")";
Debug.ShouldStop(2097152);
b4i_main._page1.runVoidMethod ("Initialize::",b4i_main.ba,(Object)(BA.ObjectToString("Page1")));
 BA.debugLineNum = 23;BA.debugLine="Page1.RootPanel.Color = Colors.White";
Debug.ShouldStop(4194304);
b4i_main._page1.runMethod(false,"RootPanel").runMethod(true,"setColor:",b4i_main.__c.runMethod(false,"Colors").runMethod(true,"White"));
 BA.debugLineNum = 24;BA.debugLine="Page1.RootPanel.LoadLayout(\"Main\")";
Debug.ShouldStop(8388608);
b4i_main._page1.runMethod(false,"RootPanel").runMethodAndSync(false,"LoadLayout::",(Object)(BA.ObjectToString("Main")),b4i_main.ba);
 BA.debugLineNum = 25;BA.debugLine="Page1.Title = \"iOS的警告視窗\"";
Debug.ShouldStop(16777216);
b4i_main._page1.runMethod(true,"setTitle:",BA.ObjectToString("iOS的警告視窗"));
 BA.debugLineNum = 26;BA.debugLine="NavControl.ShowPage(Page1)";
Debug.ShouldStop(33554432);
b4i_main._navcontrol.runVoidMethod ("ShowPage:",(Object)(((b4i_main._page1).getObject())));
 BA.debugLineNum = 27;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button1_click() throws Exception{
try {
		Debug.PushSubsStack("Button1_Click (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,37);
if (RapidSub.canDelegate("button1_click")) return b4i_main.remoteMe.runUserSub(false, "main","button1_click");
 BA.debugLineNum = 37;BA.debugLine="Sub Button1_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 38;BA.debugLine="Msgbox2(\"msgDelete\", \"確認是否刪除項目?\", \"編輯\", Array(\"是\", \"否\"))";
Debug.ShouldStop(32);
b4i_main.__c.runVoidMethodAndSync ("Msgbox2:::::",b4i_main.ba,(Object)(BA.ObjectToString("msgDelete")),(Object)(BA.ObjectToString("確認是否刪除項目?")),(Object)(BA.ObjectToString("編輯")),(Object)(BA.ArrayToList(RemoteObject.createNew("B4IArray").runMethod(false, "initObjectsWithData:", (Object)new RemoteObject[] {RemoteObject.createImmutable(("是")),RemoteObject.createImmutable(("否"))}))));
 BA.debugLineNum = 39;BA.debugLine="lblOutput.Text = \"已經顯示iOS的警告視窗...\"";
Debug.ShouldStop(64);
b4i_main._lbloutput.runMethod(true,"setText:",BA.ObjectToString("已經顯示iOS的警告視窗..."));
 BA.debugLineNum = 40;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _msgdelete_click(RemoteObject _buttontext) throws Exception{
try {
		Debug.PushSubsStack("msgDelete_Click (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,43);
if (RapidSub.canDelegate("msgdelete_click")) return b4i_main.remoteMe.runUserSub(false, "main","msgdelete_click", _buttontext);
Debug.locals.put("ButtonText", _buttontext);
 BA.debugLineNum = 43;BA.debugLine="Private Sub msgDelete_Click(ButtonText As String)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 44;BA.debugLine="Select ButtonText";
Debug.ShouldStop(2048);
switch (BA.switchObjectToInt(_buttontext,BA.ObjectToString("是"),BA.ObjectToString("否"))) {
case 0:
 BA.debugLineNum = 46;BA.debugLine="lblOutput.Text = \"確認刪除項目...\"";
Debug.ShouldStop(8192);
b4i_main._lbloutput.runMethod(true,"setText:",BA.ObjectToString("確認刪除項目..."));
 break;
case 1:
 BA.debugLineNum = 48;BA.debugLine="lblOutput.Text = \"取消刪除項目...\"";
Debug.ShouldStop(32768);
b4i_main._lbloutput.runMethod(true,"setText:",BA.ObjectToString("取消刪除項目..."));
 break;
}
;
 BA.debugLineNum = 50;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("Page1_Resize (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,29);
if (RapidSub.canDelegate("page1_resize")) return b4i_main.remoteMe.runUserSub(false, "main","page1_resize", _width, _height);
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 29;BA.debugLine="Private Sub Page1_Resize(Width As Int, Height As Int)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 31;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
 //BA.debugLineNum = 17;BA.debugLine="Private lblOutput As Label";
b4i_main._lbloutput = RemoteObject.createNew("B4ILabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}