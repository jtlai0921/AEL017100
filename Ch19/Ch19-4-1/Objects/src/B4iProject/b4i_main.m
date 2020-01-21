
#import "b4i_main.h"


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
    return 2145902125;
}


- (NSString*)  _application_background{
[B4IRDebugUtils shared].currentModule=@"main";
[B4IRDebugUtils shared].currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Private Sub Application_Background";
[B4IRDebugUtils shared].currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 65541;BA.debugLine="Page1.Title = \"BMI計算機II\"";
[self._page1 setTitle:@"BMI計算機II"];
[B4IRDebugUtils shared].currentLine=65542;
 //BA.debugLineNum = 65542;BA.debugLine="Page2.Initialize(\"Page2\")";
[self._page2 Initialize:self.bi :@"Page2"];
[B4IRDebugUtils shared].currentLine=65543;
 //BA.debugLineNum = 65543;BA.debugLine="Page2.RootPanel.Color = Colors.White";
[[self._page2 RootPanel] setColor:[[self.__c Colors] White]];
[B4IRDebugUtils shared].currentLine=65544;
 //BA.debugLineNum = 65544;BA.debugLine="Page2.RootPanel.LoadLayout(\"Result\")";
[[self._page2 RootPanel] LoadLayout:@"Result" :self.bi];
[B4IRDebugUtils shared].currentLine=65545;
 //BA.debugLineNum = 65545;BA.debugLine="Page2.Title = \"BMI計算結果\"";
[self._page2 setTitle:@"BMI計算結果"];
[B4IRDebugUtils shared].currentLine=65546;
 //BA.debugLineNum = 65546;BA.debugLine="NavControl.ShowPage(Page1)  ' 顯示Page1頁面";
[self._navcontrol ShowPage:(UIViewController*)((self._page1).object)];
[B4IRDebugUtils shared].currentLine=65547;
 //BA.debugLineNum = 65547;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _btnbmi_click{
[B4IRDebugUtils shared].currentModule=@"main";
double _result = 0.0;
double _h = 0.0;
double _w = 0.0;
[B4IRDebugUtils shared].currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub btnBMI_Click";
[B4IRDebugUtils shared].currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="Dim result As Double";
_result = 0.0;
[B4IRDebugUtils shared].currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="Dim h As Double = txtHeight.Text / 100.0";
_h = [self.bi ObjectToNumber:[self._txtheight Text]].doubleValue/(double)100.0;
[B4IRDebugUtils shared].currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="Dim w As Double = txtWeight.Text";
_w = [self.bi ObjectToNumber:[self._txtweight Text]].doubleValue;
[B4IRDebugUtils shared].currentLine=262148;
 //BA.debugLineNum = 262148;BA.debugLine="result = w / (h * h)        ' 計算BMI值";
_result = _w/(double)(_h*_h);
[B4IRDebugUtils shared].currentLine=262149;
 //BA.debugLineNum = 262149;BA.debugLine="NavControl.ShowPage(Page2)  ' 顯示Page2頁面";
[self._navcontrol ShowPage:(UIViewController*)((self._page2).object)];
[B4IRDebugUtils shared].currentLine=262151;
 //BA.debugLineNum = 262151;BA.debugLine="lblOutput.Text = \"BMI值：\" & result";
[self._lbloutput setText:[@[@"BMI值：",[self.bi NumberToString:@(_result)]] componentsJoinedByString:@""]];
[B4IRDebugUtils shared].currentLine=262152;
 //BA.debugLineNum = 262152;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _btnreturn_click{
[B4IRDebugUtils shared].currentModule=@"main";
[B4IRDebugUtils shared].currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub btnReturn_Click";
[B4IRDebugUtils shared].currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="NavControl.ShowPage(Page1)  ' 顯示Page1頁面";
[self._navcontrol ShowPage:(UIViewController*)((self._page1).object)];
[B4IRDebugUtils shared].currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _page1_resize:(int) _width :(int) _height{
[B4IRDebugUtils shared].currentModule=@"main";
[B4IRDebugUtils shared].currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Private Sub Page1_Resize(Width As Int, Height As Int)";
[B4IRDebugUtils shared].currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _page2_resize:(int) _width :(int) _height{
[B4IRDebugUtils shared].currentModule=@"main";
[B4IRDebugUtils shared].currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Private Sub Page2_Resize(Width As Int, Height As Int)";
[B4IRDebugUtils shared].currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="End Sub";
return @"";
}

- (void)initializeStaticModules {
    [[b4i_main new]initializeModule];

}
- (NSString*)  _process_globals{
[B4IRDebugUtils shared].currentModule=@"main";
[B4IRDebugUtils shared].currentLine=0;
 //BA.debugLineNum = 0;BA.debugLine="Sub Process_Globals";
return @"";
}
@end