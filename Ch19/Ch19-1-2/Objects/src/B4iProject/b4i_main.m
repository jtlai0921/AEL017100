
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
    return 1560661745;
}


- (NSString*)  _application_active{
[B4IRDebugUtils shared].currentModule=@"main";
[B4IRDebugUtils shared].currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Private Sub Application_Active";
[B4IRDebugUtils shared].currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="Log(\"執行Application_Active...\")";
[self.__c Log:@"執行Application_Active..."];
[B4IRDebugUtils shared].currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _application_background{
[B4IRDebugUtils shared].currentModule=@"main";
[B4IRDebugUtils shared].currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Private Sub Application_Background";
[B4IRDebugUtils shared].currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="Log(\"執行Application_Background...\")";
[self.__c Log:@"執行Application_Background..."];
[B4IRDebugUtils shared].currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _application_foreground{
[B4IRDebugUtils shared].currentModule=@"main";
[B4IRDebugUtils shared].currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Private Sub Application_Foreground";
[B4IRDebugUtils shared].currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="Log(\"執行Application_Foreground...\")";
[self.__c Log:@"執行Application_Foreground..."];
[B4IRDebugUtils shared].currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _application_inactive{
[B4IRDebugUtils shared].currentModule=@"main";
[B4IRDebugUtils shared].currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Private Sub Application_Inactive";
[B4IRDebugUtils shared].currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="Log(\"執行Application_Inactive...\")";
[self.__c Log:@"執行Application_Inactive..."];
[B4IRDebugUtils shared].currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 65539;BA.debugLine="Page1.Title = \"iOS App的生命周期\"";
[self._page1 setTitle:@"iOS App的生命周期"];
[B4IRDebugUtils shared].currentLine=65540;
 //BA.debugLineNum = 65540;BA.debugLine="Page1.RootPanel.Color = Colors.White";
[[self._page1 RootPanel] setColor:[[self.__c Colors] White]];
[B4IRDebugUtils shared].currentLine=65541;
 //BA.debugLineNum = 65541;BA.debugLine="NavControl.ShowPage(Page1)";
[self._navcontrol ShowPage:(UIViewController*)((self._page1).object)];
[B4IRDebugUtils shared].currentLine=65542;
 //BA.debugLineNum = 65542;BA.debugLine="Log(\"執行Application_Start...\")";
[self.__c Log:@"執行Application_Start..."];
[B4IRDebugUtils shared].currentLine=65543;
 //BA.debugLineNum = 65543;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _page1_resize:(int) _width :(int) _height{
[B4IRDebugUtils shared].currentModule=@"main";
[B4IRDebugUtils shared].currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Private Sub Page1_Resize(Width As Int, Height As Int)";
[B4IRDebugUtils shared].currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Log(\"執行Page1_Resize...\")";
[self.__c Log:@"執行Page1_Resize..."];
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