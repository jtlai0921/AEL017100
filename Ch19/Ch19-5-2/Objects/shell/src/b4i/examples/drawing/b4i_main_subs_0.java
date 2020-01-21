package b4i.examples.drawing;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class b4i_main_subs_0 {


public static RemoteObject  _application_background() throws Exception{
try {
		Debug.PushSubsStack("Application_Background (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,34);
if (RapidSub.canDelegate("application_background")) return b4i_main.remoteMe.runUserSub(false, "main","application_background");
 BA.debugLineNum = 34;BA.debugLine="Private Sub Application_Background";
Debug.ShouldStop(2);
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
 BA.debugLineNum = 24;BA.debugLine="Page1.Title = \"繪圖\"";
Debug.ShouldStop(8388608);
b4i_main._page1.runMethod(true,"setTitle:",BA.ObjectToString("繪圖"));
 BA.debugLineNum = 25;BA.debugLine="NavControl.ShowPage(Page1)";
Debug.ShouldStop(16777216);
b4i_main._navcontrol.runVoidMethod ("ShowPage:",(Object)(((b4i_main._page1).getObject())));
 BA.debugLineNum = 26;BA.debugLine="bmp.Initialize(File.DirAssets, \"Cow.jpg\")";
Debug.ShouldStop(33554432);
b4i_main._bmp.runVoidMethod ("Initialize::",(Object)(b4i_main.__c.runMethod(false,"File").runMethod(true,"DirAssets")),(Object)(BA.ObjectToString("Cow.jpg")));
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
public static RemoteObject  _drawing() throws Exception{
try {
		Debug.PushSubsStack("Drawing (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,38);
if (RapidSub.canDelegate("drawing")) return b4i_main.remoteMe.runUserSub(false, "main","drawing");
RemoteObject _rect1 = RemoteObject.declareNull("B4IRect");
RemoteObject _rect2 = RemoteObject.declareNull("B4IRect");
 BA.debugLineNum = 38;BA.debugLine="Sub Drawing";
Debug.ShouldStop(32);
 BA.debugLineNum = 40;BA.debugLine="cvsGraph.DrawCircle(50, 40, 25, Colors.Red, True, 3)";
Debug.ShouldStop(128);
b4i_main._cvsgraph.runVoidMethod ("DrawCircle::::::",(Object)(BA.numberCast(float.class, 50)),(Object)(BA.numberCast(float.class, 40)),(Object)(BA.numberCast(float.class, 25)),(Object)(b4i_main.__c.runMethod(false,"Colors").runMethod(true,"Red")),(Object)(b4i_main.__c.runMethod(true,"True")),(Object)(BA.numberCast(float.class, 3)));
 BA.debugLineNum = 42;BA.debugLine="Dim rect1 As Rect";
Debug.ShouldStop(512);
_rect1 = RemoteObject.createNew("B4IRect");Debug.locals.put("rect1", _rect1);
 BA.debugLineNum = 43;BA.debugLine="rect1.Initialize(20, 80, 150, 140)";
Debug.ShouldStop(1024);
_rect1.runVoidMethod ("Initialize::::",(Object)(BA.numberCast(float.class, 20)),(Object)(BA.numberCast(float.class, 80)),(Object)(BA.numberCast(float.class, 150)),(Object)(BA.numberCast(float.class, 140)));
 BA.debugLineNum = 44;BA.debugLine="cvsGraph.DrawRect(rect1, Colors.Blue, False, 3)";
Debug.ShouldStop(2048);
b4i_main._cvsgraph.runVoidMethod ("DrawRect::::",(Object)(_rect1),(Object)(b4i_main.__c.runMethod(false,"Colors").runMethod(true,"Blue")),(Object)(b4i_main.__c.runMethod(true,"False")),(Object)(BA.numberCast(float.class, 3)));
 BA.debugLineNum = 46;BA.debugLine="cvsGraph.DrawLine(20, 160, 160, 160, Colors.Green, 3)";
Debug.ShouldStop(8192);
b4i_main._cvsgraph.runVoidMethod ("DrawLine::::::",(Object)(BA.numberCast(float.class, 20)),(Object)(BA.numberCast(float.class, 160)),(Object)(BA.numberCast(float.class, 160)),(Object)(BA.numberCast(float.class, 160)),(Object)(b4i_main.__c.runMethod(false,"Colors").runMethod(true,"Green")),(Object)(BA.numberCast(float.class, 3)));
 BA.debugLineNum = 48;BA.debugLine="Dim rect2 As Rect";
Debug.ShouldStop(32768);
_rect2 = RemoteObject.createNew("B4IRect");Debug.locals.put("rect2", _rect2);
 BA.debugLineNum = 49;BA.debugLine="rect2.Initialize(20, 180, 150, 240)";
Debug.ShouldStop(65536);
_rect2.runVoidMethod ("Initialize::::",(Object)(BA.numberCast(float.class, 20)),(Object)(BA.numberCast(float.class, 180)),(Object)(BA.numberCast(float.class, 150)),(Object)(BA.numberCast(float.class, 240)));
 BA.debugLineNum = 50;BA.debugLine="cvsGraph.DrawBitmap(bmp, rect2)";
Debug.ShouldStop(131072);
b4i_main._cvsgraph.runVoidMethod ("DrawBitmap::",(Object)(b4i_main._bmp),(Object)(_rect2));
 BA.debugLineNum = 52;BA.debugLine="cvsGraph.DrawText(\"B4i程式設計\", 20, 300, Font.CreateNew(20), Colors.Yellow, \"LEFT\")";
Debug.ShouldStop(524288);
b4i_main._cvsgraph.runVoidMethod ("DrawText::::::",(Object)(BA.ObjectToString("B4i程式設計")),(Object)(BA.numberCast(float.class, 20)),(Object)(BA.numberCast(float.class, 300)),(Object)(b4i_main.__c.runMethod(false,"Font").runMethod(false,"CreateNew:",(Object)(BA.numberCast(float.class, 20)))),(Object)(b4i_main.__c.runMethod(false,"Colors").runMethod(true,"Yellow")),(Object)(BA.ObjectToString("LEFT")));
 BA.debugLineNum = 54;BA.debugLine="cvsGraph.Refresh()";
Debug.ShouldStop(2097152);
b4i_main._cvsgraph.runVoidMethod ("Refresh");
 BA.debugLineNum = 55;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
 BA.debugLineNum = 30;BA.debugLine="cvsGraph.Initialize(pnlGraph)";
Debug.ShouldStop(536870912);
b4i_main._cvsgraph.runVoidMethod ("Initialize:",BA.rdebugUtils.runMethod(false, "ConvertToWrapper::", RemoteObject.createNew("B4IViewWrapper"), (b4i_main._pnlgraph).getObject()));
 BA.debugLineNum = 31;BA.debugLine="Drawing";
Debug.ShouldStop(1073741824);
_drawing();
 BA.debugLineNum = 32;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
 //BA.debugLineNum = 14;BA.debugLine="Private pnlGraph As Panel";
b4i_main._pnlgraph = RemoteObject.createNew("B4IPanelWrapper");
 //BA.debugLineNum = 15;BA.debugLine="Private cvsGraph As Canvas";
b4i_main._cvsgraph = RemoteObject.createNew("B4ICanvas");
 //BA.debugLineNum = 16;BA.debugLine="Private bmp As Bitmap";
b4i_main._bmp = RemoteObject.createNew("B4IBitmap");
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}