
#import "b4i_piechartmodule.h"
#import "b4i_main.h"
#import "b4i_piechart.h"

@implementation _pieitem
-(void)Initialize{
self.IsInitialized = true;
self.Name = @"";
self.Value = 0.0f;
self.Color = 0;
}
- (NSString*)description {
return [B4I TypeToString:self :false];}
@end
@implementation _piedata
-(void)Initialize{
self.IsInitialized = true;
self.Items = [B4IList new];
self.Target = [B4IPanelWrapper new];
self.Canvas = [B4ICanvas new];
self.GapDegrees = 0;
self.LegendTextSize = 0.0f;
self.LegendBackColor = 0;
}
- (NSString*)description {
return [B4I TypeToString:self :false];}
@end

@implementation b4i_piechartmodule 


+ (instancetype)new {
    static b4i_piechartmodule* shared = nil;
    if (shared == nil) {
        shared = [self alloc];
        shared.bi = [[B4IShellBI alloc] init:shared];
        shared.__c = [B4ICommon new];
    }
    return shared;
}
- (int)debugAppId {
    return 533481483;
}


- (NSString*)  _addpieitem:(_piedata*) _pd :(NSString*) _name :(float) _value :(int) _color{
[B4IRDebugUtils shared].currentModule=@"piechartmodule";
_pieitem* _i = nil;
[B4IRDebugUtils shared].currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub AddPieItem(PD As PieData, Name As String, Value As Float, Color As Int)";
[B4IRDebugUtils shared].currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="If PD.Items.IsInitialized = False Then PD.Items.Initialize";
if ([_pd.Items IsInitialized]==[self.__c False]) { 
[_pd.Items Initialize];};
[B4IRDebugUtils shared].currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="If Color = 0 Then Color = Colors.RGB(Rnd(0, 255), Rnd(0, 255), Rnd(0, 255))";
if (_color==0) { 
_color = [[self.__c Colors] RGB:[self.__c Rnd:(int) (0) :(int) (255)] :[self.__c Rnd:(int) (0) :(int) (255)] :[self.__c Rnd:(int) (0) :(int) (255)]];};
[B4IRDebugUtils shared].currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="Dim i As PieItem";
_i = [_pieitem new];
[B4IRDebugUtils shared].currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="i.Initialize";
[_i Initialize];
[B4IRDebugUtils shared].currentLine=589829;
 //BA.debugLineNum = 589829;BA.debugLine="i.Name = Name";
_i.Name = _name;
[B4IRDebugUtils shared].currentLine=589830;
 //BA.debugLineNum = 589830;BA.debugLine="i.Value = Value";
_i.Value = _value;
[B4IRDebugUtils shared].currentLine=589831;
 //BA.debugLineNum = 589831;BA.debugLine="i.Color = Color";
_i.Color = _color;
[B4IRDebugUtils shared].currentLine=589832;
 //BA.debugLineNum = 589832;BA.debugLine="PD.Items.Add(i)";
[_pd.Items Add:(NSObject*)(_i)];
[B4IRDebugUtils shared].currentLine=589833;
 //BA.debugLineNum = 589833;BA.debugLine="End Sub";
return @"";
}
- (B4IImageViewWrapper*)  _drawpie:(_piedata*) _pd :(int) _backcolor :(BOOL) _createlegendbitmap{
[B4IRDebugUtils shared].currentModule=@"piechartmodule";
int _radius = 0;
int _total = 0;
int _i = 0;
_pieitem* _it = nil;
float _startingangle = 0.0f;
int _gapdegrees = 0;
[B4IRDebugUtils shared].currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Public Sub DrawPie (PD As PieData, BackColor As Int, CreateLegendBitmap As Boolean) As ImageView";
[B4IRDebugUtils shared].currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="If PD.Items.Size = 0 Then";
if ([_pd.Items Size]==0) { 
[B4IRDebugUtils shared].currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="Log(\"Missing pie values.\")";
[self.__c Log:@"Missing pie values."];
[B4IRDebugUtils shared].currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="Return Null";
if (true) return (B4IImageViewWrapper*) [B4IObjectWrapper createWrapper:[B4IImageViewWrapper new] object:(UIImageView*)([self.__c Null])];
 };
[B4IRDebugUtils shared].currentLine=655365;
 //BA.debugLineNum = 655365;BA.debugLine="PD.Canvas.Initialize(PD.Target)";
[_pd.Canvas Initialize:(B4IViewWrapper*) [B4IObjectWrapper createWrapper:[B4IViewWrapper new] object:(UIView*)((_pd.Target).object)]];
[B4IRDebugUtils shared].currentLine=655366;
 //BA.debugLineNum = 655366;BA.debugLine="PD.Canvas.DrawColor(BackColor)";
[_pd.Canvas DrawColor:_backcolor];
[B4IRDebugUtils shared].currentLine=655367;
 //BA.debugLineNum = 655367;BA.debugLine="Dim Radius As Int";
_radius = 0;
[B4IRDebugUtils shared].currentLine=655368;
 //BA.debugLineNum = 655368;BA.debugLine="Radius = Min(PD.Target.Width, PD.Target.Height) * 0.8 / 2";
_radius = (int) ([self.__c Min:[_pd.Target Width] :[_pd.Target Height]]*0.8/(double)2);
[B4IRDebugUtils shared].currentLine=655369;
 //BA.debugLineNum = 655369;BA.debugLine="Dim total As Int";
_total = 0;
[B4IRDebugUtils shared].currentLine=655370;
 //BA.debugLineNum = 655370;BA.debugLine="For i = 0 To PD.Items.Size - 1";
{
const int step24 = 1;
const int limit24 = (int) ([_pd.Items Size]-1);
for (_i = (int) (0); (step24 > 0 && _i <= limit24) || (step24 < 0 && _i >= limit24); _i = ((int)(0 + _i + step24))) {
[B4IRDebugUtils shared].currentLine=655371;
 //BA.debugLineNum = 655371;BA.debugLine="Dim it As PieItem";
_it = [_pieitem new];
[B4IRDebugUtils shared].currentLine=655372;
 //BA.debugLineNum = 655372;BA.debugLine="it = PD.Items.Get(i)";
_it = (_pieitem*)([_pd.Items Get:_i]);
[B4IRDebugUtils shared].currentLine=655373;
 //BA.debugLineNum = 655373;BA.debugLine="total = total + it.Value";
_total = (int) (_total+_it.Value);
 }
};
[B4IRDebugUtils shared].currentLine=655375;
 //BA.debugLineNum = 655375;BA.debugLine="Dim startingAngle As Float";
_startingangle = 0.0f;
[B4IRDebugUtils shared].currentLine=655376;
 //BA.debugLineNum = 655376;BA.debugLine="startingAngle = 0";
_startingangle = (float) (0);
[B4IRDebugUtils shared].currentLine=655377;
 //BA.debugLineNum = 655377;BA.debugLine="Dim GapDegrees As Int";
_gapdegrees = 0;
[B4IRDebugUtils shared].currentLine=655378;
 //BA.debugLineNum = 655378;BA.debugLine="If PD.Items.Size = 1 Then GapDegrees = 0 Else GapDegrees = PD.GapDegrees";
if ([_pd.Items Size]==1) { 
_gapdegrees = (int) (0);}
else {
_gapdegrees = _pd.GapDegrees;};
[B4IRDebugUtils shared].currentLine=655379;
 //BA.debugLineNum = 655379;BA.debugLine="For i = 0 To PD.Items.Size - 1";
{
const int step33 = 1;
const int limit33 = (int) ([_pd.Items Size]-1);
for (_i = (int) (0); (step33 > 0 && _i <= limit33) || (step33 < 0 && _i >= limit33); _i = ((int)(0 + _i + step33))) {
[B4IRDebugUtils shared].currentLine=655380;
 //BA.debugLineNum = 655380;BA.debugLine="Dim it As PieItem";
_it = [_pieitem new];
[B4IRDebugUtils shared].currentLine=655381;
 //BA.debugLineNum = 655381;BA.debugLine="it = PD.Items.Get(i)";
_it = (_pieitem*)([_pd.Items Get:_i]);
[B4IRDebugUtils shared].currentLine=655382;
 //BA.debugLineNum = 655382;BA.debugLine="startingAngle = startingAngle + _  			calcSlice(PD, Radius, startingAngle, it.Value / total, it.Color, GapDegrees)";
_startingangle = (float) (_startingangle+[self _calcslice:_pd :_radius :_startingangle :(float) (_it.Value/(double)_total) :_it.Color :_gapdegrees]);
 }
};
[B4IRDebugUtils shared].currentLine=655385;
 //BA.debugLineNum = 655385;BA.debugLine="PD.Canvas.Refresh";
[_pd.Canvas Refresh];
[B4IRDebugUtils shared].currentLine=655386;
 //BA.debugLineNum = 655386;BA.debugLine="If CreateLegendBitmap Then";
if (_createlegendbitmap) { 
[B4IRDebugUtils shared].currentLine=655387;
 //BA.debugLineNum = 655387;BA.debugLine="Return createLegend(PD)";
if (true) return [self _createlegend:_pd];
 }else {
[B4IRDebugUtils shared].currentLine=655389;
 //BA.debugLineNum = 655389;BA.debugLine="Return Null";
if (true) return (B4IImageViewWrapper*) [B4IObjectWrapper createWrapper:[B4IImageViewWrapper new] object:(UIImageView*)([self.__c Null])];
 };
[B4IRDebugUtils shared].currentLine=655391;
 //BA.debugLineNum = 655391;BA.debugLine="End Sub";
return nil;
}
- (float)  _calcslice:(_piedata*) _pd :(int) _radius :(float) _startingdegree :(float) _percent :(int) _color :(int) _gapdegrees{
[B4IRDebugUtils shared].currentModule=@"piechartmodule";
float _b = 0.0f;
int _cx = 0;
int _cy = 0;
B4IPathWrapper* _p = nil;
float _gap = 0.0f;
int _i = 0;
[B4IRDebugUtils shared].currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Private Sub calcSlice(pd As PieData, Radius As Int, _  		StartingDegree As Float, Percent As Float, Color As Int, GapDegrees As Int) As Float";
[B4IRDebugUtils shared].currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="Dim b As Float";
_b = 0.0f;
[B4IRDebugUtils shared].currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="b = 360 * Percent";
_b = (float) (360*_percent);
[B4IRDebugUtils shared].currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="Dim cx, cy As Int";
_cx = 0;
_cy = 0;
[B4IRDebugUtils shared].currentLine=720902;
 //BA.debugLineNum = 720902;BA.debugLine="cx = pd.Target.Width / 2";
_cx = (int) ([_pd.Target Width]/(double)2);
[B4IRDebugUtils shared].currentLine=720903;
 //BA.debugLineNum = 720903;BA.debugLine="cy = pd.Target.Height / 2";
_cy = (int) ([_pd.Target Height]/(double)2);
[B4IRDebugUtils shared].currentLine=720904;
 //BA.debugLineNum = 720904;BA.debugLine="Dim p As Path";
_p = [B4IPathWrapper new];
[B4IRDebugUtils shared].currentLine=720905;
 //BA.debugLineNum = 720905;BA.debugLine="p.Initialize(cx, cy)";
[_p Initialize:(float) (_cx) :(float) (_cy)];
[B4IRDebugUtils shared].currentLine=720906;
 //BA.debugLineNum = 720906;BA.debugLine="Dim gap As Float";
_gap = 0.0f;
[B4IRDebugUtils shared].currentLine=720907;
 //BA.debugLineNum = 720907;BA.debugLine="gap = Percent * GapDegrees / 2";
_gap = (float) (_percent*_gapdegrees/(double)2);
[B4IRDebugUtils shared].currentLine=720908;
 //BA.debugLineNum = 720908;BA.debugLine="For i = StartingDegree + gap To StartingDegree + b - gap Step 10";
{
const int step55 = (int) (10);
const int limit55 = (int) (_startingdegree+_b-_gap);
for (_i = (int) (_startingdegree+_gap); (step55 > 0 && _i <= limit55) || (step55 < 0 && _i >= limit55); _i = ((int)(0 + _i + step55))) {
[B4IRDebugUtils shared].currentLine=720909;
 //BA.debugLineNum = 720909;BA.debugLine="p.LineTo(cx + 2 * Radius * SinD(i), cy + 2 * Radius * CosD(i))";
[_p LineTo:(float) (_cx+2*_radius*[self.__c SinD:_i]) :(float) (_cy+2*_radius*[self.__c CosD:_i])];
 }
};
[B4IRDebugUtils shared].currentLine=720911;
 //BA.debugLineNum = 720911;BA.debugLine="p.LineTo(cx + 2 * Radius * SinD(StartingDegree + b - gap), cy + 2 * Radius * CosD(StartingDegree + b - gap))";
[_p LineTo:(float) (_cx+2*_radius*[self.__c SinD:_startingdegree+_b-_gap]) :(float) (_cy+2*_radius*[self.__c CosD:_startingdegree+_b-_gap])];
[B4IRDebugUtils shared].currentLine=720912;
 //BA.debugLineNum = 720912;BA.debugLine="p.LineTo(cx, cy)";
[_p LineTo:(float) (_cx) :(float) (_cy)];
[B4IRDebugUtils shared].currentLine=720913;
 //BA.debugLineNum = 720913;BA.debugLine="pd.Canvas.ClipPath(p) 'We are limiting the drawings to the required slice";
[_pd.Canvas ClipPath:_p];
[B4IRDebugUtils shared].currentLine=720914;
 //BA.debugLineNum = 720914;BA.debugLine="pd.Canvas.DrawCircle(cx, cy, Radius, Color, True, 0)";
[_pd.Canvas DrawCircle:(float) (_cx) :(float) (_cy) :(float) (_radius) :_color :[self.__c True] :(float) (0)];
[B4IRDebugUtils shared].currentLine=720915;
 //BA.debugLineNum = 720915;BA.debugLine="pd.Canvas.RemoveClip";
[_pd.Canvas RemoveClip];
[B4IRDebugUtils shared].currentLine=720916;
 //BA.debugLineNum = 720916;BA.debugLine="Return b";
if (true) return _b;
[B4IRDebugUtils shared].currentLine=720917;
 //BA.debugLineNum = 720917;BA.debugLine="End Sub";
return 0.0f;
}
- (B4IImageViewWrapper*)  _createlegend:(_piedata*) _pd{
[B4IRDebugUtils shared].currentModule=@"piechartmodule";
float _textheight = 0.0f;
float _textwidth = 0.0f;
int _i = 0;
_pieitem* _it = nil;
B4IImageViewWrapper* _iv = nil;
B4ICanvas* _c = nil;
[B4IRDebugUtils shared].currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Private Sub createLegend(PD As PieData) As ImageView";
[B4IRDebugUtils shared].currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="If PD.LegendTextSize = 0 Then PD.LegendTextSize = 15";
if (_pd.LegendTextSize==0) { 
_pd.LegendTextSize = (float) (15);};
[B4IRDebugUtils shared].currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="Dim textHeight, textWidth As Float";
_textheight = 0.0f;
_textwidth = 0.0f;
[B4IRDebugUtils shared].currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="textHeight = \"M\".MeasureHeight(Font.CreateNewBold(PD.LegendTextSize))";
_textheight = [@"M" MeasureHeight:[[self.__c Font] CreateNewBold:_pd.LegendTextSize]];
[B4IRDebugUtils shared].currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="For i = 0 To PD.Items.Size - 1";
{
const int step69 = 1;
const int limit69 = (int) ([_pd.Items Size]-1);
for (_i = (int) (0); (step69 > 0 && _i <= limit69) || (step69 < 0 && _i >= limit69); _i = ((int)(0 + _i + step69))) {
[B4IRDebugUtils shared].currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="Dim it As PieItem";
_it = [_pieitem new];
[B4IRDebugUtils shared].currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="it = PD.Items.Get(i)";
_it = (_pieitem*)([_pd.Items Get:_i]);
[B4IRDebugUtils shared].currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="textWidth = Max(textWidth, it.Name.MeasureWidth(Font.CreateNewBold(PD.LegendTextSize)))";
_textwidth = (float) ([self.__c Max:_textwidth :[_it.Name MeasureWidth:[[self.__c Font] CreateNewBold:_pd.LegendTextSize]]]);
 }
};
[B4IRDebugUtils shared].currentLine=786441;
 //BA.debugLineNum = 786441;BA.debugLine="Dim iv As ImageView";
_iv = [B4IImageViewWrapper new];
[B4IRDebugUtils shared].currentLine=786442;
 //BA.debugLineNum = 786442;BA.debugLine="iv.Initialize(\"\")";
[_iv Initialize:self.bi :@""];
[B4IRDebugUtils shared].currentLine=786443;
 //BA.debugLineNum = 786443;BA.debugLine="iv.SetLayoutAnimated(0, 0, 0, 0, textWidth + 20dip, 10dip +(textHeight + 10dip) * PD.Items.Size)";
[_iv SetLayoutAnimated:(int) (0) :(float) (0) :(float) (0) :(float) (0) :(float) (_textwidth+[self.__c DipToCurrent:(int) (20)]) :(float) ([self.__c DipToCurrent:(int) (10)]+(_textheight+[self.__c DipToCurrent:(int) (10)])*[_pd.Items Size])];
[B4IRDebugUtils shared].currentLine=786444;
 //BA.debugLineNum = 786444;BA.debugLine="Dim c As Canvas";
_c = [B4ICanvas new];
[B4IRDebugUtils shared].currentLine=786445;
 //BA.debugLineNum = 786445;BA.debugLine="c.Initialize(iv)";
[_c Initialize:(B4IViewWrapper*) [B4IObjectWrapper createWrapper:[B4IViewWrapper new] object:(UIView*)((_iv).object)]];
[B4IRDebugUtils shared].currentLine=786446;
 //BA.debugLineNum = 786446;BA.debugLine="c.DrawColor(PD.LegendBackColor)";
[_c DrawColor:_pd.LegendBackColor];
[B4IRDebugUtils shared].currentLine=786447;
 //BA.debugLineNum = 786447;BA.debugLine="For i = 0 To PD.Items.Size - 1";
{
const int step80 = 1;
const int limit80 = (int) ([_pd.Items Size]-1);
for (_i = (int) (0); (step80 > 0 && _i <= limit80) || (step80 < 0 && _i >= limit80); _i = ((int)(0 + _i + step80))) {
[B4IRDebugUtils shared].currentLine=786448;
 //BA.debugLineNum = 786448;BA.debugLine="Dim it As PieItem";
_it = [_pieitem new];
[B4IRDebugUtils shared].currentLine=786449;
 //BA.debugLineNum = 786449;BA.debugLine="it = PD.Items.Get(i)";
_it = (_pieitem*)([_pd.Items Get:_i]);
[B4IRDebugUtils shared].currentLine=786450;
 //BA.debugLineNum = 786450;BA.debugLine="c.DrawText(it.Name, 10dip, (i + 1) * (textHeight + 10dip), Font.CreateNewBold(PD.LegendTextSize), _ 			   it.Color, \"LEFT\")";
[_c DrawText:_it.Name :(float) ([self.__c DipToCurrent:(int) (10)]) :(float) ((_i+1)*(_textheight+[self.__c DipToCurrent:(int) (10)])) :[[self.__c Font] CreateNewBold:_pd.LegendTextSize] :_it.Color :@"LEFT"];
 }
};
[B4IRDebugUtils shared].currentLine=786453;
 //BA.debugLineNum = 786453;BA.debugLine="c.Refresh";
[_c Refresh];
[B4IRDebugUtils shared].currentLine=786454;
 //BA.debugLineNum = 786454;BA.debugLine="Return iv";
if (true) return _iv;
[B4IRDebugUtils shared].currentLine=786455;
 //BA.debugLineNum = 786455;BA.debugLine="End Sub";
return nil;
}
- (NSString*)  _process_globals{
self._main=[b4i_main new];
self._piechart=[b4i_piechart new];
[B4IRDebugUtils shared].currentModule=@"piechartmodule";
[B4IRDebugUtils shared].currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub Process_Globals";
return @"";
}
@end