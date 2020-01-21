package appb_2_2.gui.b4a.example;

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
			processBA = new BA(this.getApplicationContext(), null, null, "appb_2_2.gui.b4a.example", "appb_2_2.gui.b4a.example.main");
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
		activityBA = new BA(this, layout, processBA, "appb_2_2.gui.b4a.example", "appb_2_2.gui.b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "appb_2_2.gui.b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density);
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
		return true;
	}
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
public static anywheresoftware.b4a.objects.Serial.BluetoothAdmin _bluadmin = null;
public static anywheresoftware.b4a.objects.Serial _bluspp = null;
public static anywheresoftware.b4a.objects.collections.List _btdevices = null;
public static anywheresoftware.b4a.objects.streams.File.TextReaderWrapper _textreader1 = null;
public static anywheresoftware.b4a.objects.streams.File.TextWriterWrapper _textwriter1 = null;
public static anywheresoftware.b4a.objects.Timer _timer1 = null;
public static boolean _connected = false;
public anywheresoftware.b4a.objects.SpinnerWrapper _spnrpaireddevices = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnconnectbt = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblbtstatus = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btndisconnectbt = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnsend = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtlog = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtsend = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}
public static class _namemac{
public boolean IsInitialized;
public String name;
public String mac;
public void Initialize() {
IsInitialized = true;
name = "";
mac = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 36;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 37;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
 //BA.debugLineNum = 38;BA.debugLine="btDevices.Initialize()       ' 初始List物件";
_btdevices.Initialize();
 //BA.debugLineNum = 39;BA.debugLine="Timer1.Initialize(\"Timer1\", 200)";
_timer1.Initialize(processBA,"Timer1",(long) (200));
 //BA.debugLineNum = 40;BA.debugLine="bluAdmin.Initialize(\"Admin\") ' 初始BluetoothAdmin物件";
_bluadmin.Initialize(processBA,"Admin");
 //BA.debugLineNum = 41;BA.debugLine="bluSPP.Initialize(\"Serial1\") ' 初始Serial物件";
_bluspp.Initialize("Serial1");
 //BA.debugLineNum = 42;BA.debugLine="FindPairedDevices";
_findpaireddevices();
 };
 //BA.debugLineNum = 44;BA.debugLine="Activity.LoadLayout(\"Main\")";
mostCurrent._activity.LoadLayout("Main",mostCurrent.activityBA);
 //BA.debugLineNum = 45;BA.debugLine="Activity.Title = \"藍芽傳輸\"";
mostCurrent._activity.setTitle((Object)("藍芽傳輸"));
 //BA.debugLineNum = 46;BA.debugLine="txtLog.Width = 100%x    ' 最大寬度";
mostCurrent._txtlog.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 47;BA.debugLine="txtLog.Text = \"MAC地址: \" & bluSPP.Address & CRLF & _ 	              \"名稱: \" & bluSPP.Name";
mostCurrent._txtlog.setText((Object)("MAC地址: "+_bluspp.getAddress()+anywheresoftware.b4a.keywords.Common.CRLF+"名稱: "+_bluspp.getName()));
 //BA.debugLineNum = 49;BA.debugLine="connected = False";
_connected = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 65;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 52;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 53;BA.debugLine="UpdateSpinnerItem";
_updatespinneritem();
 //BA.debugLineNum = 55;BA.debugLine="If bluAdmin.IsEnabled = False Then";
if (_bluadmin.IsEnabled()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 56;BA.debugLine="If bluAdmin.Enable = False Then";
if (_bluadmin.Enable()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 57;BA.debugLine="ToastMessageShow(\"啟用藍芽錯誤...\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("啟用藍芽錯誤...",anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 59;BA.debugLine="ToastMessageShow(\"啟用藍芽...\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("啟用藍芽...",anywheresoftware.b4a.keywords.Common.False);
 };
 };
 //BA.debugLineNum = 62;BA.debugLine="UpdateUI    ' 更新介面";
_updateui();
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
return "";
}
public static String  _admin_statechanged(int _newstate,int _oldstate) throws Exception{
 //BA.debugLineNum = 89;BA.debugLine="Sub Admin_StateChanged(NewState As Int, OldState As Int)";
 //BA.debugLineNum = 90;BA.debugLine="FindPairedDevices";
_findpaireddevices();
 //BA.debugLineNum = 91;BA.debugLine="UpdateSpinnerItem";
_updatespinneritem();
 //BA.debugLineNum = 92;BA.debugLine="UpdateUI";
_updateui();
 //BA.debugLineNum = 93;BA.debugLine="End Sub";
return "";
}
public static String  _btnconnectbt_click() throws Exception{
appb_2_2.gui.b4a.example.main._namemac _nm = null;
 //BA.debugLineNum = 111;BA.debugLine="Sub btnConnectBT_Click";
 //BA.debugLineNum = 113;BA.debugLine="If spnrPairedDevices.SelectedIndex = -1 Then Return";
if (mostCurrent._spnrpaireddevices.getSelectedIndex()==-1) { 
if (true) return "";};
 //BA.debugLineNum = 114;BA.debugLine="Dim nm As NameMac = btDevices.Get(spnrPairedDevices.SelectedIndex)";
_nm = (appb_2_2.gui.b4a.example.main._namemac)(_btdevices.Get(mostCurrent._spnrpaireddevices.getSelectedIndex()));
 //BA.debugLineNum = 115;BA.debugLine="bluSPP.Connect(nm.mac)  ' 建立藍芽連接";
_bluspp.Connect(processBA,_nm.mac);
 //BA.debugLineNum = 116;BA.debugLine="lblBTStatus.Text = \"正在連接藍芽裝置...\"";
mostCurrent._lblbtstatus.setText((Object)("正在連接藍芽裝置..."));
 //BA.debugLineNum = 117;BA.debugLine="btnConnectBT.Enabled = False";
mostCurrent._btnconnectbt.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 118;BA.debugLine="End Sub";
return "";
}
public static String  _btndisconnectbt_click() throws Exception{
 //BA.debugLineNum = 140;BA.debugLine="Sub btnDisconnectBT_Click";
 //BA.debugLineNum = 141;BA.debugLine="bluSPP.Disconnect()   ' 中斷連接";
_bluspp.Disconnect();
 //BA.debugLineNum = 142;BA.debugLine="btnConnectBT.Enabled = True";
mostCurrent._btnconnectbt.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 143;BA.debugLine="btnDisconnectBT.Enabled = False";
mostCurrent._btndisconnectbt.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 144;BA.debugLine="btnSend.Enabled = False";
mostCurrent._btnsend.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 145;BA.debugLine="Timer1.Enabled = False";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 146;BA.debugLine="lblBTStatus.Text = \"藍芽連接已經中斷...\"";
mostCurrent._lblbtstatus.setText((Object)("藍芽連接已經中斷..."));
 //BA.debugLineNum = 147;BA.debugLine="End Sub";
return "";
}
public static String  _btnsend_click() throws Exception{
 //BA.debugLineNum = 149;BA.debugLine="Sub btnSend_Click";
 //BA.debugLineNum = 150;BA.debugLine="If connected Then   ' 是否連線中";
if (_connected) { 
 //BA.debugLineNum = 151;BA.debugLine="TextWriter1.WriteLine(txtSend.Text) ' 送出資料";
_textwriter1.WriteLine(mostCurrent._txtsend.getText());
 //BA.debugLineNum = 152;BA.debugLine="TextWriter1.Flush()   ' 確認送出";
_textwriter1.Flush();
 //BA.debugLineNum = 153;BA.debugLine="txtSend.Text = \"\"";
mostCurrent._txtsend.setText((Object)(""));
 };
 //BA.debugLineNum = 155;BA.debugLine="End Sub";
return "";
}
public static String  _findpaireddevices() throws Exception{
anywheresoftware.b4a.objects.collections.Map _paireddevices = null;
int _i = 0;
appb_2_2.gui.b4a.example.main._namemac _nm = null;
 //BA.debugLineNum = 69;BA.debugLine="Sub FindPairedDevices";
 //BA.debugLineNum = 70;BA.debugLine="btDevices.Clear()     ' 清除裝置清單";
_btdevices.Clear();
 //BA.debugLineNum = 72;BA.debugLine="Dim pairedDevices As Map = bluSPP.GetPairedDevices";
_paireddevices = new anywheresoftware.b4a.objects.collections.Map();
_paireddevices = _bluspp.GetPairedDevices();
 //BA.debugLineNum = 73;BA.debugLine="For i = 0 To pairedDevices.Size - 1  ' 新增配對裝置";
{
final int step49 = 1;
final int limit49 = (int) (_paireddevices.getSize()-1);
for (_i = (int) (0); (step49 > 0 && _i <= limit49) || (step49 < 0 && _i >= limit49); _i = ((int)(0 + _i + step49))) {
 //BA.debugLineNum = 74;BA.debugLine="Dim nm As NameMac";
_nm = new appb_2_2.gui.b4a.example.main._namemac();
 //BA.debugLineNum = 75;BA.debugLine="nm.Initialize()";
_nm.Initialize();
 //BA.debugLineNum = 76;BA.debugLine="nm.mac = pairedDevices.GetValueAt(i)";
_nm.mac = BA.ObjectToString(_paireddevices.GetValueAt(_i));
 //BA.debugLineNum = 77;BA.debugLine="nm.name = pairedDevices.GetKeyAt(i)";
_nm.name = BA.ObjectToString(_paireddevices.GetKeyAt(_i));
 //BA.debugLineNum = 78;BA.debugLine="btDevices.Add(nm)  ' 新增至裝置清單";
_btdevices.Add((Object)(_nm));
 }
};
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _globals() throws Exception{
 //BA.debugLineNum = 26;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 27;BA.debugLine="Dim spnrPairedDevices As Spinner";
mostCurrent._spnrpaireddevices = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Dim btnConnectBT As Button";
mostCurrent._btnconnectbt = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Dim lblBTStatus As Label";
mostCurrent._lblbtstatus = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Dim btnDisconnectBT As Button";
mostCurrent._btndisconnectbt = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Dim btnSend As Button";
mostCurrent._btnsend = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Dim txtLog As EditText";
mostCurrent._txtlog = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Dim txtSend As EditText";
mostCurrent._txtsend = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 16;BA.debugLine="Dim bluAdmin As BluetoothAdmin";
_bluadmin = new anywheresoftware.b4a.objects.Serial.BluetoothAdmin();
 //BA.debugLineNum = 17;BA.debugLine="Dim bluSPP As Serial";
_bluspp = new anywheresoftware.b4a.objects.Serial();
 //BA.debugLineNum = 18;BA.debugLine="Dim btDevices As List";
_btdevices = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 19;BA.debugLine="Type NameMac (name As String, mac As String)";
;
 //BA.debugLineNum = 20;BA.debugLine="Dim TextReader1 As TextReader";
_textreader1 = new anywheresoftware.b4a.objects.streams.File.TextReaderWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Dim TextWriter1 As TextWriter";
_textwriter1 = new anywheresoftware.b4a.objects.streams.File.TextWriterWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Dim Timer1 As Timer";
_timer1 = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 23;BA.debugLine="Dim connected As Boolean";
_connected = false;
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return "";
}
public static String  _serial1_connected(boolean _success) throws Exception{
 //BA.debugLineNum = 120;BA.debugLine="Sub Serial1_Connected(Success As Boolean)";
 //BA.debugLineNum = 121;BA.debugLine="If Success = False Then    ' 失敗";
if (_success==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 122;BA.debugLine="ToastMessageShow(\"藍芽連接錯誤: \" & LastException.Message, True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("藍芽連接錯誤: "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 123;BA.debugLine="lblBTStatus.Text = \"藍芽連接錯誤...\"";
mostCurrent._lblbtstatus.setText((Object)("藍芽連接錯誤..."));
 //BA.debugLineNum = 124;BA.debugLine="btnConnectBT.Enabled = True";
mostCurrent._btnconnectbt.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 125;BA.debugLine="connected = False";
_connected = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 126;BA.debugLine="Timer1.Enabled = False";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 128;BA.debugLine="lblBTStatus.Text = \"成功建立藍芽連接...\"";
mostCurrent._lblbtstatus.setText((Object)("成功建立藍芽連接..."));
 //BA.debugLineNum = 129;BA.debugLine="btnConnectBT.Enabled = False";
mostCurrent._btnconnectbt.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 130;BA.debugLine="btnDisconnectBT.Enabled = True";
mostCurrent._btndisconnectbt.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 132;BA.debugLine="TextReader1.Initialize(bluSPP.InputStream)";
_textreader1.Initialize(_bluspp.getInputStream());
 //BA.debugLineNum = 133;BA.debugLine="TextWriter1.Initialize(bluSPP.OutputStream)";
_textwriter1.Initialize(_bluspp.getOutputStream());
 //BA.debugLineNum = 134;BA.debugLine="Timer1.Enabled = True";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 135;BA.debugLine="connected = True";
_connected = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 136;BA.debugLine="btnSend.Enabled = True";
mostCurrent._btnsend.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 138;BA.debugLine="End Sub";
return "";
}
public static String  _timer1_tick() throws Exception{
 //BA.debugLineNum = 157;BA.debugLine="Sub Timer1_Tick";
 //BA.debugLineNum = 158;BA.debugLine="If connected Then   ' 是否連線中";
if (_connected) { 
 //BA.debugLineNum = 159;BA.debugLine="If TextReader1.Ready() Then   ' 檢查是否有讀取資料";
if (_textreader1.Ready()) { 
 //BA.debugLineNum = 161;BA.debugLine="txtLog.Text = txtLog.Text & TextReader1.ReadLine() & CRLF";
mostCurrent._txtlog.setText((Object)(mostCurrent._txtlog.getText()+_textreader1.ReadLine()+anywheresoftware.b4a.keywords.Common.CRLF));
 //BA.debugLineNum = 162;BA.debugLine="txtLog.SelectionStart = txtLog.Text.Length";
mostCurrent._txtlog.setSelectionStart(mostCurrent._txtlog.getText().length());
 };
 };
 //BA.debugLineNum = 165;BA.debugLine="End Sub";
return "";
}
public static String  _updatespinneritem() throws Exception{
appb_2_2.gui.b4a.example.main._namemac _nm = null;
 //BA.debugLineNum = 82;BA.debugLine="Sub UpdateSpinnerItem";
 //BA.debugLineNum = 83;BA.debugLine="spnrPairedDevices.Clear()      ' 清除Spinner元件的項目";
mostCurrent._spnrpaireddevices.Clear();
 //BA.debugLineNum = 84;BA.debugLine="For Each nm As NameMac In btDevices   ' 新增配對裝置至Spinner元件";
final anywheresoftware.b4a.BA.IterableList group59 = _btdevices;
final int groupLen59 = group59.getSize();
for (int index59 = 0;index59 < groupLen59 ;index59++){
_nm = (appb_2_2.gui.b4a.example.main._namemac)(group59.Get(index59));
 //BA.debugLineNum = 85;BA.debugLine="spnrPairedDevices.Add(nm.name)";
mostCurrent._spnrpaireddevices.Add(_nm.name);
 }
;
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public static String  _updateui() throws Exception{
 //BA.debugLineNum = 95;BA.debugLine="Public Sub UpdateUI";
 //BA.debugLineNum = 97;BA.debugLine="If spnrPairedDevices.Size = 0 Then";
if (mostCurrent._spnrpaireddevices.getSize()==0) { 
 //BA.debugLineNum = 98;BA.debugLine="btnConnectBT.Enabled = False";
mostCurrent._btnconnectbt.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 100;BA.debugLine="If connected Then    ' 是否已經連接";
if (_connected) { 
 //BA.debugLineNum = 101;BA.debugLine="btnSend.Enabled = True";
mostCurrent._btnsend.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 102;BA.debugLine="btnConnectBT.Enabled = False";
mostCurrent._btnconnectbt.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 103;BA.debugLine="btnDisconnectBT.Enabled = True";
mostCurrent._btndisconnectbt.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 105;BA.debugLine="btnSend.Enabled = False";
mostCurrent._btnsend.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 106;BA.debugLine="btnConnectBT.Enabled = True";
mostCurrent._btnconnectbt.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 107;BA.debugLine="btnDisconnectBT.Enabled = False";
mostCurrent._btndisconnectbt.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
return "";
}
}
