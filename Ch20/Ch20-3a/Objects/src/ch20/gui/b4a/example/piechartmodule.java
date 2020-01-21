package ch20.gui.b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class piechartmodule {
private static piechartmodule mostCurrent = new piechartmodule();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public ch20.gui.b4a.example.main _main = null;
public ch20.gui.b4a.example.piechart _piechart = null;
  public Object[] GetGlobals() {
		return new Object[] {"Main",Debug.moduleToString(ch20.gui.b4a.example.main.class),"PieChart",Debug.moduleToString(ch20.gui.b4a.example.piechart.class)};
}
public static class _pieitem{
public boolean IsInitialized;
public String Name;
public float Value;
public int Color;
public void Initialize() {
IsInitialized = true;
Name = "";
Value = 0f;
Color = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _piedata{
public boolean IsInitialized;
public anywheresoftware.b4a.objects.collections.List Items;
public anywheresoftware.b4a.objects.PanelWrapper Target;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper Canvas;
public int GapDegrees;
public float LegendTextSize;
public int LegendBackColor;
public void Initialize() {
IsInitialized = true;
Items = new anywheresoftware.b4a.objects.collections.List();
Target = new anywheresoftware.b4a.objects.PanelWrapper();
Canvas = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
GapDegrees = 0;
LegendTextSize = 0f;
LegendBackColor = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static String  _addpieitem(anywheresoftware.b4a.BA _ba,ch20.gui.b4a.example.piechartmodule._piedata _pd,String _name,float _value,int _color) throws Exception{
try {
		Debug.PushSubsStack("AddPieItem (piechartmodule) ","piechartmodule",2,_ba,mostCurrent,9);
ch20.gui.b4a.example.piechartmodule._pieitem _i = null;
;
Debug.locals.put("PD", _pd);
Debug.locals.put("Name", _name);
Debug.locals.put("Value", _value);
Debug.locals.put("Color", _color);
 BA.debugLineNum = 9;BA.debugLine="Sub AddPieItem(PD As PieData, Name As String, Value As Float, Color As Int)";
Debug.ShouldStop(256);
 BA.debugLineNum = 10;BA.debugLine="If PD.Items.IsInitialized = False Then PD.Items.Initialize";
Debug.ShouldStop(512);
if (_pd.Items.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
_pd.Items.Initialize();};
 BA.debugLineNum = 11;BA.debugLine="If Color = 0 Then Color = Colors.RGB(Rnd(0, 255), Rnd(0, 255), Rnd(0, 255))";
Debug.ShouldStop(1024);
if (_color==0) { 
_color = anywheresoftware.b4a.keywords.Common.Colors.RGB(anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (255)),anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (255)),anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (255)));Debug.locals.put("Color", _color);};
 BA.debugLineNum = 12;BA.debugLine="Dim i As PieItem";
Debug.ShouldStop(2048);
_i = new ch20.gui.b4a.example.piechartmodule._pieitem();Debug.locals.put("i", _i);
 BA.debugLineNum = 13;BA.debugLine="i.Initialize";
Debug.ShouldStop(4096);
_i.Initialize();
 BA.debugLineNum = 14;BA.debugLine="i.Name = Name";
Debug.ShouldStop(8192);
_i.Name = _name;Debug.locals.put("i", _i);
 BA.debugLineNum = 15;BA.debugLine="i.Value = Value";
Debug.ShouldStop(16384);
_i.Value = _value;Debug.locals.put("i", _i);
 BA.debugLineNum = 16;BA.debugLine="i.Color = Color";
Debug.ShouldStop(32768);
_i.Color = _color;Debug.locals.put("i", _i);
 BA.debugLineNum = 17;BA.debugLine="PD.Items.Add(i)";
Debug.ShouldStop(65536);
_pd.Items.Add((Object)(_i));
 BA.debugLineNum = 18;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static float  _calcslice(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.drawable.CanvasWrapper _canvas,int _radius,float _startingdegree,float _percent,int _color,int _gapdegrees) throws Exception{
try {
		Debug.PushSubsStack("calcSlice (piechartmodule) ","piechartmodule",2,_ba,mostCurrent,55);
float _b = 0f;
int _cx = 0;
int _cy = 0;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper _p = null;
float _gap = 0f;
int _i = 0;
;
Debug.locals.put("Canvas", _canvas);
Debug.locals.put("Radius", _radius);
Debug.locals.put("StartingDegree", _startingdegree);
Debug.locals.put("Percent", _percent);
Debug.locals.put("Color", _color);
Debug.locals.put("GapDegrees", _gapdegrees);
 BA.debugLineNum = 55;BA.debugLine="Sub calcSlice(Canvas As Canvas, Radius As Int, _  		StartingDegree As Float, Percent As Float, Color As Int, GapDegrees As Int) As Float";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 57;BA.debugLine="Dim b As Float";
Debug.ShouldStop(16777216);
_b = 0f;Debug.locals.put("b", _b);
 BA.debugLineNum = 58;BA.debugLine="b = 360 * Percent";
Debug.ShouldStop(33554432);
_b = (float) (360*_percent);Debug.locals.put("b", _b);
 BA.debugLineNum = 60;BA.debugLine="Dim cx, cy As Int";
Debug.ShouldStop(134217728);
_cx = 0;Debug.locals.put("cx", _cx);
_cy = 0;Debug.locals.put("cy", _cy);
 BA.debugLineNum = 61;BA.debugLine="cx = Canvas.Bitmap.Width / 2";
Debug.ShouldStop(268435456);
_cx = (int) (_canvas.getBitmap().getWidth()/(double)2);Debug.locals.put("cx", _cx);
 BA.debugLineNum = 62;BA.debugLine="cy = Canvas.Bitmap.Height / 2";
Debug.ShouldStop(536870912);
_cy = (int) (_canvas.getBitmap().getHeight()/(double)2);Debug.locals.put("cy", _cy);
 BA.debugLineNum = 63;BA.debugLine="Dim p As Path";
Debug.ShouldStop(1073741824);
_p = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper();Debug.locals.put("p", _p);
 BA.debugLineNum = 64;BA.debugLine="p.Initialize(cx, cy)";
Debug.ShouldStop(-2147483648);
_p.Initialize((float) (_cx),(float) (_cy));
 BA.debugLineNum = 65;BA.debugLine="Dim gap As Float";
Debug.ShouldStop(1);
_gap = 0f;Debug.locals.put("gap", _gap);
 BA.debugLineNum = 66;BA.debugLine="gap = Percent * GapDegrees / 2";
Debug.ShouldStop(2);
_gap = (float) (_percent*_gapdegrees/(double)2);Debug.locals.put("gap", _gap);
 BA.debugLineNum = 67;BA.debugLine="For i = StartingDegree + gap To StartingDegree + b - gap Step 10";
Debug.ShouldStop(4);
{
final int step55 = (int) (10);
final int limit55 = (int) (_startingdegree+_b-_gap);
for (_i = (int) (_startingdegree+_gap); (step55 > 0 && _i <= limit55) || (step55 < 0 && _i >= limit55); _i = ((int)(0 + _i + step55))) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 68;BA.debugLine="p.LineTo(cx + 2 * Radius * SinD(i), cy + 2 * Radius * CosD(i))";
Debug.ShouldStop(8);
_p.LineTo((float) (_cx+2*_radius*anywheresoftware.b4a.keywords.Common.SinD(_i)),(float) (_cy+2*_radius*anywheresoftware.b4a.keywords.Common.CosD(_i)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 70;BA.debugLine="p.LineTo(cx + 2 * Radius * SinD(StartingDegree + b - gap), cy + 2 * Radius * CosD(StartingDegree + b - gap))";
Debug.ShouldStop(32);
_p.LineTo((float) (_cx+2*_radius*anywheresoftware.b4a.keywords.Common.SinD(_startingdegree+_b-_gap)),(float) (_cy+2*_radius*anywheresoftware.b4a.keywords.Common.CosD(_startingdegree+_b-_gap)));
 BA.debugLineNum = 71;BA.debugLine="p.LineTo(cx, cy)";
Debug.ShouldStop(64);
_p.LineTo((float) (_cx),(float) (_cy));
 BA.debugLineNum = 72;BA.debugLine="Canvas.ClipPath(p) 'We are limiting the drawings to the required slice";
Debug.ShouldStop(128);
_canvas.ClipPath((android.graphics.Path)(_p.getObject()));
 BA.debugLineNum = 73;BA.debugLine="Canvas.DrawCircle(cx, cy, Radius, Color, True, 0)";
Debug.ShouldStop(256);
_canvas.DrawCircle((float) (_cx),(float) (_cy),(float) (_radius),_color,anywheresoftware.b4a.keywords.Common.True,(float) (0));
 BA.debugLineNum = 74;BA.debugLine="Canvas.RemoveClip";
Debug.ShouldStop(512);
_canvas.RemoveClip();
 BA.debugLineNum = 75;BA.debugLine="Return b";
Debug.ShouldStop(1024);
if (true) return _b;
 BA.debugLineNum = 76;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return 0f;
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _createlegend(anywheresoftware.b4a.BA _ba,ch20.gui.b4a.example.piechartmodule._piedata _pd) throws Exception{
try {
		Debug.PushSubsStack("createLegend (piechartmodule) ","piechartmodule",2,_ba,mostCurrent,78);
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
float _textheight = 0f;
float _textwidth = 0f;
int _i = 0;
ch20.gui.b4a.example.piechartmodule._pieitem _it = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _c = null;
;
Debug.locals.put("PD", _pd);
 BA.debugLineNum = 78;BA.debugLine="Sub createLegend(PD As PieData) As Bitmap";
Debug.ShouldStop(8192);
 BA.debugLineNum = 79;BA.debugLine="Dim bmp As Bitmap";
Debug.ShouldStop(16384);
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 80;BA.debugLine="If PD.LegendTextSize = 0 Then PD.LegendTextSize = 15";
Debug.ShouldStop(32768);
if (_pd.LegendTextSize==0) { 
_pd.LegendTextSize = (float) (15);Debug.locals.put("PD", _pd);};
 BA.debugLineNum = 81;BA.debugLine="Dim textHeight, textWidth As Float";
Debug.ShouldStop(65536);
_textheight = 0f;Debug.locals.put("textHeight", _textheight);
_textwidth = 0f;Debug.locals.put("textWidth", _textwidth);
 BA.debugLineNum = 82;BA.debugLine="textHeight = PD.Canvas.MeasureStringHeight(\"M\", Typeface.DEFAULT_BOLD, PD.LegendTextSize)";
Debug.ShouldStop(131072);
_textheight = _pd.Canvas.MeasureStringHeight("M",anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD,_pd.LegendTextSize);Debug.locals.put("textHeight", _textheight);
 BA.debugLineNum = 83;BA.debugLine="For i = 0 To PD.Items.Size - 1";
Debug.ShouldStop(262144);
{
final int step70 = 1;
final int limit70 = (int) (_pd.Items.getSize()-1);
for (_i = (int) (0); (step70 > 0 && _i <= limit70) || (step70 < 0 && _i >= limit70); _i = ((int)(0 + _i + step70))) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 84;BA.debugLine="Dim it As PieItem";
Debug.ShouldStop(524288);
_it = new ch20.gui.b4a.example.piechartmodule._pieitem();Debug.locals.put("it", _it);
 BA.debugLineNum = 85;BA.debugLine="it = PD.Items.Get(i)";
Debug.ShouldStop(1048576);
_it = (ch20.gui.b4a.example.piechartmodule._pieitem)(_pd.Items.Get(_i));Debug.locals.put("it", _it);
 BA.debugLineNum = 86;BA.debugLine="textWidth = Max(textWidth, PD.Canvas.MeasureStringWidth(it.Name, Typeface.DEFAULT_BOLD, PD.LegendTextSize))";
Debug.ShouldStop(2097152);
_textwidth = (float) (anywheresoftware.b4a.keywords.Common.Max(_textwidth,_pd.Canvas.MeasureStringWidth(_it.Name,anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD,_pd.LegendTextSize)));Debug.locals.put("textWidth", _textwidth);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 88;BA.debugLine="bmp.InitializeMutable(textWidth + 20dip, 10dip +(textHeight + 10dip) * PD.Items.Size)";
Debug.ShouldStop(8388608);
_bmp.InitializeMutable((int) (_textwidth+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),(int) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))+(_textheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)))*_pd.Items.getSize()));
 BA.debugLineNum = 89;BA.debugLine="Dim c As Canvas";
Debug.ShouldStop(16777216);
_c = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();Debug.locals.put("c", _c);
 BA.debugLineNum = 90;BA.debugLine="c.Initialize2(bmp)";
Debug.ShouldStop(33554432);
_c.Initialize2((android.graphics.Bitmap)(_bmp.getObject()));
 BA.debugLineNum = 91;BA.debugLine="c.DrawColor(PD.LegendBackColor)";
Debug.ShouldStop(67108864);
_c.DrawColor(_pd.LegendBackColor);
 BA.debugLineNum = 92;BA.debugLine="For i = 0 To PD.Items.Size - 1";
Debug.ShouldStop(134217728);
{
final int step79 = 1;
final int limit79 = (int) (_pd.Items.getSize()-1);
for (_i = (int) (0); (step79 > 0 && _i <= limit79) || (step79 < 0 && _i >= limit79); _i = ((int)(0 + _i + step79))) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 93;BA.debugLine="Dim it As PieItem";
Debug.ShouldStop(268435456);
_it = new ch20.gui.b4a.example.piechartmodule._pieitem();Debug.locals.put("it", _it);
 BA.debugLineNum = 94;BA.debugLine="it = PD.Items.Get(i)";
Debug.ShouldStop(536870912);
_it = (ch20.gui.b4a.example.piechartmodule._pieitem)(_pd.Items.Get(_i));Debug.locals.put("it", _it);
 BA.debugLineNum = 95;BA.debugLine="c.DrawText(it.Name, 10dip, (i + 1) * (textHeight + 10dip), Typeface.DEFAULT_BOLD, PD.LegendTextSize, _ 			it.Color, \"LEFT\")";
Debug.ShouldStop(1073741824);
_c.DrawText(_ba,_it.Name,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),(float) ((_i+1)*(_textheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)))),anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD,_pd.LegendTextSize,_it.Color,BA.getEnumFromString(android.graphics.Paint.Align.class,"LEFT"));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 98;BA.debugLine="Return bmp";
Debug.ShouldStop(2);
if (true) return _bmp;
 BA.debugLineNum = 99;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return null;
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _drawpie(anywheresoftware.b4a.BA _ba,ch20.gui.b4a.example.piechartmodule._piedata _pd,int _backcolor,boolean _createlegendbitmap) throws Exception{
try {
		Debug.PushSubsStack("DrawPie (piechartmodule) ","piechartmodule",2,_ba,mostCurrent,21);
int _radius = 0;
int _total = 0;
int _i = 0;
ch20.gui.b4a.example.piechartmodule._pieitem _it = null;
float _startingangle = 0f;
int _gapdegrees = 0;
;
Debug.locals.put("PD", _pd);
Debug.locals.put("BackColor", _backcolor);
Debug.locals.put("CreateLegendBitmap", _createlegendbitmap);
 BA.debugLineNum = 21;BA.debugLine="Sub DrawPie (PD As PieData, BackColor As Int, CreateLegendBitmap As Boolean) As Bitmap";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 22;BA.debugLine="If PD.Items.Size = 0 Then";
Debug.ShouldStop(2097152);
if (_pd.Items.getSize()==0) { 
 BA.debugLineNum = 23;BA.debugLine="ToastMessageShow(\"Missing pie values.\", True)";
Debug.ShouldStop(4194304);
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Missing pie values.",anywheresoftware.b4a.keywords.Common.True);
 BA.debugLineNum = 24;BA.debugLine="Return";
Debug.ShouldStop(8388608);
if (true) return null;
 };
 BA.debugLineNum = 26;BA.debugLine="PD.Canvas.Initialize(PD.Target)";
Debug.ShouldStop(33554432);
_pd.Canvas.Initialize((android.view.View)(_pd.Target.getObject()));
 BA.debugLineNum = 27;BA.debugLine="PD.Canvas.DrawColor(BackColor)";
Debug.ShouldStop(67108864);
_pd.Canvas.DrawColor(_backcolor);
 BA.debugLineNum = 28;BA.debugLine="Dim Radius As Int";
Debug.ShouldStop(134217728);
_radius = 0;Debug.locals.put("Radius", _radius);
 BA.debugLineNum = 29;BA.debugLine="Radius = Min(PD.Canvas.Bitmap.Width, PD.Canvas.Bitmap.Height) * 0.8 / 2";
Debug.ShouldStop(268435456);
_radius = (int) (anywheresoftware.b4a.keywords.Common.Min(_pd.Canvas.getBitmap().getWidth(),_pd.Canvas.getBitmap().getHeight())*0.8/(double)2);Debug.locals.put("Radius", _radius);
 BA.debugLineNum = 30;BA.debugLine="Dim total As Int";
Debug.ShouldStop(536870912);
_total = 0;Debug.locals.put("total", _total);
 BA.debugLineNum = 31;BA.debugLine="For i = 0 To PD.Items.Size - 1";
Debug.ShouldStop(1073741824);
{
final int step24 = 1;
final int limit24 = (int) (_pd.Items.getSize()-1);
for (_i = (int) (0); (step24 > 0 && _i <= limit24) || (step24 < 0 && _i >= limit24); _i = ((int)(0 + _i + step24))) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 32;BA.debugLine="Dim it As PieItem";
Debug.ShouldStop(-2147483648);
_it = new ch20.gui.b4a.example.piechartmodule._pieitem();Debug.locals.put("it", _it);
 BA.debugLineNum = 33;BA.debugLine="it = PD.Items.Get(i)";
Debug.ShouldStop(1);
_it = (ch20.gui.b4a.example.piechartmodule._pieitem)(_pd.Items.Get(_i));Debug.locals.put("it", _it);
 BA.debugLineNum = 34;BA.debugLine="total = total + it.Value";
Debug.ShouldStop(2);
_total = (int) (_total+_it.Value);Debug.locals.put("total", _total);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 36;BA.debugLine="Dim startingAngle As Float";
Debug.ShouldStop(8);
_startingangle = 0f;Debug.locals.put("startingAngle", _startingangle);
 BA.debugLineNum = 37;BA.debugLine="startingAngle = 0";
Debug.ShouldStop(16);
_startingangle = (float) (0);Debug.locals.put("startingAngle", _startingangle);
 BA.debugLineNum = 38;BA.debugLine="Dim GapDegrees As Int";
Debug.ShouldStop(32);
_gapdegrees = 0;Debug.locals.put("GapDegrees", _gapdegrees);
 BA.debugLineNum = 39;BA.debugLine="If PD.Items.Size = 1 Then GapDegrees = 0 Else GapDegrees = PD.GapDegrees";
Debug.ShouldStop(64);
if (_pd.Items.getSize()==1) { 
_gapdegrees = (int) (0);Debug.locals.put("GapDegrees", _gapdegrees);}
else {
_gapdegrees = _pd.GapDegrees;Debug.locals.put("GapDegrees", _gapdegrees);};
 BA.debugLineNum = 40;BA.debugLine="For i = 0 To PD.Items.Size - 1";
Debug.ShouldStop(128);
{
final int step33 = 1;
final int limit33 = (int) (_pd.Items.getSize()-1);
for (_i = (int) (0); (step33 > 0 && _i <= limit33) || (step33 < 0 && _i >= limit33); _i = ((int)(0 + _i + step33))) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 41;BA.debugLine="Dim it As PieItem";
Debug.ShouldStop(256);
_it = new ch20.gui.b4a.example.piechartmodule._pieitem();Debug.locals.put("it", _it);
 BA.debugLineNum = 42;BA.debugLine="it = PD.Items.Get(i)";
Debug.ShouldStop(512);
_it = (ch20.gui.b4a.example.piechartmodule._pieitem)(_pd.Items.Get(_i));Debug.locals.put("it", _it);
 BA.debugLineNum = 43;BA.debugLine="startingAngle = startingAngle + _  			calcSlice(PD.Canvas, Radius, startingAngle, it.Value / total, it.Color, GapDegrees)";
Debug.ShouldStop(1024);
_startingangle = (float) (_startingangle+_calcslice(_ba,_pd.Canvas,_radius,_startingangle,(float) (_it.Value/(double)_total),_it.Color,_gapdegrees));Debug.locals.put("startingAngle", _startingangle);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 46;BA.debugLine="PD.Target.Invalidate";
Debug.ShouldStop(8192);
_pd.Target.Invalidate();
 BA.debugLineNum = 47;BA.debugLine="If CreateLegendBitmap Then";
Debug.ShouldStop(16384);
if (_createlegendbitmap) { 
 BA.debugLineNum = 48;BA.debugLine="Return createLegend(PD)";
Debug.ShouldStop(32768);
if (true) return _createlegend(_ba,_pd);
 }else {
 BA.debugLineNum = 50;BA.debugLine="Return Null";
Debug.ShouldStop(131072);
if (true) return (anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null));
 };
 BA.debugLineNum = 52;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return null;
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Type PieItem (Name As String, Value As Float, Color As Int)";
;
 //BA.debugLineNum = 4;BA.debugLine="Type PieData (Items As List, Target As Panel, Canvas As Canvas, GapDegrees As Int, _ 		LegendTextSize As Float, LegendBackColor As Int)";
;
 //BA.debugLineNum = 6;BA.debugLine="End Sub";
return "";
}
}
