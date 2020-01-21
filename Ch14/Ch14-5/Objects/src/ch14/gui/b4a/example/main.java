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
			processBA = new BA(this.getApplicationContext(), null, null, "ch14.gui.b4a.example", "ch14.gui.b4a.example.main");
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

public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.sql.SQL _sql1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtid = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtnewprice = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtprice = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtsql = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edttitle = null;
public anywheresoftware.b4a.objects.ListViewWrapper _lsvoutput = null;
public ch14.gui.b4a.example.dbutils _dbutils = null;
public ch14.gui.b4a.example.webview _webview = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (webview.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
String _dbfiledir = "";
 //BA.debugLineNum = 28;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 29;BA.debugLine="Dim DBFileDir As String = File.DirDefaultExternal";
_dbfiledir = anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal();
 //BA.debugLineNum = 30;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
 //BA.debugLineNum = 31;BA.debugLine="If File.Exists(File.DirDefaultExternal, \"MyBooks.sqlite\") = False Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"MyBooks.sqlite")==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 32;BA.debugLine="DBFileDir = DBUtils.CopyDBFromAssets(\"MyBooks.sqlite\")";
_dbfiledir = mostCurrent._dbutils._copydbfromassets(mostCurrent.activityBA,"MyBooks.sqlite");
 };
 //BA.debugLineNum = 34;BA.debugLine="SQL1.Initialize(DBFileDir, \"MyBooks.sqlite\", True)";
