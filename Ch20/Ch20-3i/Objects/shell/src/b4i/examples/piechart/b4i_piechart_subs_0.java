package b4i.examples.piechart;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class b4i_piechart_subs_0 {


public static RemoteObject  _page1_resize(RemoteObject _width,RemoteObject _height) throws Exception{
try {
		Debug.PushSubsStack("Page1_Resize (piechart) ","piechart",1,b4i_piechart.ba,b4i_piechart.mostCurrent,41);
if (RapidSub.canDelegate("page1_resize")) return b4i_piechart.remoteMe.runUserSub(false, "piechart","page1_resize", _width, _height);
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 41;BA.debugLine="Private Sub Page1_Resize(Width As Int, Height As Int)";
Debug.ShouldStop(256);
 BA.debugLineNum = 43;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
 //BA.debugLineNum = 4;BA.debugLine="Public Q1, Q2, Q3, Q4 As Int";
b4i_piechart._q1 = RemoteObject.createImmutable(0);
b4i_piechart._q2 = RemoteObject.createImmutable(0);
b4i_piechart._q3 = RemoteObject.createImmutable(0);
b4i_piechart._q4 = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 5;BA.debugLine="Private PieChartPage As Page";
b4i_piechart._piechartpage = RemoteObject.createNew("B4IPage");
 //BA.debugLineNum = 6;BA.debugLine="Private pnlPie As Panel";
b4i_piechart._pnlpie = RemoteObject.createNew("B4IPanelWrapper");
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _showpiechart() throws Exception{
try {
		Debug.PushSubsStack("ShowPieChart (piechart) ","piechart",1,b4i_piechart.ba,b4i_piechart.mostCurrent,9);
if (RapidSub.canDelegate("showpiechart")) return b4i_piechart.remoteMe.runUserSub(false, "piechart","showpiechart");
RemoteObject _pd = RemoteObject.declareNull("_piedata");
RemoteObject _legend = RemoteObject.declareNull("B4IImageViewWrapper");
 BA.debugLineNum = 9;BA.debugLine="Public Sub ShowPieChart";
Debug.ShouldStop(256);
 BA.debugLineNum = 10;BA.debugLine="If PieChartPage.IsInitialized = False Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",b4i_piechart._piechartpage.runMethod(true,"IsInitialized"),b4i_piechart.__c.runMethod(true,"False"))) { 
 BA.debugLineNum = 11;BA.debugLine="PieChartPage.Initialize(\"PieChartPage\")";
Debug.ShouldStop(1024);
b4i_piechart._piechartpage.runVoidMethod ("Initialize::",b4i_piechart.ba,(Object)(BA.ObjectToString("PieChartPage")));
 BA.debugLineNum = 12;BA.debugLine="PieChartPage.RootPanel.Color = Colors.White";
Debug.ShouldStop(2048);
b4i_piechart._piechartpage.runMethod(false,"RootPanel").runMethod(true,"setColor:",b4i_piechart.__c.runMethod(false,"Colors").runMethod(true,"White"));
 BA.debugLineNum = 13;BA.debugLine="PieChartPage.Title = \"顯示業績統計圖表\"";
Debug.ShouldStop(4096);
b4i_piechart._piechartpage.runMethod(true,"setTitle:",BA.ObjectToString("顯示業績統計圖表"));
 BA.debugLineNum = 15;BA.debugLine="pnlPie.Initialize(\"\")";
Debug.ShouldStop(16384);
b4i_piechart._pnlpie.runVoidMethod ("Initialize::",b4i_piechart.ba,(Object)(BA.ObjectToString("")));
 BA.debugLineNum = 16;BA.debugLine="PieChartPage.RootPanel.AddView(pnlPie, 5%x, 5%y, 90%x, 90%y)";
Debug.ShouldStop(32768);
b4i_piechart._piechartpage.runMethod(false,"RootPanel").runVoidMethod ("AddView:::::",(Object)(((b4i_piechart._pnlpie).getObject())),(Object)(b4i_piechart.__c.runMethod(true,"PerXToCurrent:",(Object)(BA.numberCast(float.class, 5)))),(Object)(b4i_piechart.__c.runMethod(true,"PerYToCurrent:",(Object)(BA.numberCast(float.class, 5)))),(Object)(b4i_piechart.__c.runMethod(true,"PerXToCurrent:",(Object)(BA.numberCast(float.class, 90)))),(Object)(b4i_piechart.__c.runMethod(true,"PerYToCurrent:",(Object)(BA.numberCast(float.class, 90)))));
 };
 BA.debugLineNum = 19;BA.debugLine="Dim PD As PieData";
Debug.ShouldStop(262144);
_pd = RemoteObject.createNew("_piedata");Debug.locals.put("PD", _pd);
 BA.debugLineNum = 20;BA.debugLine="PD.Initialize()";
Debug.ShouldStop(524288);
_pd.runVoidMethod ("Initialize");
 BA.debugLineNum = 21;BA.debugLine="PD.Target = pnlPie  ' 指定顯示的元件";
Debug.ShouldStop(1048576);
_pd.setFieldClass("_piedata", "Target",b4i_piechart._pnlpie);
 BA.debugLineNum = 23;BA.debugLine="PieChartModule.AddPieItem(PD, \"第一季: \" & Q1 , Q1, 0)";
Debug.ShouldStop(4194304);
b4i_piechart._piechartmodule.runVoidMethod ("_addpieitem::::",(Object)(_pd),(Object)(RemoteObject.concat(RemoteObject.createImmutable("第一季: "),b4i_piechart._q1)),(Object)(BA.numberCast(float.class, b4i_piechart._q1)),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 24;BA.debugLine="PieChartModule.AddPieItem(PD, \"第二季: \" & Q2 , Q2, 0)";
Debug.ShouldStop(8388608);
b4i_piechart._piechartmodule.runVoidMethod ("_addpieitem::::",(Object)(_pd),(Object)(RemoteObject.concat(RemoteObject.createImmutable("第二季: "),b4i_piechart._q2)),(Object)(BA.numberCast(float.class, b4i_piechart._q2)),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 25;BA.debugLine="PieChartModule.AddPieItem(PD, \"第三季: \" & Q3 , Q3, 0)";
Debug.ShouldStop(16777216);
b4i_piechart._piechartmodule.runVoidMethod ("_addpieitem::::",(Object)(_pd),(Object)(RemoteObject.concat(RemoteObject.createImmutable("第三季: "),b4i_piechart._q3)),(Object)(BA.numberCast(float.class, b4i_piechart._q3)),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 26;BA.debugLine="PieChartModule.AddPieItem(PD, \"第四季: \" & Q4 , Q4, 0)";
Debug.ShouldStop(33554432);
b4i_piechart._piechartmodule.runVoidMethod ("_addpieitem::::",(Object)(_pd),(Object)(RemoteObject.concat(RemoteObject.createImmutable("第四季: "),b4i_piechart._q4)),(Object)(BA.numberCast(float.class, b4i_piechart._q4)),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 28;BA.debugLine="PD.GapDegrees = 10";
Debug.ShouldStop(134217728);
_pd.setFieldClass("_piedata", "GapDegrees",BA.numberCast(int.class, 10));
 BA.debugLineNum = 30;BA.debugLine="PD.LegendBackColor = Colors.ARGB(150, 100, 120, 120)";
Debug.ShouldStop(536870912);
_pd.setFieldClass("_piedata", "LegendBackColor",b4i_piechart.__c.runMethod(false,"Colors").runMethod(true,"ARGB::::",(Object)(BA.numberCast(int.class, 150)),(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 120)),(Object)(BA.numberCast(int.class, 120))));
 BA.debugLineNum = 32;BA.debugLine="Dim legend As ImageView";
Debug.ShouldStop(-2147483648);
_legend = RemoteObject.createNew("B4IImageViewWrapper");Debug.locals.put("legend", _legend);
 BA.debugLineNum = 33;BA.debugLine="legend = PieChartModule.DrawPie(PD, Colors.Gray, True)";
Debug.ShouldStop(1);
_legend = b4i_piechart._piechartmodule.runMethod(false,"_drawpie:::",(Object)(_pd),(Object)(b4i_piechart.__c.runMethod(false,"Colors").runMethod(true,"Gray")),(Object)(b4i_piechart.__c.runMethod(true,"True")));Debug.locals.put("legend", _legend);
 BA.debugLineNum = 34;BA.debugLine="If legend.IsInitialized() Then  ' 有圖例";
Debug.ShouldStop(2);
if (_legend.runMethod(true,"IsInitialized").getBoolean()) { 
 BA.debugLineNum = 36;BA.debugLine="pnlPie.AddView(legend, 2dip,0dip, legend.Width, legend.Height)";
Debug.ShouldStop(8);
b4i_piechart._pnlpie.runVoidMethod ("AddView:::::",(Object)(((_legend).getObject())),(Object)(BA.numberCast(float.class, b4i_piechart.__c.runMethod(true,"DipToCurrent:",(Object)(BA.numberCast(int.class, 2))))),(Object)(BA.numberCast(float.class, b4i_piechart.__c.runMethod(true,"DipToCurrent:",(Object)(BA.numberCast(int.class, 0))))),(Object)(_legend.runMethod(true,"Width")),(Object)(_legend.runMethod(true,"Height")));
 };
 BA.debugLineNum = 38;BA.debugLine="Main.NavControl.ShowPage(PieChartPage)";
Debug.ShouldStop(32);
b4i_piechart._main._navcontrol.runVoidMethod ("ShowPage:",(Object)(((b4i_piechart._piechartpage).getObject())));
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
}