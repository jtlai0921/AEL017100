package b4i.examples.piechart;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class b4i_piechartmodule_subs_0 {


public static RemoteObject  _addpieitem(RemoteObject _pd,RemoteObject _name,RemoteObject _value,RemoteObject _color) throws Exception{
try {
		Debug.PushSubsStack("AddPieItem (piechartmodule) ","piechartmodule",2,b4i_piechartmodule.ba,b4i_piechartmodule.mostCurrent,9);
if (RapidSub.canDelegate("addpieitem")) return b4i_piechartmodule.remoteMe.runUserSub(false, "piechartmodule","addpieitem", _pd, _name, _value, _color);
RemoteObject _i = RemoteObject.declareNull("_pieitem");
Debug.locals.put("PD", _pd);
Debug.locals.put("Name", _name);
Debug.locals.put("Value", _value);
Debug.locals.put("Color", _color);
 BA.debugLineNum = 9;BA.debugLine="Sub AddPieItem(PD As PieData, Name As String, Value As Float, Color As Int)";
Debug.ShouldStop(256);
 BA.debugLineNum = 10;BA.debugLine="If PD.Items.IsInitialized = False Then PD.Items.Initialize";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_pd.getFieldClass("_piedata", false,"Items").runMethod(true,"IsInitialized"),b4i_piechartmodule.__c.runMethod(true,"False"))) { 
_pd.getFieldClass("_piedata", false,"Items").runVoidMethod ("Initialize");};
 BA.debugLineNum = 11;BA.debugLine="If Color = 0 Then Color = Colors.RGB(Rnd(0, 255), Rnd(0, 255), Rnd(0, 255))";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",_color,BA.numberCast(double.class, 0))) { 
_color = b4i_piechartmodule.__c.runMethod(false,"Colors").runMethod(true,"RGB:::",(Object)(b4i_piechartmodule.__c.runMethod(true,"Rnd::",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 255)))),(Object)(b4i_piechartmodule.__c.runMethod(true,"Rnd::",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 255)))),(Object)(b4i_piechartmodule.__c.runMethod(true,"Rnd::",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 255)))));Debug.locals.put("Color", _color);};
 BA.debugLineNum = 12;BA.debugLine="Dim i As PieItem";
Debug.ShouldStop(2048);
_i = RemoteObject.createNew("_pieitem");Debug.locals.put("i", _i);
 BA.debugLineNum = 13;BA.debugLine="i.Initialize";
Debug.ShouldStop(4096);
_i.runVoidMethod ("Initialize");
 BA.debugLineNum = 14;BA.debugLine="i.Name = Name";
Debug.ShouldStop(8192);
_i.setFieldClass("_pieitem", "Name",_name);
 BA.debugLineNum = 15;BA.debugLine="i.Value = Value";
Debug.ShouldStop(16384);
_i.setFieldClass("_pieitem", "Value",_value);
 BA.debugLineNum = 16;BA.debugLine="i.Color = Color";
Debug.ShouldStop(32768);
_i.setFieldClass("_pieitem", "Color",_color);
 BA.debugLineNum = 17;BA.debugLine="PD.Items.Add(i)";
