
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
    return 1036623288;
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
 //BA.debugLineNum = 65541;BA.debugLine="Page1.Title = \"iOS的警告視窗\"";
[self._page1 setTitle:@"iOS的警告視窗"];
[B4IRDebugUtils shared].currentLine=65542;
 //BA.debugLineNum = 65542;BA.debugLine="NavControl.ShowPage(Page1)";
[self._navcontrol ShowPage:(UIViewController*)((self._page1).object)];
[B4IRDebugUtils shared].currentLine=65543;
 //BA.debugLineNum = 65543;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _button1_click{
[B4IRDebugUtils shared].currentModule=@"main";
[B4IRDebugUtils shared].currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Button1_Click";
[B4IRDebugUtils shared].currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="Msgbox2(\"msgDelete\", \"確認是否刪除項目?\", \"編輯\", Array(\"是\", \"否\"))";
[self.__c Msgbox2:self.bi :@"msgDelete" :@"確認是否刪除項目?" :@"編輯" :[self.bi ArrayToList:[[B4IArray alloc]initObjectsWithData:@[[B4I nilToNSNull:(NSObject*)(@"是")],[B4I nilToNSNull:(NSObject*)(@"否")]]]]];
[B4IRDebugUtils shared].currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="lblOutput.Text = \"已經顯示iOS的警告視窗...\"";
[self._lbloutput setText:@"已經顯示iOS的警告視窗..."];
[B4IRDebugUtils shared].currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _msgdelete_click:(NSString*) _buttontext{
[B4IRDebugUtils shared].currentModule=@"main";
[B4IRDebugUtils shared].currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Private Sub msgDelete_Click(ButtonText As String)";
[B4IRDebugUtils shared].currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="Select ButtonText";
switch ([self.bi switchObjectToInt:_buttontext :@[@"是",@"否"]]) {
case 0:
[B4IRDebugUtils shared].currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="lblOutput.Text = \"確認刪除項目...\"";
[self._lbloutput setText:@"確認刪除項目..."];
 break;
case 1:
[B4IRDebugUtils shared].currentLine=327685;
 //BA.debugLineNum = 327685;BA.debugLine="lblOutput.Text = \"取消刪除項目...\"";
[self._lbloutput setText:@"取消刪除項目..."];
 break;
}
;
[B4IRDebugUtils shared].currentLine=327687;
 //BA.debugLineNum = 327687;BA.debugLine="End Sub";
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

}
- (NSString*)  _process_globals{
[B4IRDebugUtils shared].currentModule=@"main";
[B4IRDebugUtils shared].currentLine=0;
 //BA.debugLineNum = 0;BA.debugLine="Sub Process_Globals";
return @"";
}
@end