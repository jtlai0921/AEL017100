package b4i.examples.file;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class b4i_main_subs_0 {


public static RemoteObject  _application_background() throws Exception{
try {
		Debug.PushSubsStack("Application_Background (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,30);
if (RapidSub.canDelegate("application_background")) return b4i_main.remoteMe.runUserSub(false, "main","application_background");
 BA.debugLineNum = 30;BA.debugLine="Private Sub Application_Background";
Debug.ShouldStop(536870912);
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
public static RemoteObject  _application_start(RemoteObject _nav) throws Exception{
try {
		Debug.PushSubsStack("Application_Start (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,17);
if (RapidSub.canDelegate("application_start")) return b4i_main.remoteMe.runUserSub(false, "main","application_start", _nav);
Debug.locals.put("Nav", _nav);
 BA.debugLineNum = 17;BA.debugLine="Private Sub Application_Start (Nav As NavigationController)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 18;BA.debugLine="NavControl = Nav";
Debug.ShouldStop(131072);
b4i_main._navcontrol = _nav;
 BA.debugLineNum = 19;BA.debugLine="Page1.Initialize(\"Page1\")";
Debug.ShouldStop(262144);
b4i_main._page1.runVoidMethod ("Initialize::",b4i_main.ba,(Object)(BA.ObjectToString("Page1")));
 BA.debugLineNum = 20;BA.debugLine="Page1.RootPanel.Color = Colors.White";
Debug.ShouldStop(524288);
b4i_main._page1.runMethod(false,"RootPanel").runMethod(true,"setColor:",b4i_main.__c.runMethod(false,"Colors").runMethod(true,"White"));
 BA.debugLineNum = 21;BA.debugLine="Page1.RootPanel.LoadLayout(\"Main\")";
Debug.ShouldStop(1048576);
b4i_main._page1.runMethod(false,"RootPanel").runMethodAndSync(false,"LoadLayout::",(Object)(BA.ObjectToString("Main")),b4i_main.ba);
 BA.debugLineNum = 22;BA.debugLine="Page1.Title = \"檔案讀寫\"";
Debug.ShouldStop(2097152);
b4i_main._page1.runMethod(true,"setTitle:",BA.ObjectToString("檔案讀寫"));
 BA.debugLineNum = 23;BA.debugLine="NavControl.ShowPage(Page1)";
Debug.ShouldStop(4194304);
b4i_main._navcontrol.runVoidMethod ("ShowPage:",(Object)(((b4i_main._page1).getObject())));
 BA.debugLineNum = 24;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("Button1_Click (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,34);
if (RapidSub.canDelegate("button1_click")) return b4i_main.remoteMe.runUserSub(false, "main","button1_click");
RemoteObject _content = RemoteObject.createImmutable("");
 BA.debugLineNum = 34;BA.debugLine="Sub Button1_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 35;BA.debugLine="Dim content As String = \"B4i程式設計\"";
Debug.ShouldStop(4);
_content = BA.ObjectToString("B4i程式設計");Debug.locals.put("content", _content);Debug.locals.put("content", _content);
 BA.debugLineNum = 36;BA.debugLine="File.WriteString(File.DirDocuments, \"string.txt\", content)";
Debug.ShouldStop(8);
b4i_main.__c.runMethod(false,"File").runVoidMethod ("WriteString:::",(Object)(b4i_main.__c.runMethod(false,"File").runMethod(true,"DirDocuments")),(Object)(BA.ObjectToString("string.txt")),(Object)(_content));
 BA.debugLineNum = 37;BA.debugLine="lblOutput.Text = \"已經將字串寫入檔案string.txt...\"";
Debug.ShouldStop(16);
b4i_main._lbloutput.runMethod(true,"setText:",BA.ObjectToString("已經將字串寫入檔案string.txt..."));
 BA.debugLineNum = 38;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button2_click() throws Exception{
try {
		Debug.PushSubsStack("Button2_Click (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,40);
if (RapidSub.canDelegate("button2_click")) return b4i_main.remoteMe.runUserSub(false, "main","button2_click");
RemoteObject _content = RemoteObject.createImmutable("");
 BA.debugLineNum = 40;BA.debugLine="Sub Button2_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 41;BA.debugLine="Dim content As String";
Debug.ShouldStop(256);
_content = RemoteObject.createImmutable("");Debug.locals.put("content", _content);
 BA.debugLineNum = 42;BA.debugLine="If File.Exists(File.DirDocuments, \"string.txt\") Then";
Debug.ShouldStop(512);
if (b4i_main.__c.runMethod(false,"File").runMethod(true,"Exists::",(Object)(b4i_main.__c.runMethod(false,"File").runMethod(true,"DirDocuments")),(Object)(BA.ObjectToString("string.txt"))).getBoolean()) { 
 BA.debugLineNum = 43;BA.debugLine="content = File.ReadString(File.DirDocuments, \"string.txt\")";
Debug.ShouldStop(1024);
_content = b4i_main.__c.runMethod(false,"File").runMethod(true,"ReadString::",(Object)(b4i_main.__c.runMethod(false,"File").runMethod(true,"DirDocuments")),(Object)(BA.ObjectToString("string.txt")));Debug.locals.put("content", _content);
 BA.debugLineNum = 44;BA.debugLine="lblOutput.Text = content";
Debug.ShouldStop(2048);
b4i_main._lbloutput.runMethod(true,"setText:",_content);
 }else {
 BA.debugLineNum = 46;BA.debugLine="lblOutput.Text = \"檔案：string.txt不存在...\"";
Debug.ShouldStop(8192);
b4i_main._lbloutput.runMethod(true,"setText:",BA.ObjectToString("檔案：string.txt不存在..."));
 };
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button3_click() throws Exception{
try {
		Debug.PushSubsStack("Button3_Click (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,50);
if (RapidSub.canDelegate("button3_click")) return b4i_main.remoteMe.runUserSub(false, "main","button3_click");
RemoteObject _students = RemoteObject.declareNull("B4IList");
 BA.debugLineNum = 50;BA.debugLine="Sub Button3_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 51;BA.debugLine="Dim students As List";
Debug.ShouldStop(262144);
_students = RemoteObject.createNew("B4IList");Debug.locals.put("students", _students);
 BA.debugLineNum = 52;BA.debugLine="students.Initialize()";
Debug.ShouldStop(524288);
_students.runVoidMethod ("Initialize");
 BA.debugLineNum = 53;BA.debugLine="students.Add(\"陳會安\")";
Debug.ShouldStop(1048576);
_students.runVoidMethod ("Add:",(Object)(RemoteObject.createImmutable(("陳會安"))));
 BA.debugLineNum = 54;BA.debugLine="students.Add(\"江小魚\")";
Debug.ShouldStop(2097152);
_students.runVoidMethod ("Add:",(Object)(RemoteObject.createImmutable(("江小魚"))));
 BA.debugLineNum = 55;BA.debugLine="File.WriteList(File.DirDocuments, \"list.txt\", students)";
Debug.ShouldStop(4194304);
b4i_main.__c.runMethod(false,"File").runVoidMethod ("WriteList:::",(Object)(b4i_main.__c.runMethod(false,"File").runMethod(true,"DirDocuments")),(Object)(BA.ObjectToString("list.txt")),(Object)(_students));
 BA.debugLineNum = 56;BA.debugLine="lblOutput.Text = \"已經將List物件寫入檔案list.txt...\"";
Debug.ShouldStop(8388608);
b4i_main._lbloutput.runMethod(true,"setText:",BA.ObjectToString("已經將List物件寫入檔案list.txt..."));
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button4_click() throws Exception{
try {
		Debug.PushSubsStack("Button4_Click (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,59);
if (RapidSub.canDelegate("button4_click")) return b4i_main.remoteMe.runUserSub(false, "main","button4_click");
RemoteObject _students = RemoteObject.declareNull("B4IList");
RemoteObject _content = RemoteObject.createImmutable("");
int _i = 0;
 BA.debugLineNum = 59;BA.debugLine="Sub Button4_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 60;BA.debugLine="Dim students As List";
Debug.ShouldStop(134217728);
_students = RemoteObject.createNew("B4IList");Debug.locals.put("students", _students);
 BA.debugLineNum = 61;BA.debugLine="Dim content As String = \"\"";
Debug.ShouldStop(268435456);
_content = BA.ObjectToString("");Debug.locals.put("content", _content);Debug.locals.put("content", _content);
 BA.debugLineNum = 62;BA.debugLine="If File.Exists(File.DirDocuments, \"list.txt\") Then";
Debug.ShouldStop(536870912);
if (b4i_main.__c.runMethod(false,"File").runMethod(true,"Exists::",(Object)(b4i_main.__c.runMethod(false,"File").runMethod(true,"DirDocuments")),(Object)(BA.ObjectToString("list.txt"))).getBoolean()) { 
 BA.debugLineNum = 63;BA.debugLine="students = File.ReadList(File.DirDocuments, \"list.txt\")";
Debug.ShouldStop(1073741824);
_students = b4i_main.__c.runMethod(false,"File").runMethod(false,"ReadList::",(Object)(b4i_main.__c.runMethod(false,"File").runMethod(true,"DirDocuments")),(Object)(BA.ObjectToString("list.txt")));Debug.locals.put("students", _students);
 BA.debugLineNum = 64;BA.debugLine="For i = 0 To students.Size - 1";
Debug.ShouldStop(-2147483648);
{
int step45 = 1;
int limit45 = RemoteObject.solve(new RemoteObject[] {_students.runMethod(true,"Size"),RemoteObject.createImmutable(1)}, "-",1, 1).<Number>get().intValue();
for (_i = 0; (step45 > 0 && _i <= limit45) || (step45 < 0 && _i >= limit45); _i = ((int)(0 + _i + step45))) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 65;BA.debugLine="content = content & students.Get(i) & CRLF";
Debug.ShouldStop(1);
_content = RemoteObject.concat(_content,_students.runMethod(false,"Get:",(Object)(BA.numberCast(int.class, _i))),b4i_main.__c.runMethod(true,"CRLF"));Debug.locals.put("content", _content);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 67;BA.debugLine="lblOutput.Text = content";
Debug.ShouldStop(4);
b4i_main._lbloutput.runMethod(true,"setText:",_content);
 }else {
 BA.debugLineNum = 69;BA.debugLine="lblOutput.Text = \"檔案：list.txt不存在...\"";
Debug.ShouldStop(16);
b4i_main._lbloutput.runMethod(true,"setText:",BA.ObjectToString("檔案：list.txt不存在..."));
 };
 BA.debugLineNum = 71;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button5_click() throws Exception{
try {
		Debug.PushSubsStack("Button5_Click (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,73);
if (RapidSub.canDelegate("button5_click")) return b4i_main.remoteMe.runUserSub(false, "main","button5_click");
RemoteObject _items = RemoteObject.declareNull("B4IMap");
 BA.debugLineNum = 73;BA.debugLine="Sub Button5_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 74;BA.debugLine="Dim items As Map";
Debug.ShouldStop(512);
_items = RemoteObject.createNew("B4IMap");Debug.locals.put("items", _items);
 BA.debugLineNum = 75;BA.debugLine="items.Initialize()";
Debug.ShouldStop(1024);
_items.runVoidMethod ("Initialize");
 BA.debugLineNum = 76;BA.debugLine="items.Put(\"Google\", \"http://www.google.com/\")";
Debug.ShouldStop(2048);
_items.runVoidMethod ("Put::",(Object)(RemoteObject.createImmutable(("Google"))),(Object)(RemoteObject.createImmutable(("http://www.google.com/"))));
 BA.debugLineNum = 77;BA.debugLine="items.Put(\"Yahoo\", \"http://www.yahoo.com/\")";
Debug.ShouldStop(4096);
_items.runVoidMethod ("Put::",(Object)(RemoteObject.createImmutable(("Yahoo"))),(Object)(RemoteObject.createImmutable(("http://www.yahoo.com/"))));
 BA.debugLineNum = 78;BA.debugLine="File.WriteMap(File.DirDocuments, \"map.txt\", items)";
Debug.ShouldStop(8192);
b4i_main.__c.runMethod(false,"File").runVoidMethod ("WriteMap:::",(Object)(b4i_main.__c.runMethod(false,"File").runMethod(true,"DirDocuments")),(Object)(BA.ObjectToString("map.txt")),(Object)(_items));
 BA.debugLineNum = 79;BA.debugLine="lblOutput.Text = \"已經將Map物件寫入檔案map.txt...\"";
Debug.ShouldStop(16384);
b4i_main._lbloutput.runMethod(true,"setText:",BA.ObjectToString("已經將Map物件寫入檔案map.txt..."));
 BA.debugLineNum = 80;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button6_click() throws Exception{
try {
		Debug.PushSubsStack("Button6_Click (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,82);
if (RapidSub.canDelegate("button6_click")) return b4i_main.remoteMe.runUserSub(false, "main","button6_click");
RemoteObject _items = RemoteObject.declareNull("B4IMap");
RemoteObject _content = RemoteObject.createImmutable("");
RemoteObject _key = RemoteObject.createImmutable("");
 BA.debugLineNum = 82;BA.debugLine="Sub Button6_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 83;BA.debugLine="Dim items As Map";
Debug.ShouldStop(262144);
_items = RemoteObject.createNew("B4IMap");Debug.locals.put("items", _items);
 BA.debugLineNum = 84;BA.debugLine="Dim content As String = \"\"";
Debug.ShouldStop(524288);
_content = BA.ObjectToString("");Debug.locals.put("content", _content);Debug.locals.put("content", _content);
 BA.debugLineNum = 85;BA.debugLine="If File.Exists(File.DirDocuments, \"list.txt\") Then";
Debug.ShouldStop(1048576);
if (b4i_main.__c.runMethod(false,"File").runMethod(true,"Exists::",(Object)(b4i_main.__c.runMethod(false,"File").runMethod(true,"DirDocuments")),(Object)(BA.ObjectToString("list.txt"))).getBoolean()) { 
 BA.debugLineNum = 86;BA.debugLine="items = File.ReadMap(File.DirDocuments, \"map.txt\")";
Debug.ShouldStop(2097152);
_items = b4i_main.__c.runMethod(false,"File").runMethod(false,"ReadMap::",(Object)(b4i_main.__c.runMethod(false,"File").runMethod(true,"DirDocuments")),(Object)(BA.ObjectToString("map.txt")));Debug.locals.put("items", _items);
 BA.debugLineNum = 87;BA.debugLine="For Each key As String In items.Keys";
Debug.ShouldStop(4194304);
RemoteObject group66 = _items.runMethod(false,"Keys");
int groupLen66 = group66.runMethod(true,"Size").<Integer>get();
for (int index66 = 0;index66 < groupLen66 ;index66++){
_key = BA.ObjectToString(group66.runMethod(false,"Get:",index66));Debug.locals.put("key", _key);
Debug.locals.put("key", _key);
 BA.debugLineNum = 88;BA.debugLine="content = content & key & \"-\" & items.Get(key) & CRLF";
Debug.ShouldStop(8388608);
_content = RemoteObject.concat(_content,_key,RemoteObject.createImmutable("-"),_items.runMethod(false,"Get:",(Object)((_key))),b4i_main.__c.runMethod(true,"CRLF"));Debug.locals.put("content", _content);
 }
Debug.locals.put("key", _key);
;
 BA.debugLineNum = 90;BA.debugLine="lblOutput.Text = content";
Debug.ShouldStop(33554432);
b4i_main._lbloutput.runMethod(true,"setText:",_content);
 }else {
 BA.debugLineNum = 92;BA.debugLine="lblOutput.Text = \"檔案：map.txt不存在...\"";
Debug.ShouldStop(134217728);
b4i_main._lbloutput.runMethod(true,"setText:",BA.ObjectToString("檔案：map.txt不存在..."));
 };
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("Page1_Resize (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,26);
if (RapidSub.canDelegate("page1_resize")) return b4i_main.remoteMe.runUserSub(false, "main","page1_resize", _width, _height);
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 26;BA.debugLine="Private Sub Page1_Resize(Width As Int, Height As Int)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 28;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}