Debug.ShouldStop(65536);
_pd.getFieldClass("_piedata", false,"Items").runVoidMethod ("Add:",(Object)((_i)));
 BA.debugLineNum = 18;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _calcslice(RemoteObject _pd,RemoteObject _radius,RemoteObject _startingdegree,RemoteObject _percent,RemoteObject _color,RemoteObject _gapdegrees) throws Exception{
try {
		Debug.PushSubsStack("calcSlice (piechartmodule) ","piechartmodule",2,b4i_piechartmodule.ba,b4i_piechartmodule.mostCurrent,137);
if (RapidSub.canDelegate("calcslice")) return b4i_piechartmodule.remoteMe.runUserSub(false, "piechartmodule","calcslice", _pd, _radius, _startingdegree, _percent, _color, _gapdegrees);
RemoteObject _b = RemoteObject.createImmutable(0.0f);
RemoteObject _cx = RemoteObject.createImmutable(0);
RemoteObject _cy = RemoteObject.createImmutable(0);
RemoteObject _p = RemoteObject.declareNull("B4IPathWrapper");
RemoteObject _gap = RemoteObject.createImmutable(0.0f);
int _i = 0;
Debug.locals.put("pd", _pd);
Debug.locals.put("Radius", _radius);
Debug.locals.put("StartingDegree", _startingdegree);
Debug.locals.put("Percent", _percent);
Debug.locals.put("Color", _color);
Debug.locals.put("GapDegrees", _gapdegrees);
 BA.debugLineNum = 137;BA.debugLine="Private Sub calcSlice(pd As PieData, Radius As Int, _  		StartingDegree As Float, Percent As Float, Color As Int, GapDegrees As Int) As Float";
Debug.ShouldStop(256);
 BA.debugLineNum = 139;BA.debugLine="Dim b As Float";
Debug.ShouldStop(1024);
_b = RemoteObject.createImmutable(0.0f);Debug.locals.put("b", _b);
 BA.debugLineNum = 140;BA.debugLine="b = 360 * Percent";
Debug.ShouldStop(2048);
_b = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(360),_percent}, "*",0, 0));Debug.locals.put("b", _b);
 BA.debugLineNum = 142;BA.debugLine="Dim cx, cy As Int";
Debug.ShouldStop(8192);
_cx = RemoteObject.createImmutable(0);Debug.locals.put("cx", _cx);
_cy = RemoteObject.createImmutable(0);Debug.locals.put("cy", _cy);
 BA.debugLineNum = 143;BA.debugLine="cx = pd.Target.Width / 2";
Debug.ShouldStop(16384);
_cx = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pd.getFieldClass("_piedata", false,"Target").runMethod(true,"Width"),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("cx", _cx);
 BA.debugLineNum = 144;BA.debugLine="cy = pd.Target.Height / 2";
Debug.ShouldStop(32768);
_cy = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_pd.getFieldClass("_piedata", false,"Target").runMethod(true,"Height"),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("cy", _cy);
 BA.debugLineNum = 145;BA.debugLine="Dim p As Path";
Debug.ShouldStop(65536);
_p = RemoteObject.createNew("B4IPathWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 146;BA.debugLine="p.Initialize(cx, cy)";
Debug.ShouldStop(131072);
_p.runVoidMethod ("Initialize::",(Object)(BA.numberCast(float.class, _cx)),(Object)(BA.numberCast(float.class, _cy)));
 BA.debugLineNum = 147;BA.debugLine="Dim gap As Float";
Debug.ShouldStop(262144);
_gap = RemoteObject.createImmutable(0.0f);Debug.locals.put("gap", _gap);
 BA.debugLineNum = 148;BA.debugLine="gap = Percent * GapDegrees / 2";
Debug.ShouldStop(524288);
_gap = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_percent,_gapdegrees,RemoteObject.createImmutable(2)}, "*/",0, 0));Debug.locals.put("gap", _gap);
 BA.debugLineNum = 149;BA.debugLine="For i = StartingDegree + gap To StartingDegree + b - gap Step 10";
