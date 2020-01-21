package ch14.gui.b4a.example;

import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isFirst) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "ch14.gui.b4a.example", "ch14.gui.b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		mostCurrent = this;
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
		BA.handler.postDelayed(new WaitForLayout(), 5);

	}
	private static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "ch14.gui.b4a.example", "ch14.gui.b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "ch14.gui.b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
//        try {
//            if (processBA.subExists("activity_actionbarhomeclick")) {
//                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
//                    getClass().getMethod("getActionBar").invoke(this), true);
//                BA.Log("adding event");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
		return true;
	}   
// @Override
// public boolean onOptionsItemSelected(android.view.MenuItem item) {
//    if (item.getItemId() == 16908332) {
//        processBA.raiseEvent(null, "activity_actionbarhomeclick");
//        return true;
//    }
//    else
//        return super.onOptionsItemSelected(item); 
//}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEvent(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null) //workaround for emulator bug (Issue 2423)
            return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
			if (mostCurrent == null || mostCurrent != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
		    processBA.raiseEvent(mostCurrent._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = main.mostCurrent.processBA.sharedProcessBA.activityBA.get();
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.sql.SQL _sql1 = null;
public static anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtid = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtnewprice = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtprice = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtsql = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edttitle = null;
public anywheresoftware.b4a.objects.ListViewWrapper _lsvoutput = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="If File.Exists(File.DirInternal, \"MyBooks.sqlite\") = False Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"MyBooks.sqlite")==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="File.Copy(File.DirAssets, \"MyBooks.sqlite\",File.DirInternal, \"MyBooks.sqlite\")";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"MyBooks.sqlite",anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"MyBooks.sqlite");
 };
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="If SQL1.IsInitialized() = False Then";
if (_sql1.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="SQL1.Initialize(File.DirInternal, \"MyBooks.sqlite\", False)";
_sql1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"MyBooks.sqlite",anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="Activity.LoadLayout(\"Main\")";
mostCurrent._activity.LoadLayout("Main",mostCurrent.activityBA);
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="Activity.Title = \"行動圖書館\"";
mostCurrent._activity.setTitle((Object)("行動圖書館"));
RDebugUtils.currentLine=131081;
 //BA.debugLineNum = 131081;BA.debugLine="edtId.Text = \"M0003\"";
mostCurrent._edtid.setText((Object)("M0003"));
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="edtTitle.Text = \"PHP+MySQL與jQuery Mobile跨行動裝置網站開發\"";
mostCurrent._edttitle.setText((Object)("PHP+MySQL與jQuery Mobile跨行動裝置網站開發"));
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="edtPrice.Text = \"560\"";
mostCurrent._edtprice.setText((Object)("560"));
RDebugUtils.currentLine=131084;
 //BA.debugLineNum = 131084;BA.debugLine="edtNewPrice.Text = \"580\"";
mostCurrent._edtnewprice.setText((Object)("580"));
RDebugUtils.currentLine=131085;
 //BA.debugLineNum = 131085;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause(UserClosed As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
public static String  _button1_click() throws Exception{
RDebugUtils.currentModule="main";
String _bid = "";
String _title = "";
int _price = 0;
String _strsql = "";
int _dbchange = 0;
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub Button1_Click";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="Dim bid As String = edtId.Text";
_bid = mostCurrent._edtid.getText();
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="Dim title As String = edtTitle.Text";
_title = mostCurrent._edttitle.getText();
RDebugUtils.currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="Dim price As Int = edtPrice.Text";
_price = (int)(Double.parseDouble(mostCurrent._edtprice.getText()));
RDebugUtils.currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="Dim strSQL As String";
_strsql = "";
RDebugUtils.currentLine=327685;
 //BA.debugLineNum = 327685;BA.debugLine="strSQL = \"INSERT INTO Books(id,title,price)\" & _              \"VALUES('\" & bid & \"','\" & title & \"',\" & price & \")\"";
_strsql = "INSERT INTO Books(id,title,price)"+"VALUES('"+_bid+"','"+_title+"',"+BA.NumberToString(_price)+")";
RDebugUtils.currentLine=327687;
 //BA.debugLineNum = 327687;BA.debugLine="SQL1.ExecNonQuery(strSQL)";
_sql1.ExecNonQuery(_strsql);
RDebugUtils.currentLine=327688;
 //BA.debugLineNum = 327688;BA.debugLine="Dim dbChange As Int";
_dbchange = 0;
RDebugUtils.currentLine=327689;
 //BA.debugLineNum = 327689;BA.debugLine="dbChange = SQL1.ExecQuerySingleResult(\"SELECT changes() FROM Books\")";
_dbchange = (int)(Double.parseDouble(_sql1.ExecQuerySingleResult("SELECT changes() FROM Books")));
RDebugUtils.currentLine=327690;
 //BA.debugLineNum = 327690;BA.debugLine="ToastMessageShow(\"新增圖書記錄: \" & dbChange & \" 筆\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("新增圖書記錄: "+BA.NumberToString(_dbchange)+" 筆",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=327691;
 //BA.debugLineNum = 327691;BA.debugLine="End Sub";
return "";
}
public static String  _button2_click() throws Exception{
RDebugUtils.currentModule="main";
String _bid = "";
String _strsql = "";
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub Button2_Click";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="Dim bid As String = edtId.Text";
_bid = mostCurrent._edtid.getText();
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="Dim strSQL As String";
_strsql = "";
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="strSQL = \"UPDATE Books SET price ='\" & _          edtNewPrice.Text & \"' WHERE id = '\" & bid & \"'\"";
_strsql = "UPDATE Books SET price ='"+mostCurrent._edtnewprice.getText()+"' WHERE id = '"+_bid+"'";
RDebugUtils.currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="SQL1.ExecNonQuery(strSQL)";
_sql1.ExecNonQuery(_strsql);
RDebugUtils.currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="ToastMessageShow(\"更新一筆圖書記錄...\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("更新一筆圖書記錄...",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=393223;
 //BA.debugLineNum = 393223;BA.debugLine="End Sub";
return "";
}
public static String  _button3_click() throws Exception{
RDebugUtils.currentModule="main";
String _bid = "";
String _strsql = "";
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub Button3_Click";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="Dim bid As String = edtId.Text";
_bid = mostCurrent._edtid.getText();
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="Dim strSQL As String";
_strsql = "";
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="strSQL = \"DELETE FROM Books WHERE id = '\" & bid & \"'\"";
_strsql = "DELETE FROM Books WHERE id = '"+_bid+"'";
RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="SQL1.ExecNonQuery(strSQL)";
_sql1.ExecNonQuery(_strsql);
RDebugUtils.currentLine=458757;
 //BA.debugLineNum = 458757;BA.debugLine="ToastMessageShow(\"刪除一筆圖書記錄...\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("刪除一筆圖書記錄...",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=458758;
 //BA.debugLineNum = 458758;BA.debugLine="End Sub";
return "";
}
public static String  _button4_click() throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub Button4_Click";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="queryDB(\"SELECT * FROM Books\")";
_querydb("SELECT * FROM Books");
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="End Sub";
return "";
}
public static String  _querydb(String _strsql) throws Exception{
RDebugUtils.currentModule="main";
int _i = 0;
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub queryDB(strSQL As String)";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="lsvOutput.Clear()";
mostCurrent._lsvoutput.Clear();
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="cursor1 = SQL1.ExecQuery(strSQL)";
_cursor1.setObject((android.database.Cursor)(_sql1.ExecQuery(_strsql)));
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="lsvOutput.SingleLineLayout.Label.TextSize = 10";
mostCurrent._lsvoutput.getSingleLineLayout().Label.setTextSize((float) (10));
RDebugUtils.currentLine=655364;
 //BA.debugLineNum = 655364;BA.debugLine="lsvOutput.SingleLineLayout.ItemHeight = 25dip";
mostCurrent._lsvoutput.getSingleLineLayout().setItemHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)));
RDebugUtils.currentLine=655365;
 //BA.debugLineNum = 655365;BA.debugLine="For i = 0 To cursor1.RowCount - 1";
{
final int step66 = 1;
final int limit66 = (int) (_cursor1.getRowCount()-1);
for (_i = (int) (0); (step66 > 0 && _i <= limit66) || (step66 < 0 && _i >= limit66); _i = ((int)(0 + _i + step66))) {
RDebugUtils.currentLine=655366;
 //BA.debugLineNum = 655366;BA.debugLine="cursor1.Position = i";
_cursor1.setPosition(_i);
RDebugUtils.currentLine=655367;
 //BA.debugLineNum = 655367;BA.debugLine="lsvOutput.AddSingleLine(cursor1.GetString(\"id\") & _                       \" : \" & cursor1.GetString(\"title\")& _                       \" \" & cursor1.GetLong(\"price\"))";
mostCurrent._lsvoutput.AddSingleLine(_cursor1.GetString("id")+" : "+_cursor1.GetString("title")+" "+BA.NumberToString(_cursor1.GetLong("price")));
 }
};
RDebugUtils.currentLine=655371;
 //BA.debugLineNum = 655371;BA.debugLine="End Sub";
return "";
}
public static String  _button5_click() throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub Button5_Click";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="queryDB(edtSQL.Text)";
_querydb(mostCurrent._edtsql.getText());
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="End Sub";
return "";
}
}