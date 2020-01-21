package ch14.gui.b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,29);
if (RapidSub.canDelegate("activity_create")) return main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 30;BA.debugLine="If File.Exists(File.DirInternal, \"MyBooks.sqlite\") = False Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("MyBooks.sqlite"))),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 31;BA.debugLine="File.Copy(File.DirAssets, \"MyBooks.sqlite\",File.DirInternal, \"MyBooks.sqlite\")";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("MyBooks.sqlite")),(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("MyBooks.sqlite")));
 };
 BA.debugLineNum = 33;BA.debugLine="If SQL1.IsInitialized() = False Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",main._sql1.runMethod(true,"IsInitialized"),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 34;BA.debugLine="SQL1.Initialize(File.DirInternal, \"MyBooks.sqlite\", False)";
Debug.ShouldStop(2);
main._sql1.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("MyBooks.sqlite")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 36;BA.debugLine="Activity.LoadLayout(\"Main\")";
Debug.ShouldStop(8);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(BA.ObjectToString("Main")),main.mostCurrent.activityBA);
 BA.debugLineNum = 37;BA.debugLine="Activity.Title = \"行動圖書館\"";
Debug.ShouldStop(16);
main.mostCurrent._activity.runMethod(false,"setTitle",RemoteObject.createImmutable(("行動圖書館")));
 BA.debugLineNum = 38;BA.debugLine="edtId.Text = \"M0003\"";
Debug.ShouldStop(32);
main.mostCurrent._edtid.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("M0003")));
 BA.debugLineNum = 39;BA.debugLine="edtTitle.Text = \"PHP+MySQL與jQuery Mobile跨行動裝置網站開發\"";
Debug.ShouldStop(64);
main.mostCurrent._edttitle.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("PHP+MySQL與jQuery Mobile跨行動裝置網站開發")));
 BA.debugLineNum = 40;BA.debugLine="edtPrice.Text = \"560\"";
Debug.ShouldStop(128);
main.mostCurrent._edtprice.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("560")));
 BA.debugLineNum = 41;BA.debugLine="edtNewPrice.Text = \"580\"";
