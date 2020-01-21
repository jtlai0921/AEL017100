
#import "b4i_page1module.h"
#import "b4i_main.h"
#import "b4i_page2module.h"


@implementation b4i_page1module 


+ (instancetype)new {
    static b4i_page1module* shared = nil;
    if (shared == nil) {
        shared = [self alloc];
        shared.bi = [[B4IShellBI alloc] init:shared];
        shared.__c = [B4ICommon new];
    }
    return shared;
}
- (int)debugAppId {
    return 1577553762;
}


- (NSString*)  _showpage1{
[B4IRDebugUtils shared].currentModule=@"page1module";
[B4IRDebugUtils shared].currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Public Sub ShowPage1";
[B4IRDebugUtils shared].currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="If Page1.IsInitialized = False Then";
if ([self._page1 IsInitialized]==[self.__c False]) { 
[B4IRDebugUtils shared].currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="Page1.Initialize(\"Page1\")";
[self._page1 Initialize:self.bi :@"Page1"];
[B4IRDebugUtils shared].currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="Page1.RootPanel.Color = Colors.White";
[[self._page1 RootPanel] setColor:[[self.__c Colors] White]];
[B4IRDebugUtils shared].currentLine=262148;
 //BA.debugLineNum = 262148;BA.debugLine="Page1.RootPanel.LoadLayout(\"Main\")";
[[self._page1 RootPanel] LoadLayout:@"Main" :self.bi];
[B4IRDebugUtils shared].currentLine=262149;
 //BA.debugLineNum = 262149;BA.debugLine="Page1.Title = \"BMI計算機III\"";
[self._page1 setTitle:@"BMI計算機III"];
 };
[B4IRDebugUtils shared].currentLine=262151;
 //BA.debugLineNum = 262151;BA.debugLine="Main.NavControl.ShowPage(Page1)";
[self._main._navcontrol ShowPage:(UIViewController*)((self._page1).object)];
[B4IRDebugUtils shared].currentLine=262152;
 //BA.debugLineNum = 262152;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _btnbmi_click{
[B4IRDebugUtils shared].currentModule=@"page1module";
double _h = 0.0;
double _w = 0.0;
[B4IRDebugUtils shared].currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub btnBMI_Click";
[B4IRDebugUtils shared].currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="Dim h As Double = txtHeight.Text / 100.0";
_h = [self.bi ObjectToNumber:[self._txtheight Text]].doubleValue/(double)100.0;
[B4IRDebugUtils shared].currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="Dim w As Double = txtWeight.Text";
_w = [self.bi ObjectToNumber:[self._txtweight Text]].doubleValue;
[B4IRDebugUtils shared].currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="bmiValue = w / (h * h)";
self._bmivalue = _w/(double)(_h*_h);
[B4IRDebugUtils shared].currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="Page2Module.ShowPage2()";
[self._page2module _showpage2];
[B4IRDebugUtils shared].currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _page1_resize:(int) _width :(int) _height{
[B4IRDebugUtils shared].currentModule=@"page1module";
[B4IRDebugUtils shared].currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Private Sub Page1_Resize(Width As Int, Height As Int)";
[B4IRDebugUtils shared].currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="Log(\"Page1_Resize...\")";
[self.__c Log:@"Page1_Resize..."];
[B4IRDebugUtils shared].currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _process_globals{
self._main=[b4i_main new];
self._page2module=[b4i_page2module new];
[B4IRDebugUtils shared].currentModule=@"page1module";
[B4IRDebugUtils shared].currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Process_Globals";
return @"";
}
@end