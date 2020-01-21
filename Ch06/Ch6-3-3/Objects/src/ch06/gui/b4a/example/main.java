package ch06.gui.b4a.example;

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
			processBA = new BA(this.getApplicationContext(), null, null, "ch06.gui.b4a.example", "ch06.gui.b4a.example.main");
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
		activityBA = new BA(this, layout, processBA, "ch06.gui.b4a.example", "ch06.gui.b4a.example.main");
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
public anywheresoftware.b4a.objects.EditTextWrapper _edtheight = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtweight = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbloutput = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblmessage = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 28;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 29;BA.debugLine="Activity.LoadLayout(\"Main\")";
mostCurrent._activity.LoadLayout("Main",mostCurrent.activityBA);
 //BA.debugLineNum = 30;BA.debugLine="Activity.Title = \"BMI計算機\"";
mostCurrent._activity.setTitle((Object)("BMI計算機"));
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
public static String  _bmi() throws Exception{
double _h = 0;
double _w = 0;
 //BA.debugLineNum = 41;BA.debugLine="Sub BMI";
 //BA.debugLineNum = 42;BA.debugLine="Dim h As Double = edtHeight.Text / 100.0";
_h = (double)(Double.parseDouble(mostCurrent._edtheight.getText()))/(double)100.0;
 //BA.debugLineNum = 43;BA.debugLine="Dim w As Double = edtWeight.Text";
_w = (double)(Double.parseDouble(mostCurrent._edtweight.getText()));
 //BA.debugLineNum = 44;BA.debugLine="lblOutput.Text = \"BMI: \" & (w / (h * h))";
mostCurrent._lbloutput.setText((Object)("BMI: "+BA.NumberToString((_w/(double)(_h*_h)))));
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return "";
}
public static String  _edtheight_enterpressed() throws Exception{
 //BA.debugLineNum = 47;BA.debugLine="Sub edtHeight_EnterPressed";
 //BA.debugLineNum = 48;BA.debugLine="lblMessage.Text = \"edtHeight_EnterPressed\"";
mostCurrent._lblmessage.setText((Object)("edtHeight_EnterPressed"));
 //BA.debugLineNum = 49;BA.debugLine="If edtHeight.Text.Length > 0 Then";
if (mostCurrent._edtheight.getText().length()>0) { 
 //BA.debugLineNum = 50;BA.debugLine="BMI";
_bmi();
 };
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public static String  _edtheight_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 83;BA.debugLine="Sub edtHeight_FocusChanged(HasFocus As Boolean)";
 //BA.debugLineNum = 84;BA.debugLine="If HasFocus Then";
if (_hasfocus) { 
 //BA.debugLineNum = 85;BA.debugLine="lblMessage.Text = \"請輸入身高(公分)...\"";
mostCurrent._lblmessage.setText((Object)("請輸入身高(公分)..."));
 };
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public static String  _edtheight_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 61;BA.debugLine="Sub edtHeight_TextChanged(Old As String, New As String)";
 //BA.debugLineNum = 62;BA.debugLine="lblMessage.Text = \"edtHeight_TextChanged\"";
mostCurrent._lblmessage.setText((Object)("edtHeight_TextChanged"));
 //BA.debugLineNum = 63;BA.debugLine="If New.Length > 3 Then";
if (_new.length()>3) { 
 //BA.debugLineNum = 64;BA.debugLine="edtHeight.Text = Old";
mostCurrent._edtheight.setText((Object)(_old));
 //BA.debugLineNum = 65;BA.debugLine="edtHeight.SelectionStart = Old.Length";
mostCurrent._edtheight.setSelectionStart(_old.length());
 };
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public static String  _edtweight_enterpressed() throws Exception{
 //BA.debugLineNum = 54;BA.debugLine="Sub edtWeight_EnterPressed";
 //BA.debugLineNum = 55;BA.debugLine="lblMessage.Text = \"edtWeight_EnterPressed\"";
mostCurrent._lblmessage.setText((Object)("edtWeight_EnterPressed"));
 //BA.debugLineNum = 56;BA.debugLine="If edtWeight.Text.Length > 0 Then";
if (mostCurrent._edtweight.getText().length()>0) { 
 //BA.debugLineNum = 57;BA.debugLine="BMI";
_bmi();
 };
 //BA.debugLineNum = 59;BA.debugLine="End Sub";
return "";
}
public static String  _edtweight_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 77;BA.debugLine="Sub edtWeight_FocusChanged(HasFocus As Boolean)";
 //BA.debugLineNum = 78;BA.debugLine="If HasFocus Then";
if (_hasfocus) { 
 //BA.debugLineNum = 79;BA.debugLine="lblMessage.Text = \"請輸入體重(公斤)...\"";
mostCurrent._lblmessage.setText((Object)("請輸入體重(公斤)..."));
 };
 //BA.debugLineNum = 81;BA.debugLine="End Sub";
return "";
}
public static String  _edtweight_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 69;BA.debugLine="Sub edtWeight_TextChanged(Old As String, New As String)";
 //BA.debugLineNum = 70;BA.debugLine="lblMessage.Text = \"edtWeight_TextChanged\"";
mostCurrent._lblmessage.setText((Object)("edtWeight_TextChanged"));
 //BA.debugLineNum = 71;BA.debugLine="If New.Length > 2 Then";
if (_new.length()>2) { 
 //BA.debugLineNum = 72;BA.debugLine="edtWeight.Text = Old";
mostCurrent._edtweight.setText((Object)(_old));
 //BA.debugLineNum = 73;BA.debugLine="edtWeight.SelectionStart = Old.Length";
mostCurrent._edtweight.setSelectionStart(_old.length());
 };
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 22;BA.debugLine="Dim edtHeight As EditText";
mostCurrent._edtheight = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Dim edtWeight As EditText";
mostCurrent._edtweight = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Dim lblOutput As Label";
mostCurrent._lbloutput = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Dim lblMessage As Label";
mostCurrent._lblmessage = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
}
