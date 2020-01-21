package b4i.examples.bmi2;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class b4i_main_subs_0 {


public static RemoteObject  _application_background() throws Exception{
try {
		Debug.PushSubsStack("Application_Background (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,38);
if (RapidSub.canDelegate("application_background")) return b4i_main.remoteMe.runUserSub(false, "main","application_background");
 BA.debugLineNum = 38;BA.debugLine="Private Sub Application_Background";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("Application_Start (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,19);
if (RapidSub.canDelegate("application_start")) return b4i_main.remoteMe.runUserSub(false, "main","application_start", _nav);
Debug.locals.put("Nav", _nav);
 BA.debugLineNum = 19;BA.debugLine="Private Sub Application_Start (Nav As NavigationController)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 20;BA.debugLine="NavControl = Nav";
Debug.ShouldStop(524288);
b4i_main._navcontrol = _nav;
 BA.debugLineNum = 21;BA.debugLine="Page1.Initialize(\"Page1\")";
Debug.ShouldStop(1048576);
b4i_main._page1.runVoidMethod ("Initialize::",b4i_main.ba,(Object)(BA.ObjectToString("Page1")));
 BA.debugLineNum = 22;BA.debugLine="Page1.RootPanel.Color = Colors.White";
Debug.ShouldStop(2097152);
b4i_main._page1.runMethod(false,"RootPanel").runMethod(true,"setColor:",b4i_main.__c.runMethod(false,"Colors").runMethod(true,"White"));
 BA.debugLineNum = 23;BA.debugLine="Page1.RootPanel.LoadLayout(\"Main\")";
Debug.ShouldStop(4194304);
b4i_main._page1.runMethod(false,"RootPanel").runMethodAndSync(false,"LoadLayout::",(Object)(BA.ObjectToString("Main")),b4i_main.ba);
 BA.debugLineNum = 24;BA.debugLine="Page1.Title = \"BMI計算機II\"";
Debug.ShouldStop(8388608);
b4i_main._page1.runMethod(true,"setTitle:",BA.ObjectToString("BMI計算機II"));
 BA.debugLineNum = 25;BA.debugLine="Page2.Initialize(\"Page2\")";
Debug.ShouldStop(16777216);
b4i_main._page2.runVoidMethod ("Initialize::",b4i_main.ba,(Object)(BA.ObjectToString("Page2")));
 BA.debugLineNum = 26;BA.debugLine="Page2.RootPanel.Color = Colors.White";
Debug.ShouldStop(33554432);
b4i_main._page2.runMethod(false,"RootPanel").runMethod(true,"setColor:",b4i_main.__c.runMethod(false,"Colors").runMethod(true,"White"));
 BA.debugLineNum = 27;BA.debugLine="Page2.RootPanel.LoadLayout(\"Result\")";
Debug.ShouldStop(67108864);
b4i_main._page2.runMethod(false,"RootPanel").runMethodAndSync(false,"LoadLayout::",(Object)(BA.ObjectToString("Result")),b4i_main.ba);
 BA.debugLineNum = 28;BA.debugLine="Page2.Title = \"BMI計算結果\"";
Debug.ShouldStop(134217728);
b4i_main._page2.runMethod(true,"setTitle:",BA.ObjectToString("BMI計算結果"));
 BA.debugLineNum = 29;BA.debugLine="NavControl.ShowPage(Page1)  ' 顯示Page1頁面";
Debug.ShouldStop(268435456);
b4i_main._navcontrol.runVoidMethod ("ShowPage:",(Object)(((b4i_main._page1).getObject())));
 BA.debugLineNum = 30;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnbmi_click() throws Exception{
try {
		Debug.PushSubsStack("btnBMI_Click (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,42);
if (RapidSub.canDelegate("btnbmi_click")) return b4i_main.remoteMe.runUserSub(false, "main","btnbmi_click");
RemoteObject _result = RemoteObject.createImmutable(0.0);
RemoteObject _h = RemoteObject.createImmutable(0.0);
RemoteObject _w = RemoteObject.createImmutable(0.0);
 BA.debugLineNum = 42;BA.debugLine="Sub btnBMI_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 43;BA.debugLine="Dim result As Double";
Debug.ShouldStop(1024);
_result = RemoteObject.createImmutable(0.0);Debug.locals.put("result", _result);
 BA.debugLineNum = 44;BA.debugLine="Dim h As Double = txtHeight.Text / 100.0";
Debug.ShouldStop(2048);
_h = RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, b4i_main._txtheight.runMethod(true,"Text")),RemoteObject.createImmutable(100.0)}, "/",0, 0);Debug.locals.put("h", _h);Debug.locals.put("h", _h);
 BA.debugLineNum = 45;BA.debugLine="Dim w As Double = txtWeight.Text";
Debug.ShouldStop(4096);
_w = BA.numberCast(double.class, b4i_main._txtweight.runMethod(true,"Text"));Debug.locals.put("w", _w);Debug.locals.put("w", _w);
 BA.debugLineNum = 46;BA.debugLine="result = w / (h * h)        ' 計算BMI值";
Debug.ShouldStop(8192);
_result = RemoteObject.solve(new RemoteObject[] {_w,(RemoteObject.solve(new RemoteObject[] {_h,_h}, "*",0, 0))}, "/",0, 0);Debug.locals.put("result", _result);
 BA.debugLineNum = 47;BA.debugLine="NavControl.ShowPage(Page2)  ' 顯示Page2頁面";
Debug.ShouldStop(16384);
b4i_main._navcontrol.runVoidMethod ("ShowPage:",(Object)(((b4i_main._page2).getObject())));
 BA.debugLineNum = 49;BA.debugLine="lblOutput.Text = \"BMI值：\" & result";
Debug.ShouldStop(65536);
b4i_main._lbloutput.runMethod(true,"setText:",RemoteObject.concat(RemoteObject.createImmutable("BMI值："),_result));
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
public static RemoteObject  _btnreturn_click() throws Exception{
try {
		Debug.PushSubsStack("btnReturn_Click (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,52);
if (RapidSub.canDelegate("btnreturn_click")) return b4i_main.remoteMe.runUserSub(false, "main","btnreturn_click");
 BA.debugLineNum = 52;BA.debugLine="Sub btnReturn_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 53;BA.debugLine="NavControl.ShowPage(Page1)  ' 顯示Page1頁面";
Debug.ShouldStop(1048576);
b4i_main._navcontrol.runVoidMethod ("ShowPage:",(Object)(((b4i_main._page1).getObject())));
 BA.debugLineNum = 54;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("Page1_Resize (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,32);
if (RapidSub.canDelegate("page1_resize")) return b4i_main.remoteMe.runUserSub(false, "main","page1_resize", _width, _height);
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 32;BA.debugLine="Private Sub Page1_Resize(Width As Int, Height As Int)";
Debug.ShouldStop(-2147483648);
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
public static RemoteObject  _page2_resize(RemoteObject _width,RemoteObject _height) throws Exception{
try {
		Debug.PushSubsStack("Page2_Resize (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,35);
if (RapidSub.canDelegate("page2_resize")) return b4i_main.remoteMe.runUserSub(false, "main","page2_resize", _width, _height);
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 35;BA.debugLine="Private Sub Page2_Resize(Width As Int, Height As Int)";
Debug.ShouldStop(4);
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
 //BA.debugLineNum = 13;BA.debugLine="Private Page1, Page2 As Page";
b4i_main._page1 = RemoteObject.createNew("B4IPage");
b4i_main._page2 = RemoteObject.createNew("B4IPage");
 //BA.debugLineNum = 14;BA.debugLine="Private lblOutput As Label";
b4i_main._lbloutput = RemoteObject.createNew("B4ILabelWrapper");
 //BA.debugLineNum = 15;BA.debugLine="Private txtHeight As TextField";
b4i_main._txtheight = RemoteObject.createNew("B4ITextFieldWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private txtWeight As TextField";
b4i_main._txtweight = RemoteObject.createNew("B4ITextFieldWrapper");
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}