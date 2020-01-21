
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
    return 681214622;
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
 //BA.debugLineNum = 65541;BA.debugLine="Page1.Title = \"繪圖\"";
[self._page1 setTitle:@"繪圖"];
[B4IRDebugUtils shared].currentLine=65542;
 //BA.debugLineNum = 65542;BA.debugLine="NavControl.ShowPage(Page1)";
[self._navcontrol ShowPage:(UIViewController*)((self._page1).object)];
[B4IRDebugUtils shared].currentLine=65543;
 //BA.debugLineNum = 65543;BA.debugLine="bmp.Initialize(File.DirAssets, \"Cow.jpg\")";
[self._bmp Initialize:[[self.__c File] DirAssets] :@"Cow.jpg"];
[B4IRDebugUtils shared].currentLine=65544;
 //BA.debugLineNum = 65544;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _drawing{
[B4IRDebugUtils shared].currentModule=@"main";
B4IRect* _rect1 = nil;
B4IRect* _rect2 = nil;
[B4IRDebugUtils shared].currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub Drawing";
[B4IRDebugUtils shared].currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="cvsGraph.DrawCircle(50, 40, 25, Colors.Red, True, 3)";
[self._cvsgraph DrawCircle:(float) (50) :(float) (40) :(float) (25) :[[self.__c Colors] Red] :[self.__c True] :(float) (3)];
[B4IRDebugUtils shared].currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="Dim rect1 As Rect";
_rect1 = [B4IRect new];
[B4IRDebugUtils shared].currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="rect1.Initialize(20, 80, 150, 140)";
[_rect1 Initialize:(float) (20) :(float) (80) :(float) (150) :(float) (140)];
[B4IRDebugUtils shared].currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="cvsGraph.DrawRect(rect1, Colors.Blue, False, 3)";
[self._cvsgraph DrawRect:_rect1 :[[self.__c Colors] Blue] :[self.__c False] :(float) (3)];
[B4IRDebugUtils shared].currentLine=393224;
 //BA.debugLineNum = 393224;BA.debugLine="cvsGraph.DrawLine(20, 160, 160, 160, Colors.Green, 3)";
[self._cvsgraph DrawLine:(float) (20) :(float) (160) :(float) (160) :(float) (160) :[[self.__c Colors] Green] :(float) (3)];
[B4IRDebugUtils shared].currentLine=393226;
 //BA.debugLineNum = 393226;BA.debugLine="Dim rect2 As Rect";
_rect2 = [B4IRect new];
[B4IRDebugUtils shared].currentLine=393227;
 //BA.debugLineNum = 393227;BA.debugLine="rect2.Initialize(20, 180, 150, 240)";
[_rect2 Initialize:(float) (20) :(float) (180) :(float) (150) :(float) (240)];
[B4IRDebugUtils shared].currentLine=393228;
 //BA.debugLineNum = 393228;BA.debugLine="cvsGraph.DrawBitmap(bmp, rect2)";
[self._cvsgraph DrawBitmap:self._bmp :_rect2];
[B4IRDebugUtils shared].currentLine=393230;
 //BA.debugLineNum = 393230;BA.debugLine="cvsGraph.DrawText(\"B4i程式設計\", 20, 300, Font.CreateNew(20), Colors.Yellow, \"LEFT\")";
[self._cvsgraph DrawText:@"B4i程式設計" :(float) (20) :(float) (300) :[[self.__c Font] CreateNew:(float) (20)] :[[self.__c Colors] Yellow] :@"LEFT"];
[B4IRDebugUtils shared].currentLine=393232;
 //BA.debugLineNum = 393232;BA.debugLine="cvsGraph.Refresh()";
[self._cvsgraph Refresh];
[B4IRDebugUtils shared].currentLine=393233;
 //BA.debugLineNum = 393233;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _page1_resize:(int) _width :(int) _height{
[B4IRDebugUtils shared].currentModule=@"main";
[B4IRDebugUtils shared].currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Private Sub Page1_Resize(Width As Int, Height As Int)";
[B4IRDebugUtils shared].currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="cvsGraph.Initialize(pnlGraph)";
[self._cvsgraph Initialize:(B4IViewWrapper*) [B4IObjectWrapper createWrapper:[B4IViewWrapper new] object:(UIView*)((self._pnlgraph).object)]];
[B4IRDebugUtils shared].currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="Drawing";
[self _drawing];
[B4IRDebugUtils shared].currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="End Sub";
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