Debug.ShouldStop(1048576);
{
int step55 = 10;
int limit55 = (int) (0 + RemoteObject.solve(new RemoteObject[] {_startingdegree,_b,_gap}, "+-",2, 0).<Number>get().doubleValue());
for (_i = (int) (0 + RemoteObject.solve(new RemoteObject[] {_startingdegree,_gap}, "+",1, 0).<Number>get().doubleValue()); (step55 > 0 && _i <= limit55) || (step55 < 0 && _i >= limit55); _i = ((int)(0 + _i + step55))) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 150;BA.debugLine="p.LineTo(cx + 2 * Radius * SinD(i), cy + 2 * Radius * CosD(i))";
Debug.ShouldStop(2097152);
_p.runVoidMethod ("LineTo::",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_cx,RemoteObject.createImmutable(2),_radius,b4i_piechartmodule.__c.runMethod(true,"SinD:",(Object)(BA.numberCast(double.class, _i)))}, "+**",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_cy,RemoteObject.createImmutable(2),_radius,b4i_piechartmodule.__c.runMethod(true,"CosD:",(Object)(BA.numberCast(double.class, _i)))}, "+**",1, 0))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 152;BA.debugLine="p.LineTo(cx + 2 * Radius * SinD(StartingDegree + b - gap), cy + 2 * Radius * CosD(StartingDegree + b - gap))";
Debug.ShouldStop(8388608);
_p.runVoidMethod ("LineTo::",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_cx,RemoteObject.createImmutable(2),_radius,b4i_piechartmodule.__c.runMethod(true,"SinD:",(Object)(RemoteObject.solve(new RemoteObject[] {_startingdegree,_b,_gap}, "+-",2, 0)))}, "+**",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_cy,RemoteObject.createImmutable(2),_radius,b4i_piechartmodule.__c.runMethod(true,"CosD:",(Object)(RemoteObject.solve(new RemoteObject[] {_startingdegree,_b,_gap}, "+-",2, 0)))}, "+**",1, 0))));
 BA.debugLineNum = 153;BA.debugLine="p.LineTo(cx, cy)";
Debug.ShouldStop(16777216);
_p.runVoidMethod ("LineTo::",(Object)(BA.numberCast(float.class, _cx)),(Object)(BA.numberCast(float.class, _cy)));
 BA.debugLineNum = 154;BA.debugLine="pd.Canvas.ClipPath(p) 'We are limiting the drawings to the required slice";
Debug.ShouldStop(33554432);
_pd.getFieldClass("_piedata", false,"Canvas").runVoidMethod ("ClipPath:",(Object)(_p));
 BA.debugLineNum = 155;BA.debugLine="pd.Canvas.DrawCircle(cx, cy, Radius, Color, True, 0)";
