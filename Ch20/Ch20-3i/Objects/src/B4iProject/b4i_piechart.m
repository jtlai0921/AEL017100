
#import "b4i_piechart.h"
#import "b4i_main.h"
#import "b4i_piechartmodule.h"


@implementation b4i_piechart 


+ (instancetype)new {
    static b4i_piechart* shared = nil;
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


- (NSString*)  _showpiechart{
[B4IRDebugUtils shared].currentModule=@"piechart";
_piedata* _pd = nil;
B4IImageViewWrapper* _legend = nil;
[B4IRDebugUtils shared].currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Public Sub ShowPieChart";
[B4IRDebugUtils shared].currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="If PieChartPage.IsInitialized = False Then";
if ([self._piechartpage IsInitialized]==[self.__c False]) { 
[B4IRDebugUtils shared].currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="PieChartPage.Initialize(\"PieChartPage\")";
[self._piechartpage Initialize:self.bi :@"PieChartPage"];
[B4IRDebugUtils shared].currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="PieChartPage.RootPanel.Color = Colors.White";
[[self._piechartpage RootPanel] setColor:[[self.__c Colors] White]];
[B4IRDebugUtils shared].currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="PieChartPage.Title = \"顯示業績統計圖表\"";
[self._piechartpage setTitle:@"顯示業績統計圖表"];
[B4IRDebugUtils shared].currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="pnlPie.Initialize(\"\")";
[self._pnlpie Initialize:self.bi :@""];
[B4IRDebugUtils shared].currentLine=393223;
 //BA.debugLineNum = 393223;BA.debugLine="PieChartPage.RootPanel.AddView(pnlPie, 5%x, 5%y, 90%x, 90%y)";
[[self._piechartpage RootPanel] AddView:(UIView*)((self._pnlpie).object) :[self.__c PerXToCurrent:(float) (5)] :[self.__c PerYToCurrent:(float) (5)] :[self.__c PerXToCurrent:(float) (90)] :[self.__c PerYToCurrent:(float) (90)]];
 };
[B4IRDebugUtils shared].currentLine=393226;
 //BA.debugLineNum = 393226;BA.debugLine="Dim PD As PieData";
_pd = [_piedata new];
[B4IRDebugUtils shared].currentLine=393227;
 //BA.debugLineNum = 393227;BA.debugLine="PD.Initialize()";
[_pd Initialize];
[B4IRDebugUtils shared].currentLine=393228;
 //BA.debugLineNum = 393228;BA.debugLine="PD.Target = pnlPie  ' 指定顯示的元件";
_pd.Target = self._pnlpie;
[B4IRDebugUtils shared].currentLine=393230;
 //BA.debugLineNum = 393230;BA.debugLine="PieChartModule.AddPieItem(PD, \"第一季: \" & Q1 , Q1, 0)";
[self._piechartmodule _addpieitem:_pd :[@[@"第一季: ",[self.bi NumberToString:@(self._q1)]] componentsJoinedByString:@""] :(float) (self._q1) :(int) (0)];
[B4IRDebugUtils shared].currentLine=393231;
 //BA.debugLineNum = 393231;BA.debugLine="PieChartModule.AddPieItem(PD, \"第二季: \" & Q2 , Q2, 0)";
[self._piechartmodule _addpieitem:_pd :[@[@"第二季: ",[self.bi NumberToString:@(self._q2)]] componentsJoinedByString:@""] :(float) (self._q2) :(int) (0)];
[B4IRDebugUtils shared].currentLine=393232;
 //BA.debugLineNum = 393232;BA.debugLine="PieChartModule.AddPieItem(PD, \"第三季: \" & Q3 , Q3, 0)";
[self._piechartmodule _addpieitem:_pd :[@[@"第三季: ",[self.bi NumberToString:@(self._q3)]] componentsJoinedByString:@""] :(float) (self._q3) :(int) (0)];
[B4IRDebugUtils shared].currentLine=393233;
 //BA.debugLineNum = 393233;BA.debugLine="PieChartModule.AddPieItem(PD, \"第四季: \" & Q4 , Q4, 0)";
[self._piechartmodule _addpieitem:_pd :[@[@"第四季: ",[self.bi NumberToString:@(self._q4)]] componentsJoinedByString:@""] :(float) (self._q4) :(int) (0)];
[B4IRDebugUtils shared].currentLine=393235;
 //BA.debugLineNum = 393235;BA.debugLine="PD.GapDegrees = 10";
_pd.GapDegrees = (int) (10);
[B4IRDebugUtils shared].currentLine=393237;
 //BA.debugLineNum = 393237;BA.debugLine="PD.LegendBackColor = Colors.ARGB(150, 100, 120, 120)";
_pd.LegendBackColor = [[self.__c Colors] ARGB:(int) (150) :(int) (100) :(int) (120) :(int) (120)];
[B4IRDebugUtils shared].currentLine=393239;
 //BA.debugLineNum = 393239;BA.debugLine="Dim legend As ImageView";
_legend = [B4IImageViewWrapper new];
[B4IRDebugUtils shared].currentLine=393240;
 //BA.debugLineNum = 393240;BA.debugLine="legend = PieChartModule.DrawPie(PD, Colors.Gray, True)";
_legend = [self._piechartmodule _drawpie:_pd :[[self.__c Colors] Gray] :[self.__c True]];
[B4IRDebugUtils shared].currentLine=393241;
 //BA.debugLineNum = 393241;BA.debugLine="If legend.IsInitialized() Then  ' 有圖例";
if ([_legend IsInitialized]) { 
[B4IRDebugUtils shared].currentLine=393243;
 //BA.debugLineNum = 393243;BA.debugLine="pnlPie.AddView(legend, 2dip,0dip, legend.Width, legend.Height)";
[self._pnlpie AddView:(UIView*)((_legend).object) :(float) ([self.__c DipToCurrent:(int) (2)]) :(float) ([self.__c DipToCurrent:(int) (0)]) :[_legend Width] :[_legend Height]];
 };
[B4IRDebugUtils shared].currentLine=393245;
 //BA.debugLineNum = 393245;BA.debugLine="Main.NavControl.ShowPage(PieChartPage)";
[self._main._navcontrol ShowPage:(UIViewController*)((self._piechartpage).object)];
[B4IRDebugUtils shared].currentLine=393246;
 //BA.debugLineNum = 393246;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _page1_resize:(int) _width :(int) _height{
[B4IRDebugUtils shared].currentModule=@"piechart";
[B4IRDebugUtils shared].currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Private Sub Page1_Resize(Width As Int, Height As Int)";
[B4IRDebugUtils shared].currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _process_globals{
self._main=[b4i_main new];
self._piechartmodule=[b4i_piechartmodule new];
[B4IRDebugUtils shared].currentModule=@"piechart";
[B4IRDebugUtils shared].currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub Process_Globals";
return @"";
}
@end