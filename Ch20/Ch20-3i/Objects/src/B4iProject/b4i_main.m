
#import "b4i_main.h"
#import "b4i_piechart.h"
#import "b4i_piechartmodule.h"


@implementation b4i_main 


+ (instancetype)new {
    static b4i_main* shared = nil;
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


- (NSString*)  _application_background{
[B4IRDebugUtils shared].currentModule=@"main";
[B4IRDebugUtils shared].currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Private Sub Application_Background";
[B4IRDebugUtils shared].currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _application_start:(B4INavigationControllerWrapper*) _nav{
[B4IRDebugUtils shared].currentModule=@"main";
[B4IRDebugUtils shared].currentLine=65536;
 //BA.debugLineNum = 65536;BA.debugLine="Private Sub Application_Start (Nav As NavigationController)";
[B4IRDebugUtils shared].currentLine=65537;
 //BA.debugLineNum = 65537;BA.debugLine="NavControl = Nav";
self._navcontrol = _nav;
[B4IRDebugUtils shared].currentLine=65538;
 //BA.debugLineNum = 65538;BA.debugLine="Page1.Initialize(\"Page1\")";
[self._page1 Initialize:self.bi :@"Page1"];
[B4IRDebugUtils shared].currentLine=65539;
 //BA.debugLineNum = 65539;BA.debugLine="Page1.RootPanel.Color = Colors.White";
[[self._page1 RootPanel] setColor:[[self.__c Colors] White]];
[B4IRDebugUtils shared].currentLine=65540;
 //BA.debugLineNum = 65540;BA.debugLine="Page1.RootPanel.LoadLayout(\"Main\")";
[[self._page1 RootPanel] LoadLayout:@"Main" :self.bi];
[B4IRDebugUtils shared].currentLine=65541;
 //BA.debugLineNum = 65541;BA.debugLine="Page1.Title = \"業績統計圖表\"";
[self._page1 setTitle:@"業績統計圖表"];
[B4IRDebugUtils shared].currentLine=65542;
 //BA.debugLineNum = 65542;BA.debugLine="NavControl.ShowPage(Page1)";
[self._navcontrol ShowPage:(UIViewController*)((self._page1).object)];
[B4IRDebugUtils shared].currentLine=65543;
 //BA.debugLineNum = 65543;BA.debugLine="txtQ1.Text = \"234\"    ' 指定初值";
[self._txtq1 setText:@"234"];
[B4IRDebugUtils shared].currentLine=65544;
 //BA.debugLineNum = 65544;BA.debugLine="txtQ2.Text = \"256\"";
[self._txtq2 setText:@"256"];
[B4IRDebugUtils shared].currentLine=65545;
 //BA.debugLineNum = 65545;BA.debugLine="txtQ3.Text = \"453\"";
[self._txtq3 setText:@"453"];
[B4IRDebugUtils shared].currentLine=65546;
 //BA.debugLineNum = 65546;BA.debugLine="txtQ4.Text = \"512\"";
[self._txtq4 setText:@"512"];
[B4IRDebugUtils shared].currentLine=65547;
 //BA.debugLineNum = 65547;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _button1_click{
[B4IRDebugUtils shared].currentModule=@"main";
[B4IRDebugUtils shared].currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Button1_Click";
[B4IRDebugUtils shared].currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="PieChart.Q1 = txtQ1.Text";
self._piechart._q1 = [self.bi ObjectToNumber:[self._txtq1 Text]].intValue;
[B4IRDebugUtils shared].currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="PieChart.Q2 = txtQ2.Text";
self._piechart._q2 = [self.bi ObjectToNumber:[self._txtq2 Text]].intValue;
[B4IRDebugUtils shared].currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="PieChart.Q3 = txtQ3.Text";
self._piechart._q3 = [self.bi ObjectToNumber:[self._txtq3 Text]].intValue;
[B4IRDebugUtils shared].currentLine=262148;
 //BA.debugLineNum = 262148;BA.debugLine="PieChart.Q4 = txtQ4.Text";
self._piechart._q4 = [self.bi ObjectToNumber:[self._txtq4 Text]].intValue;
[B4IRDebugUtils shared].currentLine=262149;
 //BA.debugLineNum = 262149;BA.debugLine="PieChart.ShowPieChart() ' 顯示PieChartPage頁面";
[self._piechart _showpiechart];
[B4IRDebugUtils shared].currentLine=262150;
 //BA.debugLineNum = 262150;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _page1_resize:(int) _width :(int) _height{
[B4IRDebugUtils shared].currentModule=@"main";
[B4IRDebugUtils shared].currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Private Sub Page1_Resize(Width As Int, Height As Int)";
[B4IRDebugUtils shared].currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="End Sub";
return @"";
}

- (void)initializeStaticModules {
    [[b4i_main new]initializeModule];
[[b4i_piechart new]initializeModule];
[[b4i_piechartmodule new]initializeModule];

}
- (NSString*)  _process_globals{
self._piechart=[b4i_piechart new];
self._piechartmodule=[b4i_piechartmodule new];
[B4IRDebugUtils shared].currentModule=@"main";
[B4IRDebugUtils shared].currentLine=0;
 //BA.debugLineNum = 0;BA.debugLine="Sub Process_Globals";
return @"";
}
@end