Debug.ShouldStop(67108864);
_pd.getFieldClass("_piedata", false,"Canvas").runVoidMethod ("DrawCircle::::::",(Object)(BA.numberCast(float.class, _cx)),(Object)(BA.numberCast(float.class, _cy)),(Object)(BA.numberCast(float.class, _radius)),(Object)(_color),(Object)(b4i_piechartmodule.__c.runMethod(true,"True")),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 156;BA.debugLine="pd.Canvas.RemoveClip";
Debug.ShouldStop(134217728);
_pd.getFieldClass("_piedata", false,"Canvas").runVoidMethod ("RemoveClip");
 BA.debugLineNum = 157;BA.debugLine="Return b";
Debug.ShouldStop(268435456);
if (true) return _b;
 BA.debugLineNum = 158;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable(0.0f);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createlegend(RemoteObject _pd) throws Exception{
try {
		Debug.PushSubsStack("createLegend (piechartmodule) ","piechartmodule",2,b4i_piechartmodule.ba,b4i_piechartmodule.mostCurrent,160);
if (RapidSub.canDelegate("createlegend")) return b4i_piechartmodule.remoteMe.runUserSub(false, "piechartmodule","createlegend", _pd);
RemoteObject _textheight = RemoteObject.createImmutable(0.0f);
RemoteObject _textwidth = RemoteObject.createImmutable(0.0f);
int _i = 0;
RemoteObject _it = RemoteObject.declareNull("_pieitem");
RemoteObject _iv = RemoteObject.declareNull("B4IImageViewWrapper");
RemoteObject _c = RemoteObject.declareNull("B4ICanvas");
Debug.locals.put("PD", _pd);
 BA.debugLineNum = 160;BA.debugLine="Private Sub createLegend(PD As PieData) As ImageView";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 161;BA.debugLine="If PD.LegendTextSize = 0 Then PD.LegendTextSize = 15";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",_pd.getFieldClass("_piedata", true,"LegendTextSize"),BA.numberCast(double.class, 0))) { 
_pd.setFieldClass("_piedata", "LegendTextSize",BA.numberCast(float.class, 15));};
 BA.debugLineNum = 162;BA.debugLine="Dim textHeight, textWidth As Float";
Debug.ShouldStop(2);
_textheight = RemoteObject.createImmutable(0.0f);Debug.locals.put("textHeight", _textheight);
_textwidth = RemoteObject.createImmutable(0.0f);Debug.locals.put("textWidth", _textwidth);
 BA.debugLineNum = 163;BA.debugLine="textHeight = \"M\".MeasureHeight(Font.CreateNewBold(PD.LegendTextSize))";
Debug.ShouldStop(4);
_textheight = RemoteObject.createImmutable("M").runMethod(true,"MeasureHeight:",(Object)(b4i_piechartmodule.__c.runMethod(false,"Font").runMethod(false,"CreateNewBold:",(Object)(_pd.getFieldClass("_piedata", true,"LegendTextSize")))));Debug.locals.put("textHeight", _textheight);
 BA.debugLineNum = 164;BA.debugLine="For i = 0 To PD.Items.Size - 1";
Debug.ShouldStop(8);
{
int step69 = 1;
int limit69 = RemoteObject.solve(new RemoteObject[] {_pd.getFieldClass("_piedata", false,"Items").runMethod(true,"Size"),RemoteObject.createImmutable(1)}, "-",1, 1).<Number>get().intValue();
for (_i = 0; (step69 > 0 && _i <= limit69) || (step69 < 0 && _i >= limit69); _i = ((int)(0 + _i + step69))) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 165;BA.debugLine="Dim it As PieItem";
Debug.ShouldStop(16);
_it = RemoteObject.createNew("_pieitem");Debug.locals.put("it", _it);
 BA.debugLineNum = 166;BA.debugLine="it = PD.Items.Get(i)";
Debug.ShouldStop(32);
_it = (_pd.getFieldClass("_piedata", false,"Items").runMethod(false,"Get:",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("it", _it);
 BA.debugLineNum = 167;BA.debugLine="textWidth = Max(textWidth, it.Name.MeasureWidth(Font.CreateNewBold(PD.LegendTextSize)))";
Debug.ShouldStop(64);
_textwidth = BA.numberCast(float.class, b4i_piechartmodule.__c.runMethod(true,"Max::",(Object)(BA.numberCast(double.class, _textwidth)),(Object)(BA.numberCast(double.class, _it.getFieldClass("_pieitem", true,"Name").runMethod(true,"MeasureWidth:",(Object)(b4i_piechartmodule.__c.runMethod(false,"Font").runMethod(false,"CreateNewBold:",(Object)(_pd.getFieldClass("_piedata", true,"LegendTextSize")))))))));Debug.locals.put("textWidth", _textwidth);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 169;BA.debugLine="Dim iv As ImageView";
Debug.ShouldStop(256);
_iv = RemoteObject.createNew("B4IImageViewWrapper");Debug.locals.put("iv", _iv);
 BA.debugLineNum = 170;BA.debugLine="iv.Initialize(\"\")";
Debug.ShouldStop(512);
_iv.runVoidMethod ("Initialize::",b4i_piechartmodule.ba,(Object)(BA.ObjectToString("")));
 BA.debugLineNum = 171;BA.debugLine="iv.SetLayoutAnimated(0, 0, 0, 0, textWidth + 20dip, 10dip +(textHeight + 10dip) * PD.Items.Size)";
Debug.ShouldStop(1024);
_iv.runVoidMethod ("SetLayoutAnimated::::::",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_textwidth,b4i_piechartmodule.__c.runMethod(true,"DipToCurrent:",(Object)(BA.numberCast(int.class, 20)))}, "+",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {b4i_piechartmodule.__c.runMethod(true,"DipToCurrent:",(Object)(BA.numberCast(int.class, 10))),(RemoteObject.solve(new RemoteObject[] {_textheight,b4i_piechartmodule.__c.runMethod(true,"DipToCurrent:",(Object)(BA.numberCast(int.class, 10)))}, "+",1, 0)),_pd.getFieldClass("_piedata", false,"Items").runMethod(true,"Size")}, "+*",1, 0))));
 BA.debugLineNum = 172;BA.debugLine="Dim c As Canvas";
Debug.ShouldStop(2048);
_c = RemoteObject.createNew("B4ICanvas");Debug.locals.put("c", _c);
 BA.debugLineNum = 173;BA.debugLine="c.Initialize(iv)";
Debug.ShouldStop(4096);
_c.runVoidMethod ("Initialize:",BA.rdebugUtils.runMethod(false, "ConvertToWrapper::", RemoteObject.createNew("B4IViewWrapper"), (_iv).getObject()));
 BA.debugLineNum = 174;BA.debugLine="c.DrawColor(PD.LegendBackColor)";
Debug.ShouldStop(8192);
_c.runVoidMethod ("DrawColor:",(Object)(_pd.getFieldClass("_piedata", true,"LegendBackColor")));
 BA.debugLineNum = 175;BA.debugLine="For i = 0 To PD.Items.Size - 1";
Debug.ShouldStop(16384);
{
int step80 = 1;
int limit80 = RemoteObject.solve(new RemoteObject[] {_pd.getFieldClass("_piedata", false,"Items").runMethod(true,"Size"),RemoteObject.createImmutable(1)}, "-",1, 1).<Number>get().intValue();
for (_i = 0; (step80 > 0 && _i <= limit80) || (step80 < 0 && _i >= limit80); _i = ((int)(0 + _i + step80))) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 176;BA.debugLine="Dim it As PieItem";
Debug.ShouldStop(32768);
_it = RemoteObject.createNew("_pieitem");Debug.locals.put("it", _it);
 BA.debugLineNum = 177;BA.debugLine="it = PD.Items.Get(i)";
Debug.ShouldStop(65536);
_it = (_pd.getFieldClass("_piedata", false,"Items").runMethod(false,"Get:",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("it", _it);
 BA.debugLineNum = 178;BA.debugLine="c.DrawText(it.Name, 10dip, (i + 1) * (textHeight + 10dip), Font.CreateNewBold(PD.LegendTextSize), _ 			   it.Color, \"LEFT\")";
Debug.ShouldStop(131072);
_c.runVoidMethod ("DrawText::::::",(Object)(_it.getFieldClass("_pieitem", true,"Name")),(Object)(BA.numberCast(float.class, b4i_piechartmodule.__c.runMethod(true,"DipToCurrent:",(Object)(BA.numberCast(int.class, 10))))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1)),(RemoteObject.solve(new RemoteObject[] {_textheight,b4i_piechartmodule.__c.runMethod(true,"DipToCurrent:",(Object)(BA.numberCast(int.class, 10)))}, "+",1, 0))}, "*",0, 0))),(Object)(b4i_piechartmodule.__c.runMethod(false,"Font").runMethod(false,"CreateNewBold:",(Object)(_pd.getFieldClass("_piedata", true,"LegendTextSize")))),(Object)(_it.getFieldClass("_pieitem", true,"Color")),(Object)(BA.ObjectToString("LEFT")));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 181;BA.debugLine="c.Refresh";
Debug.ShouldStop(1048576);
_c.runVoidMethod ("Refresh");
 BA.debugLineNum = 182;BA.debugLine="Return iv";
