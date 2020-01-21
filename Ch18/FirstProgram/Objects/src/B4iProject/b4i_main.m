
#import "b4i_main.h"


@implementation b4i_main 


+ (instancetype)new {
    static b4i_main* shared = nil;
    if (shared == nil) {
        shared = [self alloc];
        shared.bi = [[B4I alloc] init:shared];
        shared.__c = [B4ICommon new];
    }
    return shared;
}

- (NSString*)  _application_background{
 //BA.debugLineNum = 31;BA.debugLine="Private Sub Application_Background";
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _application_start:(B4INavigationControllerWrapper*) _nav{
[self initializeStaticModules];
 //BA.debugLineNum = 19;BA.debugLine="Private Sub Application_Start (Nav As NavigationController)";
 //BA.debugLineNum = 20;BA.debugLine="NavControl = Nav";
self._navcontrol = _nav;
 //BA.debugLineNum = 21;BA.debugLine="Page1.Initialize(\"Page1\")";
[self._page1 Initialize:self.bi :@"Page1"];
 //BA.debugLineNum = 22;BA.debugLine="Page1.Title = \"Page 1\"";
[self._page1 setTitle:@"Page 1"];
 //BA.debugLineNum = 23;BA.debugLine="Page1.RootPanel.Color = Colors.White";
[[self._page1 RootPanel] setColor:[[self.__c Colors] White]];
 //BA.debugLineNum = 24;BA.debugLine="NavControl.ShowPage(Page1)";
[self._navcontrol ShowPage:(UIViewController*)((self._page1).object)];
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _page1_resize:(int) _width :(int) _height{
 //BA.debugLineNum = 27;BA.debugLine="Private Sub Page1_Resize(Width As Int, Height As Int)";
 //BA.debugLineNum = 28;BA.debugLine="Msgbox(\"我的第一個iOS程式!\", \"Information\")";
[self.__c Msgbox:@"我的第一個iOS程式!" :@"Information"];
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return @"";
}

- (void)initializeStaticModules {
    [[b4i_main new]initializeModule];

}
- (NSString*)  _process_globals{
 //BA.debugLineNum = 10;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 13;BA.debugLine="Public App As Application";
self._app = [B4IApplicationWrapper new];
 //BA.debugLineNum = 14;BA.debugLine="Public NavControl As NavigationController";
self._navcontrol = [B4INavigationControllerWrapper new];
 //BA.debugLineNum = 15;BA.debugLine="Private Page1 As Page";
self._page1 = [B4IPage new];
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return @"";
}
@end
