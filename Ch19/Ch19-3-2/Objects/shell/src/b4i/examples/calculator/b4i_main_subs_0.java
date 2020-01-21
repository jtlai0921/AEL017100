package b4i.examples.calculator;

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
		Debug.PushSubsStack("Application_Start (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,22);
if (RapidSub.canDelegate("application_start")) return b4i_main.remoteMe.runUserSub(false, "main","application_start", _nav);
Debug.locals.put("Nav", _nav);
 BA.debugLineNum = 22;BA.debugLine="Private Sub Application_Start (Nav As NavigationController)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 23;BA.debugLine="NavControl = Nav";
Debug.ShouldStop(4194304);
b4i_main._navcontrol = _nav;
 BA.debugLineNum = 24;BA.debugLine="Page1.Initialize(\"Page1\")";
Debug.ShouldStop(8388608);
b4i_main._page1.runVoidMethod ("Initialize::",b4i_main.ba,(Object)(BA.ObjectToString("Page1")));
 BA.debugLineNum = 25;BA.debugLine="Page1.RootPanel.Color = Colors.White";
Debug.ShouldStop(16777216);
b4i_main._page1.runMethod(false,"RootPanel").runMethod(true,"setColor:",b4i_main.__c.runMethod(false,"Colors").runMethod(true,"White"));
 BA.debugLineNum = 26;BA.debugLine="Page1.RootPanel.LoadLayout(\"Main\")";
Debug.ShouldStop(33554432);
b4i_main._page1.runMethod(false,"RootPanel").runMethodAndSync(false,"LoadLayout::",(Object)(BA.ObjectToString("Main")),b4i_main.ba);
 BA.debugLineNum = 27;BA.debugLine="Page1.Title = \"四則計算機\"";
Debug.ShouldStop(67108864);
b4i_main._page1.runMethod(true,"setTitle:",BA.ObjectToString("四則計算機"));
 BA.debugLineNum = 28;BA.debugLine="NavControl.ShowPage(Page1)";
Debug.ShouldStop(134217728);
b4i_main._navcontrol.runVoidMethod ("ShowPage:",(Object)(((b4i_main._page1).getObject())));
 BA.debugLineNum = 29;BA.debugLine="pkrOp.SetItems(0, Array As String(\"+\",\"-\",\"*\",\"/\"))";
Debug.ShouldStop(268435456);
b4i_main._pkrop.runVoidMethod ("SetItems::",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.ArrayToList(RemoteObject.createNew("B4IArray").runMethod(false, "initObjectsWithData:", (Object)new RemoteObject[] {BA.ObjectToString("+"),BA.ObjectToString("-"),BA.ObjectToString("*"),BA.ObjectToString("/")}))));
 BA.debugLineNum = 30;BA.debugLine="opIndex = 0";
Debug.ShouldStop(536870912);
b4i_main._opindex = BA.numberCast(int.class, 0);
 BA.debugLineNum = 31;BA.debugLine="pkrOp.SelectRow(0, opIndex, True)";
Debug.ShouldStop(1073741824);
b4i_main._pkrop.runVoidMethod ("SelectRow:::",(Object)(BA.numberCast(int.class, 0)),(Object)(b4i_main._opindex),(Object)(b4i_main.__c.runMethod(true,"True")));
 BA.debugLineNum = 32;BA.debugLine="pkrOp.SetRowsHeight(50)";
Debug.ShouldStop(-2147483648);
b4i_main._pkrop.runVoidMethod ("SetRowsHeight:",(Object)(BA.numberCast(int.class, 50)));
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
public static RemoteObject  _btncal_click() throws Exception{
try {
		Debug.PushSubsStack("btnCal_Click (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,45);
if (RapidSub.canDelegate("btncal_click")) return b4i_main.remoteMe.runUserSub(false, "main","btncal_click");
RemoteObject _opd1 = RemoteObject.createImmutable(0);
RemoteObject _opd2 = RemoteObject.createImmutable(0);
RemoteObject _result = RemoteObject.createImmutable(0.0);
 BA.debugLineNum = 45;BA.debugLine="Sub btnCal_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 46;BA.debugLine="Dim opd1, opd2 As Int";
Debug.ShouldStop(8192);
_opd1 = RemoteObject.createImmutable(0);Debug.locals.put("opd1", _opd1);
_opd2 = RemoteObject.createImmutable(0);Debug.locals.put("opd2", _opd2);
 BA.debugLineNum = 47;BA.debugLine="Dim result As Double = 0.0";
Debug.ShouldStop(16384);
_result = BA.numberCast(double.class, 0.0);Debug.locals.put("result", _result);Debug.locals.put("result", _result);
 BA.debugLineNum = 48;BA.debugLine="opd1 = txtOpd1.Text  ' 取得2個運算元";
Debug.ShouldStop(32768);
_opd1 = BA.numberCast(int.class, b4i_main._txtopd1.runMethod(true,"Text"));Debug.locals.put("opd1", _opd1);
 BA.debugLineNum = 49;BA.debugLine="opd2 = txtOpd2.Text";
Debug.ShouldStop(65536);
_opd2 = BA.numberCast(int.class, b4i_main._txtopd2.runMethod(true,"Text"));Debug.locals.put("opd2", _opd2);
 BA.debugLineNum = 50;BA.debugLine="Select opIndex";
Debug.ShouldStop(131072);
switch (BA.switchObjectToInt(b4i_main._opindex,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0:
 BA.debugLineNum = 52;BA.debugLine="result = opd1 + opd2";
Debug.ShouldStop(524288);
_result = BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_opd1,_opd2}, "+",1, 1));Debug.locals.put("result", _result);
 break;
case 1:
 BA.debugLineNum = 54;BA.debugLine="result = opd1 - opd2";
Debug.ShouldStop(2097152);
_result = BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_opd1,_opd2}, "-",1, 1));Debug.locals.put("result", _result);
 break;