Debug.ShouldStop(2097152);
if (true) return _iv;
 BA.debugLineNum = 183;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _drawpie(RemoteObject _pd,RemoteObject _backcolor,RemoteObject _createlegendbitmap) throws Exception{
try {
		Debug.PushSubsStack("DrawPie (piechartmodule) ","piechartmodule",2,b4i_piechartmodule.ba,b4i_piechartmodule.mostCurrent,103);
if (RapidSub.canDelegate("drawpie")) return b4i_piechartmodule.remoteMe.runUserSub(false, "piechartmodule","drawpie", _pd, _backcolor, _createlegendbitmap);
RemoteObject _radius = RemoteObject.createImmutable(0);
RemoteObject _total = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _it = RemoteObject.declareNull("_pieitem");
RemoteObject _startingangle = RemoteObject.createImmutable(0.0f);
RemoteObject _gapdegrees = RemoteObject.createImmutable(0);
Debug.locals.put("PD", _pd);
Debug.locals.put("BackColor", _backcolor);
Debug.locals.put("CreateLegendBitmap", _createlegendbitmap);
 BA.debugLineNum = 103;BA.debugLine="Public Sub DrawPie (PD As PieData, BackColor As Int, CreateLegendBitmap As Boolean) As ImageView";
Debug.ShouldStop(64);
 BA.debugLineNum = 104;BA.debugLine="If PD.Items.Size = 0 Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",_pd.getFieldClass("_piedata", false,"Items").runMethod(true,"Size"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 105;BA.debugLine="Log(\"Missing pie values.\")";
Debug.ShouldStop(256);
b4i_piechartmodule.__c.runVoidMethod ("Log:",(Object)(BA.ObjectToString("Missing pie values.")));
 BA.debugLineNum = 106;BA.debugLine="Return Null";
Debug.ShouldStop(512);
if (true) return BA.rdebugUtils.runMethod(false, "ConvertToWrapper::", RemoteObject.createNew("B4IImageViewWrapper"), b4i_piechartmodule.__c.runMethod(false,"Null"));
 };
 BA.debugLineNum = 108;BA.debugLine="PD.Canvas.Initialize(PD.Target)";
Debug.ShouldStop(2048);
_pd.getFieldClass("_piedata", false,"Canvas").runVoidMethod ("Initialize:",BA.rdebugUtils.runMethod(false, "ConvertToWrapper::", RemoteObject.createNew("B4IViewWrapper"), (_pd.getFieldClass("_piedata", false,"Target")).getObject()));
 BA.debugLineNum = 109;BA.debugLine="PD.Canvas.DrawColor(BackColor)";
Debug.ShouldStop(4096);
_pd.getFieldClass("_piedata", false,"Canvas").runVoidMethod ("DrawColor:",(Object)(_backcolor));
 BA.debugLineNum = 110;BA.debugLine="Dim Radius As Int";
Debug.ShouldStop(8192);
_radius = RemoteObject.createImmutable(0);Debug.locals.put("Radius", _radius);
 BA.debugLineNum = 111;BA.debugLine="Radius = Min(PD.Target.Width, PD.Target.Height) * 0.8 / 2";
Debug.ShouldStop(16384);
_radius = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {b4i_piechartmodule.__c.runMethod(true,"Min::",(Object)(BA.numberCast(double.class, _pd.getFieldClass("_piedata", false,"Target").runMethod(true,"Width"))),(Object)(BA.numberCast(double.class, _pd.getFieldClass("_piedata", false,"Target").runMethod(true,"Height")))),RemoteObject.createImmutable(0.8),RemoteObject.createImmutable(2)}, "*/",0, 0));Debug.locals.put("Radius", _radius);
 BA.debugLineNum = 112;BA.debugLine="Dim total As Int";