_sql1.Initialize(_dbfiledir,"MyBooks.sqlite",anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 36;BA.debugLine="Activity.LoadLayout(\"Main\")";
mostCurrent._activity.LoadLayout("Main",mostCurrent.activityBA);
 //BA.debugLineNum = 37;BA.debugLine="Activity.Title = \"行動圖書館II\"";
mostCurrent._activity.setTitle((Object)("行動圖書館II"));
 //BA.debugLineNum = 38;BA.debugLine="edtId.Text = \"M0003\"";
mostCurrent._edtid.setText((Object)("M0003"));
 //BA.debugLineNum = 39;BA.debugLine="edtTitle.Text = \"PHP+MySQL與jQuery Mobile跨行動裝置網站開發\"";
mostCurrent._edttitle.setText((Object)("PHP+MySQL與jQuery Mobile跨行動裝置網站開發"));
 //BA.debugLineNum = 40;BA.debugLine="edtPrice.Text = \"560\"";
mostCurrent._edtprice.setText((Object)("560"));
 //BA.debugLineNum = 41;BA.debugLine="edtNewPrice.Text = \"580\"";
mostCurrent._edtnewprice.setText((Object)("580"));
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 48;BA.debugLine="Sub Activity_Pause(UserClosed As Boolean)";
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 44;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 46;BA.debugLine="End Sub";
return "";
}
public static String  _button1_click() throws Exception{
anywheresoftware.b4a.objects.collections.List _record = null;
anywheresoftware.b4a.objects.collections.Map _fd = null;
 //BA.debugLineNum = 52;BA.debugLine="Sub Button1_Click";
 //BA.debugLineNum = 53;BA.debugLine="Dim record As List";
_record = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 54;BA.debugLine="Dim fd As Map";
_fd = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 55;BA.debugLine="record.Initialize()";
_record.Initialize();
 //BA.debugLineNum = 56;BA.debugLine="fd.Initialize()";
_fd.Initialize();
 //BA.debugLineNum = 57;BA.debugLine="fd.Put(\"id\", edtId.Text)";
_fd.Put((Object)("id"),(Object)(mostCurrent._edtid.getText()));
 //BA.debugLineNum = 58;BA.debugLine="fd.Put(\"title\", edtTitle.Text)";
_fd.Put((Object)("title"),(Object)(mostCurrent._edttitle.getText()));
 //BA.debugLineNum = 59;BA.debugLine="fd.Put(\"price\", edtPrice.Text)";
_fd.Put((Object)("price"),(Object)(mostCurrent._edtprice.getText()));
 //BA.debugLineNum = 60;BA.debugLine="record.Add(fd)";
_record.Add((Object)(_fd.getObject()));
 //BA.debugLineNum = 61;BA.debugLine="DBUtils.InsertMaps(SQL1, \"Books\", record)";
mostCurrent._dbutils._insertmaps(mostCurrent.activityBA,_sql1,"Books",_record);
 //BA.debugLineNum = 62;BA.debugLine="ToastMessageShow(\"新增一筆圖書記錄...\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("新增一筆圖書記錄...",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
return "";
}
public static String  _button2_click() throws Exception{
anywheresoftware.b4a.objects.collections.Map _key = null;
 //BA.debugLineNum = 65;BA.debugLine="Sub Button2_Click";
 //BA.debugLineNum = 66;BA.debugLine="Dim key As Map";
_key = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 67;BA.debugLine="key.Initialize()";
_key.Initialize();
 //BA.debugLineNum = 68;BA.debugLine="key.Put(\"id\", edtId.Text)";
_key.Put((Object)("id"),(Object)(mostCurrent._edtid.getText()));
 //BA.debugLineNum = 69;BA.debugLine="DBUtils.UpdateRecord(SQL1, \"Books\", \"price\", edtNewPrice.Text, key)";
mostCurrent._dbutils._updaterecord(mostCurrent.activityBA,_sql1,"Books","price",(Object)(mostCurrent._edtnewprice.getText()),_key);
 //BA.debugLineNum = 70;BA.debugLine="ToastMessageShow(\"更新一筆圖書記錄...\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("更新一筆圖書記錄...",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 71;BA.debugLine="End Sub";
return "";
}
public static String  _button3_click() throws Exception{
anywheresoftware.b4a.objects.collections.Map _key = null;
 //BA.debugLineNum = 73;BA.debugLine="Sub Button3_Click";
 //BA.debugLineNum = 74;BA.debugLine="Dim key As Map";
_key = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 75;BA.debugLine="key.Initialize()";
_key.Initialize();
 //BA.debugLineNum = 76;BA.debugLine="key.Put(\"id\", edtId.Text)";
_key.Put((Object)("id"),(Object)(mostCurrent._edtid.getText()));
 //BA.debugLineNum = 77;BA.debugLine="DBUtils.DeleteRecord(SQL1, \"Books\", key)";
mostCurrent._dbutils._deleterecord(mostCurrent.activityBA,_sql1,"Books",_key);
 //BA.debugLineNum = 78;BA.debugLine="ToastMessageShow(\"刪除一筆圖書記錄...\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("刪除一筆圖書記錄...",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return "";
}
public static String  _button4_click() throws Exception{
 //BA.debugLineNum = 81;BA.debugLine="Sub Button4_Click";
 //BA.debugLineNum = 82;BA.debugLine="StartActivity(WebView)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._webview.getObject()));
 //BA.debugLineNum = 83;BA.debugLine="End Sub";
return "";
}
public static String  _button5_click() throws Exception{
 //BA.debugLineNum = 85;BA.debugLine="Sub Button5_Click";
 //BA.debugLineNum = 86;BA.debugLine="queryDB(edtSQL.Text)";
_querydb(mostCurrent._edtsql.getText());
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
dbutils._process_globals();
webview._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _globals() throws Exception{
 //BA.debugLineNum = 19;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 20;BA.debugLine="Dim edtId As EditText";
mostCurrent._edtid = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Dim edtNewPrice As EditText";
mostCurrent._edtnewprice = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Dim edtPrice As EditText";
mostCurrent._edtprice = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Dim edtSQL As EditText";
mostCurrent._edtsql = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Dim edtTitle As EditText";
mostCurrent._edttitle = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Dim lsvOutput As ListView";
mostCurrent._lsvoutput = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 16;BA.debugLine="Dim SQL1 As SQL";
_sql1 = new anywheresoftware.b4a.sql.SQL();
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public static String  _querydb(String _strsql) throws Exception{
 //BA.debugLineNum = 89;BA.debugLine="Sub queryDB(strSQL As String)";
 //BA.debugLineNum = 90;BA.debugLine="lsvOutput.TwoLinesLayout.ItemHeight = 50dip";
mostCurrent._lsvoutput.getTwoLinesLayout().setItemHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
 //BA.debugLineNum = 91;BA.debugLine="lsvOutput.TwoLinesLayout.Label.TextSize = 10";
mostCurrent._lsvoutput.getTwoLinesLayout().Label.setTextSize((float) (10));
 //BA.debugLineNum = 92;BA.debugLine="lsvOutput.TwoLinesLayout.SecondLabel.TextSize = 10";
mostCurrent._lsvoutput.getTwoLinesLayout().SecondLabel.setTextSize((float) (10));
 //BA.debugLineNum = 93;BA.debugLine="DBUtils.ExecuteListView(SQL1, strSQL, Null, 0, lsvOutput, True)";
mostCurrent._dbutils._executelistview(mostCurrent.activityBA,_sql1,_strsql,(String[])(anywheresoftware.b4a.keywords.Common.Null),(int) (0),mostCurrent._lsvoutput,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 94;BA.debugLine="End Sub";
return "";
}
}