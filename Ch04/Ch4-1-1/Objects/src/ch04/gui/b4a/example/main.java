package ch04.gui.b4a.example;

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
			processBA = new BA(this.getApplicationContext(), null, null, "ch04.gui.b4a.example", "ch04.gui.b4a.example.main");
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
		activityBA = new BA(this, layout, processBA, "ch04.gui.b4a.example", "ch04.gui.b4a.example.main");
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
 //BA.debugLineNum = 27;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 29;BA.debugLine="Activity.LoadLayout(\"Main\")";
mostCurrent._activity.LoadLayout("Main",mostCurrent.activityBA);
 //BA.debugLineNum = 30;BA.debugLine="Activity.Title = \"B4A內建物件\"";
mostCurrent._activity.setTitle((Object)("B4A內建物件"));
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 37;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 33;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return "";
}
public static String  _button1_click() throws Exception{
String _out = "";
String _str = "";
boolean _b = false;
int _index = 0;
String _str1 = "";
String _str2 = "";
String _str3 = "";
char _c = '\0';
 //BA.debugLineNum = 41;BA.debugLine="Sub Button1_Click";
 //BA.debugLineNum = 42;BA.debugLine="Dim out = \"\", str As String";
_out = "";
_str = "";
 //BA.debugLineNum = 43;BA.debugLine="Dim b As Boolean, index As Int";
_b = false;
_index = 0;
 //BA.debugLineNum = 44;BA.debugLine="Dim str1, str2, str3 As String   ' 變數宣告";
_str1 = "";
_str2 = "";
_str3 = "";
 //BA.debugLineNum = 45;BA.debugLine="str1 = \"程式設計\"";
_str1 = "程式設計";
 //BA.debugLineNum = 46;BA.debugLine="str2 = \"Programming\"";
_str2 = "Programming";
 //BA.debugLineNum = 47;BA.debugLine="str3 = \" Joe, Jane, Mary, Tom \"";
_str3 = " Joe, Jane, Mary, Tom ";
 //BA.debugLineNum = 49;BA.debugLine="out = out & \"str1.Length: \" & str1.Length & CRLF";
_out = _out+"str1.Length: "+BA.NumberToString(_str1.length())+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 50;BA.debugLine="str = str2.ToLowerCase()";
_str = _str2.toLowerCase();
 //BA.debugLineNum = 51;BA.debugLine="out = out & \"str2.ToLowerCase(): \" & str & CRLF";
_out = _out+"str2.ToLowerCase(): "+_str+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 52;BA.debugLine="str = str2.ToUpperCase()";
_str = _str2.toUpperCase();
 //BA.debugLineNum = 53;BA.debugLine="out = out & \"str2.ToUpperCase(): \" & str & CRLF";
_out = _out+"str2.ToUpperCase(): "+_str+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 54;BA.debugLine="str = str3.Trim()";
_str = _str3.trim();
 //BA.debugLineNum = 55;BA.debugLine="out = out & \"str3.Trim(): \" & str & _                 \"(\" & str.Length & \")\" & CRLF";
_out = _out+"str3.Trim(): "+_str+"("+BA.NumberToString(_str.length())+")"+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 58;BA.debugLine="str = str3.Replace(\",\", \";\")";
_str = _str3.replace(",",";");
 //BA.debugLineNum = 59;BA.debugLine="out = out & \"str3.Replace(): \" & str & CRLF";
_out = _out+"str3.Replace(): "+_str+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 61;BA.debugLine="index = str2.CompareTo(\"programming\")";
_index = _str2.compareTo("programming");
 //BA.debugLineNum = 62;BA.debugLine="out = out & \"str2.CompareTo(): \" & index & CRLF";
_out = _out+"str2.CompareTo(): "+BA.NumberToString(_index)+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 63;BA.debugLine="index = str2.CompareTo(\"Programming\")";
_index = _str2.compareTo("Programming");
 //BA.debugLineNum = 64;BA.debugLine="out = out & \"str2.CompareTo(): \" & index & CRLF";
_out = _out+"str2.CompareTo(): "+BA.NumberToString(_index)+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 65;BA.debugLine="b = str2.StartsWith(\"Pro\")";
_b = _str2.startsWith("Pro");
 //BA.debugLineNum = 66;BA.debugLine="out = out & \"str2.StartsWith(): \" & b & CRLF";
_out = _out+"str2.StartsWith(): "+String.valueOf(_b)+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 67;BA.debugLine="b = str1.EndsWith(\"設計\")";
_b = _str1.endsWith("設計");
 //BA.debugLineNum = 68;BA.debugLine="out = out & \"str1.EndsWith(): \" & b & CRLF";
_out = _out+"str1.EndsWith(): "+String.valueOf(_b)+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 69;BA.debugLine="b = str2.EqualsIgnoreCase(\"programming\")";
_b = _str2.equalsIgnoreCase("programming");
 //BA.debugLineNum = 70;BA.debugLine="out = out & \"str2.EqualsIgnoreCase(): \" & b & CRLF";
_out = _out+"str2.EqualsIgnoreCase(): "+String.valueOf(_b)+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 72;BA.debugLine="Dim c As Char";
_c = '\0';
 //BA.debugLineNum = 73;BA.debugLine="c = str2.CharAt(2)";
_c = _str2.charAt((int)(2));
 //BA.debugLineNum = 74;BA.debugLine="out = out & \"str2.CharAt(2): \" & c & CRLF";
_out = _out+"str2.CharAt(2): "+String.valueOf(_c)+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 75;BA.debugLine="b = str2.Contains(\"gram\")";
_b = _str2.contains("gram");
 //BA.debugLineNum = 76;BA.debugLine="out = out & \"str2.Contains(): \" & b & CRLF";
_out = _out+"str2.Contains(): "+String.valueOf(_b)+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 77;BA.debugLine="index = str2.IndexOf(\"gram\")";
_index = _str2.indexOf("gram");
 //BA.debugLineNum = 78;BA.debugLine="out = out & \"str2.IndexOf(): \" & index & CRLF";
_out = _out+"str2.IndexOf(): "+BA.NumberToString(_index)+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 79;BA.debugLine="index = str2.IndexOf2(\"gram\", 2)";
_index = _str2.indexOf("gram",(int)(2));
 //BA.debugLineNum = 80;BA.debugLine="out = out & \"str2.IndexOf2(): \" & index & CRLF";
_out = _out+"str2.IndexOf2(): "+BA.NumberToString(_index)+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 81;BA.debugLine="index = str2.LastIndexOf(\"gram\")";
_index = _str2.lastIndexOf("gram");
 //BA.debugLineNum = 82;BA.debugLine="out = out & \"str2.LastIndexOf(): \" & index & CRLF";
_out = _out+"str2.LastIndexOf(): "+BA.NumberToString(_index)+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 84;BA.debugLine="str = str2.SubString(3)";
_str = _str2.substring((int)(3));
 //BA.debugLineNum = 85;BA.debugLine="out = out & \"str2.Substring(): \" & str & CRLF";
_out = _out+"str2.Substring(): "+_str+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 86;BA.debugLine="str = str1.SubString(3)";
_str = _str1.substring((int)(3));
 //BA.debugLineNum = 87;BA.debugLine="out = out & \"str2.Substring(): \" & str & CRLF";
_out = _out+"str2.Substring(): "+_str+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 88;BA.debugLine="str = str2.SubString2(3, 5)";
_str = _str2.substring((int)(3),(int)(5));
 //BA.debugLineNum = 89;BA.debugLine="out = out & \"str2.Substring2(): \" & str & CRLF";
_out = _out+"str2.Substring2(): "+_str+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 90;BA.debugLine="lblOutput.Text = out";
mostCurrent._lbloutput.setText((Object)(_out));
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 24;BA.debugLine="Dim lblOutput As Label";
mostCurrent._lbloutput = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
}