Debug.ShouldStop(32768);
_total = RemoteObject.createImmutable(0);Debug.locals.put("total", _total);
 BA.debugLineNum = 113;BA.debugLine="For i = 0 To PD.Items.Size - 1";
Debug.ShouldStop(65536);
{
int step24 = 1;
int limit24 = RemoteObject.solve(new RemoteObject[] {_pd.getFieldClass("_piedata", false,"Items").runMethod(true,"Size"),RemoteObject.createImmutable(1)}, "-",1, 1).<Number>get().intValue();
for (_i = 0; (step24 > 0 && _i <= limit24) || (step24 < 0 && _i >= limit24); _i = ((int)(0 + _i + step24))) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 114;BA.debugLine="Dim it As PieItem";
Debug.ShouldStop(131072);
_it = RemoteObject.createNew("_pieitem");Debug.locals.put("it", _it);
 BA.debugLineNum = 115;BA.debugLine="it = PD.Items.Get(i)";
Debug.ShouldStop(262144);
_it = (_pd.getFieldClass("_piedata", false,"Items").runMethod(false,"Get:",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("it", _it);
 BA.debugLineNum = 116;BA.debugLine="total = total + it.Value";
Debug.ShouldStop(524288);
_total = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_total,_it.getFieldClass("_pieitem", true,"Value")}, "+",1, 0));Debug.locals.put("total", _total);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 118;BA.debugLine="Dim startingAngle As Float";
Debug.ShouldStop(2097152);
_startingangle = RemoteObject.createImmutable(0.0f);Debug.locals.put("startingAngle", _startingangle);
 BA.debugLineNum = 119;BA.debugLine="startingAngle = 0";