Debug.ShouldStop(256);
main.mostCurrent._edtnewprice.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("580")));
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,48);
if (RapidSub.canDelegate("activity_pause")) return main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 48;BA.debugLine="Sub Activity_Pause(UserClosed As Boolean)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 50;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,44);
if (RapidSub.canDelegate("activity_resume")) return main.remoteMe.runUserSub(false, "main","activity_resume");
 BA.debugLineNum = 44;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2048);
 BA.debugLineNum = 46;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button1_click() throws Exception{
try {
		Debug.PushSubsStack("Button1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,52);
if (RapidSub.canDelegate("button1_click")) return main.remoteMe.runUserSub(false, "main","button1_click");
RemoteObject _bid = RemoteObject.createImmutable("");
RemoteObject _title = RemoteObject.createImmutable("");
RemoteObject _price = RemoteObject.createImmutable(0);
RemoteObject _strsql = RemoteObject.createImmutable("");
RemoteObject _dbchange = RemoteObject.createImmutable(0);
 BA.debugLineNum = 52;BA.debugLine="Sub Button1_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 53;BA.debugLine="Dim bid As String = edtId.Text";
Debug.ShouldStop(1048576);
_bid = main.mostCurrent._edtid.runMethod(true,"getText");Debug.locals.put("bid", _bid);Debug.locals.put("bid", _bid);
 BA.debugLineNum = 54;BA.debugLine="Dim title As String = edtTitle.Text";
Debug.ShouldStop(2097152);
_title = main.mostCurrent._edttitle.runMethod(true,"getText");Debug.locals.put("title", _title);Debug.locals.put("title", _title);
 BA.debugLineNum = 55;BA.debugLine="Dim price As Int = edtPrice.Text";
Debug.ShouldStop(4194304);
_price = BA.numberCast(int.class, main.mostCurrent._edtprice.runMethod(true,"getText"));Debug.locals.put("price", _price);Debug.locals.put("price", _price);
 BA.debugLineNum = 56;BA.debugLine="Dim strSQL As String";
Debug.ShouldStop(8388608);
_strsql = RemoteObject.createImmutable("");Debug.locals.put("strSQL", _strsql);
 BA.debugLineNum = 57;BA.debugLine="strSQL = \"INSERT INTO Books(id,title,price)\" & _              \"VALUES('\" & bid & \"','\" & title & \"',\" & price & \")\"";
Debug.ShouldStop(16777216);
_strsql = RemoteObject.concat(RemoteObject.createImmutable("INSERT INTO Books(id,title,price)"),RemoteObject.createImmutable("VALUES('"),_bid,RemoteObject.createImmutable("','"),_title,RemoteObject.createImmutable("',"),_price,RemoteObject.createImmutable(")"));Debug.locals.put("strSQL", _strsql);
 BA.debugLineNum = 59;BA.debugLine="SQL1.ExecNonQuery(strSQL)";
Debug.ShouldStop(67108864);
main._sql1.runVoidMethod ("ExecNonQuery",(Object)(_strsql));
 BA.debugLineNum = 60;BA.debugLine="Dim dbChange As Int";
Debug.ShouldStop(134217728);
_dbchange = RemoteObject.createImmutable(0);Debug.locals.put("dbChange", _dbchange);
 BA.debugLineNum = 61;BA.debugLine="dbChange = SQL1.ExecQuerySingleResult(\"SELECT changes() FROM Books\")";
Debug.ShouldStop(268435456);
_dbchange = BA.numberCast(int.class, main._sql1.runMethod(true,"ExecQuerySingleResult",(Object)(BA.ObjectToString("SELECT changes() FROM Books"))));Debug.locals.put("dbChange", _dbchange);
 BA.debugLineNum = 62;BA.debugLine="ToastMessageShow(\"新增圖書記錄: \" & dbChange & \" 筆\", False)";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(RemoteObject.concat(RemoteObject.createImmutable("新增圖書記錄: "),_dbchange,RemoteObject.createImmutable(" 筆"))),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 63;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button2_click() throws Exception{
try {
		Debug.PushSubsStack("Button2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,65);
if (RapidSub.canDelegate("button2_click")) return main.remoteMe.runUserSub(false, "main","button2_click");
RemoteObject _bid = RemoteObject.createImmutable("");
RemoteObject _strsql = RemoteObject.createImmutable("");
 BA.debugLineNum = 65;BA.debugLine="Sub Button2_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 66;BA.debugLine="Dim bid As String = edtId.Text";
Debug.ShouldStop(2);
_bid = main.mostCurrent._edtid.runMethod(true,"getText");Debug.locals.put("bid", _bid);Debug.locals.put("bid", _bid);
 BA.debugLineNum = 67;BA.debugLine="Dim strSQL As String";
Debug.ShouldStop(4);
_strsql = RemoteObject.createImmutable("");Debug.locals.put("strSQL", _strsql);
 BA.debugLineNum = 68;BA.debugLine="strSQL = \"UPDATE Books SET price ='\" & _          edtNewPrice.Text & \"' WHERE id = '\" & bid & \"'\"";
Debug.ShouldStop(8);
_strsql = RemoteObject.concat(RemoteObject.createImmutable("UPDATE Books SET price ='"),main.mostCurrent._edtnewprice.runMethod(true,"getText"),RemoteObject.createImmutable("' WHERE id = '"),_bid,RemoteObject.createImmutable("'"));Debug.locals.put("strSQL", _strsql);
 BA.debugLineNum = 70;BA.debugLine="SQL1.ExecNonQuery(strSQL)";
Debug.ShouldStop(32);
main._sql1.runVoidMethod ("ExecNonQuery",(Object)(_strsql));
 BA.debugLineNum = 71;BA.debugLine="ToastMessageShow(\"更新一筆圖書記錄...\", False)";
Debug.ShouldStop(64);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("更新一筆圖書記錄...")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button3_click() throws Exception{
try {
		Debug.PushSubsStack("Button3_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,74);
if (RapidSub.canDelegate("button3_click")) return main.remoteMe.runUserSub(false, "main","button3_click");
RemoteObject _bid = RemoteObject.createImmutable("");
RemoteObject _strsql = RemoteObject.createImmutable("");
 BA.debugLineNum = 74;BA.debugLine="Sub Button3_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 75;BA.debugLine="Dim bid As String = edtId.Text";
Debug.ShouldStop(1024);
_bid = main.mostCurrent._edtid.runMethod(true,"getText");Debug.locals.put("bid", _bid);Debug.locals.put("bid", _bid);
 BA.debugLineNum = 76;BA.debugLine="Dim strSQL As String";
Debug.ShouldStop(2048);
_strsql = RemoteObject.createImmutable("");Debug.locals.put("strSQL", _strsql);
 BA.debugLineNum = 77;BA.debugLine="strSQL = \"DELETE FROM Books WHERE id = '\" & bid & \"'\"";
Debug.ShouldStop(4096);
_strsql = RemoteObject.concat(RemoteObject.createImmutable("DELETE FROM Books WHERE id = '"),_bid,RemoteObject.createImmutable("'"));Debug.locals.put("strSQL", _strsql);
 BA.debugLineNum = 78;BA.debugLine="SQL1.ExecNonQuery(strSQL)";
Debug.ShouldStop(8192);
main._sql1.runVoidMethod ("ExecNonQuery",(Object)(_strsql));
 BA.debugLineNum = 79;BA.debugLine="ToastMessageShow(\"刪除一筆圖書記錄...\", False)";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("刪除一筆圖書記錄...")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 80;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button4_click() throws Exception{
try {
		Debug.PushSubsStack("Button4_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,82);
if (RapidSub.canDelegate("button4_click")) return main.remoteMe.runUserSub(false, "main","button4_click");
 BA.debugLineNum = 82;BA.debugLine="Sub Button4_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 83;BA.debugLine="queryDB(\"SELECT * FROM Books\")";
Debug.ShouldStop(262144);
_querydb(BA.ObjectToString("SELECT * FROM Books"));
 BA.debugLineNum = 84;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button5_click() throws Exception{
try {
		Debug.PushSubsStack("Button5_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,86);
if (RapidSub.canDelegate("button5_click")) return main.remoteMe.runUserSub(false, "main","button5_click");
 BA.debugLineNum = 86;BA.debugLine="Sub Button5_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 87;BA.debugLine="queryDB(edtSQL.Text)";
Debug.ShouldStop(4194304);
_querydb(main.mostCurrent._edtsql.runMethod(true,"getText"));
 BA.debugLineNum = 88;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("ch14.gui.b4a.example.main");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 20;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 21;BA.debugLine="Dim edtId As EditText";
main.mostCurrent._edtid = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Dim edtNewPrice As EditText";
main.mostCurrent._edtnewprice = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Dim edtPrice As EditText";
main.mostCurrent._edtprice = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Dim edtSQL As EditText";
main.mostCurrent._edtsql = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Dim edtTitle As EditText";
main.mostCurrent._edttitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Dim lsvOutput As ListView";
main.mostCurrent._lsvoutput = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 16;BA.debugLine="Dim SQL1 As SQL";
main._sql1 = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 17;BA.debugLine="Dim cursor1 As Cursor";
main._cursor1 = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _querydb(RemoteObject _strsql) throws Exception{
try {
		Debug.PushSubsStack("queryDB (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,90);
if (RapidSub.canDelegate("querydb")) return main.remoteMe.runUserSub(false, "main","querydb", _strsql);
int _i = 0;
Debug.locals.put("strSQL", _strsql);
 BA.debugLineNum = 90;BA.debugLine="Sub queryDB(strSQL As String)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 91;BA.debugLine="lsvOutput.Clear()";
Debug.ShouldStop(67108864);
main.mostCurrent._lsvoutput.runVoidMethod ("Clear");
 BA.debugLineNum = 92;BA.debugLine="cursor1 = SQL1.ExecQuery(strSQL)";
Debug.ShouldStop(134217728);
main._cursor1.setObject(main._sql1.runMethod(false,"ExecQuery",(Object)(_strsql)));
 BA.debugLineNum = 93;BA.debugLine="lsvOutput.SingleLineLayout.Label.TextSize = 10";
Debug.ShouldStop(268435456);
main.mostCurrent._lsvoutput.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setTextSize",BA.numberCast(float.class, 10));
 BA.debugLineNum = 94;BA.debugLine="lsvOutput.SingleLineLayout.ItemHeight = 25dip";
Debug.ShouldStop(536870912);
main.mostCurrent._lsvoutput.runMethod(false,"getSingleLineLayout").runMethod(true,"setItemHeight",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25))));
 BA.debugLineNum = 95;BA.debugLine="For i = 0 To cursor1.RowCount - 1";
Debug.ShouldStop(1073741824);
{
final int step66 = 1;
final int limit66 = RemoteObject.solve(new RemoteObject[] {main._cursor1.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0; (step66 > 0 && _i <= limit66) || (step66 < 0 && _i >= limit66); _i = ((int)(0 + _i + step66))) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 96;BA.debugLine="cursor1.Position = i";
Debug.ShouldStop(-2147483648);
main._cursor1.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 97;BA.debugLine="lsvOutput.AddSingleLine(cursor1.GetString(\"id\") & _                       \" : \" & cursor1.GetString(\"title\")& _                       \" \" & cursor1.GetLong(\"price\"))";
Debug.ShouldStop(1);
main.mostCurrent._lsvoutput.runVoidMethod ("AddSingleLine",(Object)(RemoteObject.concat(main._cursor1.runMethod(true,"GetString",(Object)(BA.ObjectToString("id"))),RemoteObject.createImmutable(" : "),main._cursor1.runMethod(true,"GetString",(Object)(BA.ObjectToString("title"))),RemoteObject.createImmutable(" "),main._cursor1.runMethod(true,"GetLong",(Object)(BA.ObjectToString("price"))))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 101;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
}