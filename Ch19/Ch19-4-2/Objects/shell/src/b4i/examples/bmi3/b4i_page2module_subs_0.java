package b4i.examples.bmi3;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class b4i_page2module_subs_0 {


public static RemoteObject  _btnreturn_click() throws Exception{
try {
		Debug.PushSubsStack("btnReturn_Click (page2module) ","page2module",2,b4i_page2module.ba,b4i_page2module.mostCurrent,23);
if (RapidSub.canDelegate("btnreturn_click")) return b4i_page2module.remoteMe.runUserSub(false, "page2module","btnreturn_click");
 BA.debugLineNum = 23;BA.debugLine="Sub btnReturn_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 24;BA.debugLine="Page1Module.ShowPage1()";
Debug.ShouldStop(8388608);
b4i_page2module._page1module.runVoidMethod ("_showpage1");
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
public static RemoteObject  _page2_resize(RemoteObject _width,RemoteObject _height) throws Exception{
try {
		Debug.PushSubsStack("Page2_Resize (page2module) ","page2module",2,b4i_page2module.ba,b4i_page2module.mostCurrent,19);
if (RapidSub.canDelegate("page2_resize")) return b4i_page2module.remoteMe.runUserSub(false, "page2module","page2_resize", _width, _height);
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 19;BA.debugLine="Private Sub Page2_Resize(Width As Int, Height As Int)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 20;BA.debugLine="Log(\"Page2_Resize...\")";
Debug.ShouldStop(524288);
b4i_page2module.__c.runVoidMethod ("Log:",(Object)(BA.ObjectToString("Page2_Resize...")));
 BA.debugLineNum = 21;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
 //BA.debugLineNum = 4;BA.debugLine="Private Page2 As Page";
b4i_page2module._page2 = RemoteObject.createNew("B4IPage");
 //BA.debugLineNum = 5;BA.debugLine="Private lblOutput As Label";
b4i_page2module._lbloutput = RemoteObject.createNew("B4ILabelWrapper");
 //BA.debugLineNum = 6;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _showpage2() throws Exception{
try {
		Debug.PushSubsStack("ShowPage2 (page2module) ","page2module",2,b4i_page2module.ba,b4i_page2module.mostCurrent,8);
if (RapidSub.canDelegate("showpage2")) return b4i_page2module.remoteMe.runUserSub(false, "page2module","showpage2");
 BA.debugLineNum = 8;BA.debugLine="Public Sub ShowPage2";
Debug.ShouldStop(128);
 BA.debugLineNum = 9;BA.debugLine="If Page2.IsInitialized = False Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",b4i_page2module._page2.runMethod(true,"IsInitialized"),b4i_page2module.__c.runMethod(true,"False"))) { 
 BA.debugLineNum = 10;BA.debugLine="Page2.Initialize(\"Page2\")";
Debug.ShouldStop(512);
b4i_page2module._page2.runVoidMethod ("Initialize::",b4i_page2module.ba,(Object)(BA.ObjectToString("Page2")));
 BA.debugLineNum = 11;BA.debugLine="Page2.RootPanel.Color = Colors.White";
Debug.ShouldStop(1024);
b4i_page2module._page2.runMethod(false,"RootPanel").runMethod(true,"setColor:",b4i_page2module.__c.runMethod(false,"Colors").runMethod(true,"White"));
 BA.debugLineNum = 12;BA.debugLine="Page2.RootPanel.LoadLayout(\"Result\")";
Debug.ShouldStop(2048);
b4i_page2module._page2.runMethod(false,"RootPanel").runMethodAndSync(false,"LoadLayout::",(Object)(BA.ObjectToString("Result")),b4i_page2module.ba);
 BA.debugLineNum = 13;BA.debugLine="Page2.Title = \"BMI計算結果\"";
Debug.ShouldStop(4096);
b4i_page2module._page2.runMethod(true,"setTitle:",BA.ObjectToString("BMI計算結果"));
 };
 BA.debugLineNum = 15;BA.debugLine="Main.NavControl.ShowPage(Page2)";
Debug.ShouldStop(16384);
b4i_page2module._main._navcontrol.runVoidMethod ("ShowPage:",(Object)(((b4i_page2module._page2).getObject())));
 BA.debugLineNum = 16;BA.debugLine="lblOutput.Text = \"BMI值：\" & Page1Module.bmiValue";
Debug.ShouldStop(32768);
b4i_page2module._lbloutput.runMethod(true,"setText:",RemoteObject.concat(RemoteObject.createImmutable("BMI值："),b4i_page2module._page1module._bmivalue));
 BA.debugLineNum = 17;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}