Debug.ShouldStop(4194304);
_startingangle = BA.numberCast(float.class, 0);Debug.locals.put("startingAngle", _startingangle);
 BA.debugLineNum = 120;BA.debugLine="Dim GapDegrees As Int";
Debug.ShouldStop(8388608);
_gapdegrees = RemoteObject.createImmutable(0);Debug.locals.put("GapDegrees", _gapdegrees);
 BA.debugLineNum = 121;BA.debugLine="If PD.Items.Size = 1 Then GapDegrees = 0 Else GapDegrees = PD.GapDegrees";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_pd.getFieldClass("_piedata", false,"Items").runMethod(true,"Size"),BA.numberCast(double.class, 1))) { 
_gapdegrees = BA.numberCast(int.class, 0);Debug.locals.put("GapDegrees", _gapdegrees);}
else {
_gapdegrees = _pd.getFieldClass("_piedata", true,"GapDegrees");Debug.locals.put("GapDegrees", _gapdegrees);};
 BA.debugLineNum = 122;BA.debugLine="For i = 0 To PD.Items.Size - 1";
Debug.ShouldStop(33554432);
{
int step33 = 1;
int limit33 = RemoteObject.solve(new RemoteObject[] {_pd.getFieldClass("_piedata", false,"Items").runMethod(true,"Size"),RemoteObject.createImmutable(1)}, "-",1, 1).<Number>get().intValue();
for (_i = 0; (step33 > 0 && _i <= limit33) || (step33 < 0 && _i >= limit33); _i = ((int)(0 + _i + step33))) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 123;BA.debugLine="Dim it As PieItem";
Debug.ShouldStop(67108864);
_it = RemoteObject.createNew("_pieitem");Debug.locals.put("it", _it);
 BA.debugLineNum = 124;BA.debugLine="it = PD.Items.Get(i)";
Debug.ShouldStop(134217728);
_it = (_pd.getFieldClass("_piedata", false,"Items").runMethod(false,"Get:",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("it", _it);
 BA.debugLineNum = 125;BA.debugLine="startingAngle = startingAngle + _  			calcSlice(PD, Radius, startingAngle, it.Value / total, it.Color, GapDegrees)";
Debug.ShouldStop(268435456);
_startingangle = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_startingangle,_calcslice(_pd,_radius,_startingangle,BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_it.getFieldClass("_pieitem", true,"Value"),_total}, "/",0, 0)),_it.getFieldClass("_pieitem", true,"Color"),_gapdegrees)}, "+",1, 0));Debug.locals.put("startingAngle", _startingangle);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 128;BA.debugLine="PD.Canvas.Refresh";
Debug.ShouldStop(-2147483648);
_pd.getFieldClass("_piedata", false,"Canvas").runVoidMethod ("Refresh");
 BA.debugLineNum = 129;BA.debugLine="If CreateLegendBitmap Then";
Debug.ShouldStop(1);
if (_createlegendbitmap.getBoolean()) { 
 BA.debugLineNum = 130;BA.debugLine="Return createLegend(PD)";
Debug.ShouldStop(2);
if (true) return _createlegend(_pd);
 }else {
 BA.debugLineNum = 132;BA.debugLine="Return Null";
Debug.ShouldStop(8);
if (true) return BA.rdebugUtils.runMethod(false, "ConvertToWrapper::", RemoteObject.createNew("B4IImageViewWrapper"), b4i_piechartmodule.__c.runMethod(false,"Null"));
 };
 BA.debugLineNum = 134;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Type PieItem (Name As String, Value As Float, Color As Int)";
;
 //BA.debugLineNum = 4;BA.debugLine="Type PieData (Items As List, Target As Panel, Canvas As Canvas, GapDegrees As Int, _ 		LegendTextSize As Float, LegendBackColor As Int)";
;
 //BA.debugLineNum = 6;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}