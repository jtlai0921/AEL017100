
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
    return 125425765;
}


- (NSString*)  _application_background{
[B4IRDebugUtils shared].currentModule=@"main";
[B4IRDebugUtils shared].currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Private Sub Application_Background";
[B4IRDebugUtils shared].currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 65541;BA.debugLine="Page1.Title = \"四則計算機\"";
[self._page1 setTitle:@"四則計算機"];
[B4IRDebugUtils shared].currentLine=65542;
 //BA.debugLineNum = 65542;BA.debugLine="NavControl.ShowPage(Page1)";
[self._navcontrol ShowPage:(UIViewController*)((self._page1).object)];
[B4IRDebugUtils shared].currentLine=65543;
 //BA.debugLineNum = 65543;BA.debugLine="pkrOp.SetItems(0, Array As String(\"+\",\"-\",\"*\",\"/\"))";
[self._pkrop SetItems:(int) (0) :[self.bi ArrayToList:[[B4IArray alloc]initObjectsWithData:@[[B4I nilToNSNull:@"+"],[B4I nilToNSNull:@"-"],[B4I nilToNSNull:@"*"],[B4I nilToNSNull:@"/"]]]]];
[B4IRDebugUtils shared].currentLine=65544;
 //BA.debugLineNum = 65544;BA.debugLine="opIndex = 0";
self._opindex = (int) (0);
[B4IRDebugUtils shared].currentLine=65545;
 //BA.debugLineNum = 65545;BA.debugLine="pkrOp.SelectRow(0, opIndex, True)";
[self._pkrop SelectRow:(int) (0) :self._opindex :[self.__c True]];
[B4IRDebugUtils shared].currentLine=65546;
 //BA.debugLineNum = 65546;BA.debugLine="pkrOp.SetRowsHeight(50)";
[self._pkrop SetRowsHeight:(int) (50)];
[B4IRDebugUtils shared].currentLine=65547;
 //BA.debugLineNum = 65547;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _btncal_click{
[B4IRDebugUtils shared].currentModule=@"main";
int _opd1 = 0;
int _opd2 = 0;
double _result = 0.0;
[B4IRDebugUtils shared].currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub btnCal_Click";
[B4IRDebugUtils shared].currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="Dim opd1, opd2 As Int";
_opd1 = 0;
_opd2 = 0;
[B4IRDebugUtils shared].currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="Dim result As Double = 0.0";
_result = 0.0;
[B4IRDebugUtils shared].currentLine=196611;
 //BA.debugLineNum = 196611;BA.debugLine="opd1 = txtOpd1.Text  ' 取得2個運算元";
_opd1 = [self.bi ObjectToNumber:[self._txtopd1 Text]].intValue;
[B4IRDebugUtils shared].currentLine=196612;
 //BA.debugLineNum = 196612;BA.debugLine="opd2 = txtOpd2.Text";
_opd2 = [self.bi ObjectToNumber:[self._txtopd2 Text]].intValue;
[B4IRDebugUtils shared].currentLine=196613;
 //BA.debugLineNum = 196613;BA.debugLine="Select opIndex";
switch (self._opindex) {
case 0:
[B4IRDebugUtils shared].currentLine=196615;
 //BA.debugLineNum = 196615;BA.debugLine="result = opd1 + opd2";
_result = _opd1+_opd2;
 break;
case 1:
[B4IRDebugUtils shared].currentLine=196617;
 //BA.debugLineNum = 196617;BA.debugLine="result = opd1 - opd2";
_result = _opd1-_opd2;
 break;
case 2:
[B4IRDebugUtils shared].currentLine=196619;
 //BA.debugLineNum = 196619;BA.debugLine="result = opd1 * opd2";
_result = _opd1*_opd2;
 break;
case 3:
[B4IRDebugUtils shared].currentLine=196621;
 //BA.debugLineNum = 196621;BA.debugLine="If swhDivide.Value Then";
if ([self._swhdivide Value]) { 
[B4IRDebugUtils shared].currentLine=196622;
 //BA.debugLineNum = 196622;BA.debugLine="result = IntDivide(opd1, opd2) ' 整數除法";
_result = [self _intdivide:_opd1 :_opd2];
 }else {
[B4IRDebugUtils shared].currentLine=196624;
 //BA.debugLineNum = 196624;BA.debugLine="result = opd1 / opd2";
_result = _opd1/(double)_opd2;
 };
 break;
}
;
[B4IRDebugUtils shared].currentLine=196627;
 //BA.debugLineNum = 196627;BA.debugLine="lblOutput.Text = \"運算結果: \" & result";
[self._lbloutput setText:[@[@"運算結果: ",[self.bi NumberToString:@(_result)]] componentsJoinedByString:@""]];
[B4IRDebugUtils shared].currentLine=196628;
 //BA.debugLineNum = 196628;BA.debugLine="End Sub";
return @"";
}
- (int)  _intdivide:(int) _op1 :(int) _op2{
[B4IRDebugUtils shared].currentModule=@"main";
int _result = 0;
[B4IRDebugUtils shared].currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub IntDivide(Op1 As Int, Op2 As Int) As Int";
[B4IRDebugUtils shared].currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="Dim Result As Int";
_result = 0;
[B4IRDebugUtils shared].currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="Result = Op1 / Op2";
_result = (int) (_op1/(double)_op2);
[B4IRDebugUtils shared].currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="Return Result";
if (true) return _result;
[B4IRDebugUtils shared].currentLine=262148;
 //BA.debugLineNum = 262148;BA.debugLine="End Sub";
return 0;
}
- (NSString*)  _page1_resize:(int) _width :(int) _height{
[B4IRDebugUtils shared].currentModule=@"main";
[B4IRDebugUtils shared].currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Private Sub Page1_Resize(Width As Int, Height As Int)";
[B4IRDebugUtils shared].currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _pkrop_itemselected:(int) _column :(int) _row{
[B4IRDebugUtils shared].currentModule=@"main";
[B4IRDebugUtils shared].currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub pkrOp_ItemSelected (Column As Int, Row As Int)";
[B4IRDebugUtils shared].currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="opIndex = Row  ' 取得選擇的運算子索引";
self._opindex = _row;
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