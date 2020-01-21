
#import "b4i_page2module.h"
#import "b4i_main.h"
#import "b4i_page1module.h"


@implementation b4i_page2module 


+ (instancetype)new {
    static b4i_page2module* shared = nil;
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


- (NSString*)  _showpage2{
[B4IRDebugUtils shared].currentModule=@"page2module";
[B4IRDebugUtils shared].currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Public Sub ShowPage2";
[B4IRDebugUtils shared].currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="If Page2.IsInitialized = False Then";
if ([self._page2 IsInitialized]==[self.__c False]) { 
[B4IRDebugUtils shared].currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="Page2.Initialize(\"Page2\")";
[self._page2 Initialize:self.bi :@"Page2"];
[B4IRDebugUtils shared].currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="Page2.RootPanel.Color = Colors.White";
[[self._page2 RootPanel] setColor:[[self.__c Colors] White]];
[B4IRDebugUtils shared].currentLine=524292;
 //BA.debugLineNum = 524292;BA.debugLine="Page2.RootPanel.LoadLayout(\"Result\")";
[[self._page2 RootPanel] LoadLayout:@"Result" :self.bi];
[B4IRDebugUtils shared].currentLine=524293;
 //BA.debugLineNum = 524293;BA.debugLine="Page2.Title = \"BMI計算結果\"";
[self._page2 setTitle:@"BMI計算結果"];
 };
[B4IRDebugUtils shared].currentLine=524295;
 //BA.debugLineNum = 524295;BA.debugLine="Main.NavControl.ShowPage(Page2)";
[self._main._navcontrol ShowPage:(UIViewController*)((self._page2).object)];
[B4IRDebugUtils shared].currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="lblOutput.Text = \"BMI值：\" & Page1Module.bmiValue";
[self._lbloutput setText:[@[@"BMI值：",[self.bi NumberToString:@(self._page1module._bmivalue)]] componentsJoinedByString:@""]];
[B4IRDebugUtils shared].currentLine=524297;
 //BA.debugLineNum = 524297;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _btnreturn_click{
[B4IRDebugUtils shared].currentModule=@"page2module";
[B4IRDebugUtils shared].currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub btnReturn_Click";
[B4IRDebugUtils shared].currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="Page1Module.ShowPage1()";
[self._page1module _showpage1];
[B4IRDebugUtils shared].currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _page2_resize:(int) _width :(int) _height{
[B4IRDebugUtils shared].currentModule=@"page2module";
[B4IRDebugUtils shared].currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Private Sub Page2_Resize(Width As Int, Height As Int)";
[B4IRDebugUtils shared].currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="Log(\"Page2_Resize...\")";
[self.__c Log:@"Page2_Resize..."];
[B4IRDebugUtils shared].currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _process_globals{
self._main=[b4i_main new];
self._page1module=[b4i_page1module new];
[B4IRDebugUtils shared].currentModule=@"page2module";
[B4IRDebugUtils shared].currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub Process_Globals";
return @"";
}
@end