
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
 //BA.debugLineNum = 45;BA.debugLine="Private Sub Application_Background";
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _application_start:(B4INavigationControllerWrapper*) _nav{
[self initializeStaticModules];
 //BA.debugLineNum = 24;BA.debugLine="Private Sub Application_Start (Nav As NavigationController)";
 //BA.debugLineNum = 25;BA.debugLine="NavControl = Nav";
self._navcontrol = _nav;
 //BA.debugLineNum = 26;BA.debugLine="Page1.Initialize(\"Page1\")";
[self._page1 Initialize:self.bi :@"Page1"];
 //BA.debugLineNum = 27;BA.debugLine="Page1.RootPanel.Color = Colors.White";
[[self._page1 RootPanel] setColor:[[self.__c Colors] White]];
 //BA.debugLineNum = 28;BA.debugLine="Page1.RootPanel.LoadLayout(\"Main\")";
[[self._page1 RootPanel] LoadLayout:@"Main" :self.bi];
 //BA.debugLineNum = 29;BA.debugLine="Page1.Title = \"兒童數學訓練\"";
[self._page1 setTitle:@"兒童數學訓練"];
 //BA.debugLineNum = 30;BA.debugLine="NavControl.ShowPage(Page1)";
[self._navcontrol ShowPage:(UIViewController*)((self._page1).object)];
 //BA.debugLineNum = 31;BA.debugLine="NewQuestion";
[self _newquestion];
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _btnaction_click{
 //BA.debugLineNum = 49;BA.debugLine="Sub btnAction_Click";
 //BA.debugLineNum = 50;BA.debugLine="If btnAction.Text = \"回答\" Then";
if ([[self._btnaction Text] isEqual:@"回答"]) { 
 //BA.debugLineNum = 51;BA.debugLine="If edtResult.Text = \"\" Then";
if ([[self._edtresult Text] isEqual:@""]) { 
 //BA.debugLineNum = 52;BA.debugLine="Msgbox(\"沒有輸入答案...\", \"錯誤\")";
[self.__c Msgbox:@"沒有輸入答案..." :@"錯誤"];
 }else {
 //BA.debugLineNum = 54;BA.debugLine="If edtResult.Text = lblNumber1.Text + lblNumber2.Text Then";
if ([[self._edtresult Text] isEqual:[self.bi NumberToString:@([self.bi ObjectToNumber:[self._lblnumber1 Text]].doubleValue+[self.bi ObjectToNumber:[self._lblnumber2 Text]].doubleValue)]]) { 
 //BA.debugLineNum = 55;BA.debugLine="lblResult.Text = \"答對了...\"";
[self._lblresult setText:@"答對了..."];
 //BA.debugLineNum = 56;BA.debugLine="btnAction.Text = \"下一題\"";
[self._btnaction setText:@"下一題"];
 }else {
 //BA.debugLineNum = 58;BA.debugLine="lblResult.Text = \"答錯了, 再試一次..\"";
[self._lblresult setText:@"答錯了, 再試一次.."];
 };
 };
 }else {
 //BA.debugLineNum = 62;BA.debugLine="NewQuestion";
[self _newquestion];
 //BA.debugLineNum = 63;BA.debugLine="btnAction.Text = \"回答\"";
[self._btnaction setText:@"回答"];
 };
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _newquestion{
 //BA.debugLineNum = 34;BA.debugLine="Sub NewQuestion";
 //BA.debugLineNum = 35;BA.debugLine="lblNumber1.Text = Rnd(1, 10)";
[self._lblnumber1 setText:[self.bi NumberToString:@([self.__c Rnd:(int) (1) :(int) (10)])]];
 //BA.debugLineNum = 36;BA.debugLine="lblNumber2.Text = Rnd(1, 10)";
[self._lblnumber2 setText:[self.bi NumberToString:@([self.__c Rnd:(int) (1) :(int) (10)])]];
 //BA.debugLineNum = 37;BA.debugLine="lblResult.Text = \"請輸入答案...\"";
[self._lblresult setText:@"請輸入答案..."];
 //BA.debugLineNum = 38;BA.debugLine="edtResult.Text = \"\"";
[self._edtresult setText:@""];
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _page1_resize:(int) _width :(int) _height{
 //BA.debugLineNum = 41;BA.debugLine="Private Sub Page1_Resize(Width As Int, Height As Int)";
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 17;BA.debugLine="Private btnAction As Button";
self._btnaction = [B4IButtonWrapper new];
 //BA.debugLineNum = 18;BA.debugLine="Private edtResult As TextField";
self._edtresult = [B4ITextFieldWrapper new];
 //BA.debugLineNum = 19;BA.debugLine="Private lblNumber1 As Label";
self._lblnumber1 = [B4ILabelWrapper new];
 //BA.debugLineNum = 20;BA.debugLine="Private lblNumber2 As Label";
self._lblnumber2 = [B4ILabelWrapper new];
 //BA.debugLineNum = 21;BA.debugLine="Private lblResult As Label";
self._lblresult = [B4ILabelWrapper new];
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return @"";
}
@end