case 2:
 BA.debugLineNum = 56;BA.debugLine="result = opd1 * opd2";
Debug.ShouldStop(8388608);
_result = BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_opd1,_opd2}, "*",0, 1));Debug.locals.put("result", _result);
 break;
case 3:
 BA.debugLineNum = 58;BA.debugLine="If swhDivide.Value Then";
Debug.ShouldStop(33554432);
if (b4i_main._swhdivide.runMethod(true,"Value").getBoolean()) { 
 BA.debugLineNum = 59;BA.debugLine="result = IntDivide(opd1, opd2) ' 整數除法";
Debug.ShouldStop(67108864);
_result = BA.numberCast(double.class, _intdivide(_opd1,_opd2));Debug.locals.put("result", _result);
 }else {
 BA.debugLineNum = 61;BA.debugLine="result = opd1 / opd2";
Debug.ShouldStop(268435456);
_result = RemoteObject.solve(new RemoteObject[] {_opd1,_opd2}, "/",0, 0);Debug.locals.put("result", _result);
 };
 break;
}
;
 BA.debugLineNum = 64;BA.debugLine="lblOutput.Text = \"運算結果: \" & result";
Debug.ShouldStop(-2147483648);
b4i_main._lbloutput.runMethod(true,"setText:",RemoteObject.concat(RemoteObject.createImmutable("運算結果: "),_result));
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _intdivide(RemoteObject _op1,RemoteObject _op2) throws Exception{
try {
		Debug.PushSubsStack("IntDivide (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,67);
if (RapidSub.canDelegate("intdivide")) return b4i_main.remoteMe.runUserSub(false, "main","intdivide", _op1, _op2);
RemoteObject _result = RemoteObject.createImmutable(0);
Debug.locals.put("Op1", _op1);
Debug.locals.put("Op2", _op2);
 BA.debugLineNum = 67;BA.debugLine="Sub IntDivide(Op1 As Int, Op2 As Int) As Int";
Debug.ShouldStop(4);
 BA.debugLineNum = 68;BA.debugLine="Dim Result As Int";
Debug.ShouldStop(8);
_result = RemoteObject.createImmutable(0);Debug.locals.put("Result", _result);
 BA.debugLineNum = 69;BA.debugLine="Result = Op1 / Op2";
Debug.ShouldStop(16);
_result = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_op1,_op2}, "/",0, 0));Debug.locals.put("Result", _result);
 BA.debugLineNum = 70;BA.debugLine="Return Result";
Debug.ShouldStop(32);
if (true) return _result;
 BA.debugLineNum = 71;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _page1_resize(RemoteObject _width,RemoteObject _height) throws Exception{
try {
		Debug.PushSubsStack("Page1_Resize (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,35);
if (RapidSub.canDelegate("page1_resize")) return b4i_main.remoteMe.runUserSub(false, "main","page1_resize", _width, _height);
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 35;BA.debugLine="Private Sub Page1_Resize(Width As Int, Height As Int)";
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
public static RemoteObject  _pkrop_itemselected(RemoteObject _column,RemoteObject _row) throws Exception{
try {
		Debug.PushSubsStack("pkrOp_ItemSelected (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,41);
if (RapidSub.canDelegate("pkrop_itemselected")) return b4i_main.remoteMe.runUserSub(false, "main","pkrop_itemselected", _column, _row);
Debug.locals.put("Column", _column);
Debug.locals.put("Row", _row);
 BA.debugLineNum = 41;BA.debugLine="Sub pkrOp_ItemSelected (Column As Int, Row As Int)";
Debug.ShouldStop(256);
 BA.debugLineNum = 42;BA.debugLine="opIndex = Row  ' 取得選擇的運算子索引";
Debug.ShouldStop(512);
b4i_main._opindex = _row;
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
 //BA.debugLineNum = 10;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 11;BA.debugLine="Public App As Application";
b4i_main._app = RemoteObject.createNew("B4IApplicationWrapper");
 //BA.debugLineNum = 12;BA.debugLine="Public NavControl As NavigationController";
b4i_main._navcontrol = RemoteObject.createNew("B4INavigationControllerWrapper");
 //BA.debugLineNum = 13;BA.debugLine="Private Page1 As Page";
b4i_main._page1 = RemoteObject.createNew("B4IPage");
 //BA.debugLineNum = 14;BA.debugLine="Private lblOutput As Label";
b4i_main._lbloutput = RemoteObject.createNew("B4ILabelWrapper");
 //BA.debugLineNum = 15;BA.debugLine="Private pkrOp As Picker";
b4i_main._pkrop = RemoteObject.createNew("B4IPickerWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private swhDivide As Switch";
b4i_main._swhdivide = RemoteObject.createNew("B4ISwitchWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private txtOpd1 As TextField";
b4i_main._txtopd1 = RemoteObject.createNew("B4ITextFieldWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private txtOpd2 As TextField";
b4i_main._txtopd2 = RemoteObject.createNew("B4ITextFieldWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private opIndex As Int";
b4i_main._opindex = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}