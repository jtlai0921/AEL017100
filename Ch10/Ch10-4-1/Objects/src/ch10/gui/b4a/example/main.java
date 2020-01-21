package ch10.gui.b4a.example;

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
			processBA = new BA(this.getApplicationContext(), null, null, "ch10.gui.b4a.example", "ch10.gui.b4a.example.main");
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
		activityBA = new BA(this, layout, processBA, "ch10.gui.b4a.example", "ch10.gui.b4a.example.main");
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
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
		return true;
	}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
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
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true)
				return true;
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
		}
		return super.onKeyDown(keyCode, event);
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
public anywheresoftware.b4a.objects.LabelWrapper _lbloutput = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 25;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 26;BA.debugLine="Activity.LoadLayout(\"Main\")";
mostCurrent._activity.LoadLayout("Main",mostCurrent.activityBA);
 //BA.debugLineNum = 27;BA.debugLine="Activity.Title = \"顯示檔案與資料夾資訊\"";
mostCurrent._activity.setTitle((Object)("顯示檔案與資料夾資訊"));
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 34;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 30;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public static String  _button1_click() throws Exception{
String _out = "";
 //BA.debugLineNum = 38;BA.debugLine="Sub Button1_Click";
 //BA.debugLineNum = 39;BA.debugLine="Dim out As String";
_out = "";
 //BA.debugLineNum = 40;BA.debugLine="out =  \"記憶卡可讀: \" & File.ExternalReadable & CRLF";
_out = "記憶卡可讀: "+String.valueOf(anywheresoftware.b4a.keywords.Common.File.getExternalReadable())+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 41;BA.debugLine="out = out & \"記憶卡可寫: \" & File.ExternalWritable";
_out = _out+"記憶卡可寫: "+String.valueOf(anywheresoftware.b4a.keywords.Common.File.getExternalWritable());
 //BA.debugLineNum = 42;BA.debugLine="lblOutput.Text = out";
mostCurrent._lbloutput.setText((Object)(_out));
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return "";
}
public static String  _button2_click() throws Exception{
String _out = "";
long _d = 0L;
 //BA.debugLineNum = 45;BA.debugLine="Sub Button2_Click";
 //BA.debugLineNum = 46;BA.debugLine="Dim out As String";
_out = "";
 //BA.debugLineNum = 47;BA.debugLine="Dim d As Long";
_d = 0L;
 //BA.debugLineNum = 49;BA.debugLine="If File.Exists(File.DirRootExternal, \"Books.txt\") Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),"Books.txt")) { 
 //BA.debugLineNum = 50;BA.debugLine="out = \"檔名: \" & File.Combine(File.DirRootExternal, \"Books.txt\") & CRLF";
_out = "檔名: "+anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),"Books.txt")+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 51;BA.debugLine="out = out & \"尺寸: \" & File.Size(File.DirRootExternal, \"Books.txt\") & CRLF";
_out = _out+"尺寸: "+BA.NumberToString(anywheresoftware.b4a.keywords.Common.File.Size(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),"Books.txt"))+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 52;BA.debugLine="d = File.LastModified(File.DirRootExternal, \"Books.txt\")";
_d = anywheresoftware.b4a.keywords.Common.File.LastModified(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),"Books.txt");
 //BA.debugLineNum = 53;BA.debugLine="out = out & \"修改日期: \" & DateTime.Date(d)";
_out = _out+"修改日期: "+anywheresoftware.b4a.keywords.Common.DateTime.Date(_d);
 }else {
 //BA.debugLineNum = 55;BA.debugLine="out = \"檔案不存在...\"";
_out = "檔案不存在...";
 };
 //BA.debugLineNum = 57;BA.debugLine="lblOutput.Text = out";
mostCurrent._lbloutput.setText((Object)(_out));
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public static String  _button3_click() throws Exception{
String _out = "";
anywheresoftware.b4a.objects.collections.List _filelist = null;
int _i = 0;
 //BA.debugLineNum = 60;BA.debugLine="Sub Button3_Click  ' 顯示檔案清單";
 //BA.debugLineNum = 61;BA.debugLine="Dim out As String = \"\"";
_out = "";
 //BA.debugLineNum = 62;BA.debugLine="Dim fileList As List";
_filelist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 63;BA.debugLine="fileList = File.ListFiles(File.DirRootExternal)";
_filelist = anywheresoftware.b4a.keywords.Common.File.ListFiles(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal());
 //BA.debugLineNum = 64;BA.debugLine="For i = 0 To fileList.Size - 1";
{
final double step36 = 1;
final double limit36 = (int)(_filelist.getSize()-1);
for (_i = (int)(0); (step36 > 0 && _i <= limit36) || (step36 < 0 && _i >= limit36); _i += step36) {
 //BA.debugLineNum = 66;BA.debugLine="If Not(File.IsDirectory(File.DirRootExternal,fileList.Get(i))) Then";
if (anywheresoftware.b4a.keywords.Common.Not(anywheresoftware.b4a.keywords.Common.File.IsDirectory(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),String.valueOf(_filelist.Get(_i))))) { 
 //BA.debugLineNum = 67;BA.debugLine="out = out & fileList.Get(i) & CRLF";
_out = _out+String.valueOf(_filelist.Get(_i))+anywheresoftware.b4a.keywords.Common.CRLF;
 };
 }
};
 //BA.debugLineNum = 70;BA.debugLine="lblOutput.Text = out";
mostCurrent._lbloutput.setText((Object)(_out));
 //BA.debugLineNum = 71;BA.debugLine="End Sub";
return "";
}
public static String  _button4_click() throws Exception{
String _out = "";
anywheresoftware.b4a.objects.collections.List _filelist = null;
int _i = 0;
 //BA.debugLineNum = 73;BA.debugLine="Sub Button4_Click  ' 顯示目錄清單";
 //BA.debugLineNum = 74;BA.debugLine="Dim out As String = \"\"";
_out = "";
 //BA.debugLineNum = 75;BA.debugLine="Dim fileList As List";
_filelist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 76;BA.debugLine="fileList = File.ListFiles(File.DirRootExternal)";
_filelist = anywheresoftware.b4a.keywords.Common.File.ListFiles(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal());
 //BA.debugLineNum = 77;BA.debugLine="For i = 0 To fileList.Size - 1";
{
final double step47 = 1;
final double limit47 = (int)(_filelist.getSize()-1);
for (_i = (int)(0); (step47 > 0 && _i <= limit47) || (step47 < 0 && _i >= limit47); _i += step47) {
 //BA.debugLineNum = 79;BA.debugLine="If File.IsDirectory(File.DirRootExternal,fileList.Get(i)) Then";
if (anywheresoftware.b4a.keywords.Common.File.IsDirectory(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),String.valueOf(_filelist.Get(_i)))) { 
 //BA.debugLineNum = 80;BA.debugLine="out = out & fileList.Get(i) & CRLF";
_out = _out+String.valueOf(_filelist.Get(_i))+anywheresoftware.b4a.keywords.Common.CRLF;
 };
 }
};
 //BA.debugLineNum = 83;BA.debugLine="lblOutput.Text = out";
mostCurrent._lbloutput.setText((Object)(_out));
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (processGlobalsRun == false) {
	    processGlobalsRun = true;
		try {
		        main._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 22;BA.debugLine="Dim lblOutput As Label";
mostCurrent._lbloutput = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
}
