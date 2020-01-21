package b4i.examples.piechart;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class b4i_main_subs_0 {


public static RemoteObject  _application_background() throws Exception{
try {
		Debug.PushSubsStack("Application_Background (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,37);
if (RapidSub.canDelegate("application_background")) return b4i_main.remoteMe.runUserSub(false, "main","application_background");
 BA.debugLineNum = 37;BA.debugLine="Private Sub Application_Background";
Debug.ShouldStop(16);
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
 BA.debugLineNum = 25;BA.debugLine="Page1.Title = \"業績統計圖表\"";
Debug.ShouldStop(16777216);
b4i_main._page1.runMethod(true,"setTitle:",BA.ObjectToString("業績統計圖表"));
 BA.debugLineNum = 26;BA.debugLine="NavControl.ShowPage(Page1)";
Debug.ShouldStop(33554432);
b4i_main._navcontrol.runVoidMethod ("ShowPage:",(Object)(((b4i_main._page1).getObject())));
 BA.debugLineNum = 27;BA.debugLine="txtQ1.Text = \"234\"    ' 指定初值";
Debug.ShouldStop(67108864);
b4i_main._txtq1.runMethod(true,"setText:",BA.ObjectToString("234"));
 BA.debugLineNum = 28;BA.debugLine="txtQ2.Text = \"256\"";
Debug.ShouldStop(134217728);
b4i_main._txtq2.runMethod(true,"setText:",BA.ObjectToString("256"));
 BA.debugLineNum = 29;BA.debugLine="txtQ3.Text = \"453\"";
Debug.ShouldStop(268435456);
b4i_main._txtq3.runMethod(true,"setText:",BA.ObjectToString("453"));
 BA.debugLineNum = 30;BA.debugLine="txtQ4.Text = \"512\"";
Debug.ShouldStop(536870912);
b4i_main._txtq4.runMethod(true,"setText:",BA.ObjectToString("512"));
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
public static RemoteObject  _button1_click() throws Exception{
try {
		Debug.PushSubsStack("Button1_Click (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,41);
if (RapidSub.canDelegate("button1_click")) return b4i_main.remoteMe.runUserSub(false, "main","button1_click");
 BA.debugLineNum = 41;BA.debugLine="Sub Button1_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 42;BA.debugLine="PieChart.Q1 = txtQ1.Text";
Debug.ShouldStop(512);
b4i_main._piechart._q1 = BA.numberCast(int.class, b4i_main._txtq1.runMethod(true,"Text"));
 BA.debugLineNum = 43;BA.debugLine="PieChart.Q2 = txtQ2.Text";
Debug.ShouldStop(1024);
b4i_main._piechart._q2 = BA.numberCast(int.class, b4i_main._txtq2.runMethod(true,"Text"));
 BA.debugLineNum = 44;BA.debugLine="PieChart.Q3 = txtQ3.Text";
Debug.ShouldStop(2048);
b4i_main._piechart._q3 = BA.numberCast(int.class, b4i_main._txtq3.runMethod(true,"Text"));
 BA.debugLineNum = 45;BA.debugLine="PieChart.Q4 = txtQ4.Text";
Debug.ShouldStop(4096);
b4i_main._piechart._q4 = BA.numberCast(int.class, b4i_main._txtq4.runMethod(true,"Text"));
 BA.debugLineNum = 46;BA.debugLine="PieChart.ShowPieChart() ' 顯示PieChartPage頁面";
Debug.ShouldStop(8192);
b4i_main._piechart.runVoidMethod ("_showpiechart");
 BA.debugLineNum = 47;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("Page1_Resize (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,33);
if (RapidSub.canDelegate("page1_resize")) return b4i_main.remoteMe.runUserSub(false, "main","page1_resize", _width, _height);
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 33;BA.debugLine="Private Sub Page1_Resize(Width As Int, Height As Int)";
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 10;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 11;BA.debugLine="Public App As Application";
b4i_main._app = RemoteObject.createNew("B4IApplicationWrapper");
 //BA.debugLineNum = 12;BA.debugLine="Public NavControl As NavigationController";
b4i_main._navcontrol = RemoteObject.createNew("B4INavigationControllerWrapper");
 //BA.debugLineNum = 13;BA.debugLine="Private Page1 As Page";
b4i_main._page1 = RemoteObject.createNew("B4IPage");
 //BA.debugLineNum = 14;BA.debugLine="Private txtQ1 As TextField";
b4i_main._txtq1 = RemoteObject.createNew("B4ITextFieldWrapper");
 //BA.debugLineNum = 15;BA.debugLine="Private txtQ2 As TextField";
b4i_main._txtq2 = RemoteObject.createNew("B4ITextFieldWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private txtQ3 As TextField";
b4i_main._txtq3 = RemoteObject.createNew("B4ITextFieldWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private txtQ4 As TextField";
b4i_main._txtq4 = RemoteObject.createNew("B4ITextFieldWrapper");
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}