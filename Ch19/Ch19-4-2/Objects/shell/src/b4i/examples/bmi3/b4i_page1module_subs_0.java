package b4i.examples.bmi3;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class b4i_page1module_subs_0 {


public static RemoteObject  _btnbmi_click() throws Exception{
try {
		Debug.PushSubsStack("btnBMI_Click (page1module) ","page1module",1,b4i_page1module.ba,b4i_page1module.mostCurrent,24);
if (RapidSub.canDelegate("btnbmi_click")) return b4i_page1module.remoteMe.runUserSub(false, "page1module","btnbmi_click");
RemoteObject _h = RemoteObject.createImmutable(0.0);
RemoteObject _w = RemoteObject.createImmutable(0.0);
 BA.debugLineNum = 24;BA.debugLine="Sub btnBMI_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 25;BA.debugLine="Dim h As Double = txtHeight.Text / 100.0";
Debug.ShouldStop(16777216);
_h = RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, b4i_page1module._txtheight.runMethod(true,"Text")),RemoteObject.createImmutable(100.0)}, "/",0, 0);Debug.locals.put("h", _h);Debug.locals.put("h", _h);
 BA.debugLineNum = 26;BA.debugLine="Dim w As Double = txtWeight.Text";
Debug.ShouldStop(33554432);
_w = BA.numberCast(double.class, b4i_page1module._txtweight.runMethod(true,"Text"));Debug.locals.put("w", _w);Debug.locals.put("w", _w);
 BA.debugLineNum = 27;BA.debugLine="bmiValue = w / (h * h)";
Debug.ShouldStop(67108864);
b4i_page1module._bmivalue = RemoteObject.solve(new RemoteObject[] {_w,(RemoteObject.solve(new RemoteObject[] {_h,_h}, "*",0, 0))}, "/",0, 0);
 BA.debugLineNum = 28;BA.debugLine="Page2Module.ShowPage2()";
Debug.ShouldStop(134217728);
b4i_page1module._page2module.runVoidMethod ("_showpage2");
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
public static RemoteObject  _page1_resize(RemoteObject _width,RemoteObject _height) throws Exception{
try {
		Debug.PushSubsStack("Page1_Resize (page1module) ","page1module",1,b4i_page1module.ba,b4i_page1module.mostCurrent,20);
if (RapidSub.canDelegate("page1_resize")) return b4i_page1module.remoteMe.runUserSub(false, "page1module","page1_resize", _width, _height);
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 20;BA.debugLine="Private Sub Page1_Resize(Width As Int, Height As Int)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 21;BA.debugLine="Log(\"Page1_Resize...\")";
Debug.ShouldStop(1048576);
b4i_page1module.__c.runVoidMethod ("Log:",(Object)(BA.ObjectToString("Page1_Resize...")));
 BA.debugLineNum = 22;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 4;BA.debugLine="Private Page1 As Page";
b4i_page1module._page1 = RemoteObject.createNew("B4IPage");
 //BA.debugLineNum = 5;BA.debugLine="Private txtHeight As TextField";
b4i_page1module._txtheight = RemoteObject.createNew("B4ITextFieldWrapper");
 //BA.debugLineNum = 6;BA.debugLine="Private txtWeight As TextField";
b4i_page1module._txtweight = RemoteObject.createNew("B4ITextFieldWrapper");
 //BA.debugLineNum = 7;BA.debugLine="Public bmiValue As Double";
b4i_page1module._bmivalue = RemoteObject.createImmutable(0.0);
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _showpage1() throws Exception{
try {
		Debug.PushSubsStack("ShowPage1 (page1module) ","page1module",1,b4i_page1module.ba,b4i_page1module.mostCurrent,10);
if (RapidSub.canDelegate("showpage1")) return b4i_page1module.remoteMe.runUserSub(false, "page1module","showpage1");
 BA.debugLineNum = 10;BA.debugLine="Public Sub ShowPage1";
Debug.ShouldStop(512);
 BA.debugLineNum = 11;BA.debugLine="If Page1.IsInitialized = False Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",b4i_page1module._page1.runMethod(true,"IsInitialized"),b4i_page1module.__c.runMethod(true,"False"))) { 
 BA.debugLineNum = 12;BA.debugLine="Page1.Initialize(\"Page1\")";
Debug.ShouldStop(2048);
b4i_page1module._page1.runVoidMethod ("Initialize::",b4i_page1module.ba,(Object)(BA.ObjectToString("Page1")));
 BA.debugLineNum = 13;BA.debugLine="Page1.RootPanel.Color = Colors.White";
Debug.ShouldStop(4096);
b4i_page1module._page1.runMethod(false,"RootPanel").runMethod(true,"setColor:",b4i_page1module.__c.runMethod(false,"Colors").runMethod(true,"White"));
 BA.debugLineNum = 14;BA.debugLine="Page1.RootPanel.LoadLayout(\"Main\")";
Debug.ShouldStop(8192);
b4i_page1module._page1.runMethod(false,"RootPanel").runMethodAndSync(false,"LoadLayout::",(Object)(BA.ObjectToString("Main")),b4i_page1module.ba);
 BA.debugLineNum = 15;BA.debugLine="Page1.Title = \"BMI計算機III\"";
Debug.ShouldStop(16384);
b4i_page1module._page1.runMethod(true,"setTitle:",BA.ObjectToString("BMI計算機III"));
 };
 BA.debugLineNum = 17;BA.debugLine="Main.NavControl.ShowPage(Page1)";
Debug.ShouldStop(65536);
b4i_page1module._main._navcontrol.runVoidMethod ("ShowPage:",(Object)(((b4i_page1module._page1).getObject())));
 BA.debugLineNum = 18;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}