
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
    return 720194034;
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
 //BA.debugLineNum = 65541;BA.debugLine="Page1.Title = \"檔案讀寫\"";
[self._page1 setTitle:@"檔案讀寫"];
[B4IRDebugUtils shared].currentLine=65542;
 //BA.debugLineNum = 65542;BA.debugLine="NavControl.ShowPage(Page1)";
[self._navcontrol ShowPage:(UIViewController*)((self._page1).object)];
[B4IRDebugUtils shared].currentLine=65543;
 //BA.debugLineNum = 65543;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _button1_click{
[B4IRDebugUtils shared].currentModule=@"main";
NSString* _content = @"";
[B4IRDebugUtils shared].currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub Button1_Click";
[B4IRDebugUtils shared].currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="Dim content As String = \"B4i程式設計\"";
_content = @"B4i程式設計";
[B4IRDebugUtils shared].currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="File.WriteString(File.DirDocuments, \"string.txt\", content)";
[[self.__c File] WriteString:[[self.__c File] DirDocuments] :@"string.txt" :_content];
[B4IRDebugUtils shared].currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="lblOutput.Text = \"已經將字串寫入檔案string.txt...\"";
[self._lbloutput setText:@"已經將字串寫入檔案string.txt..."];
[B4IRDebugUtils shared].currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _button2_click{
[B4IRDebugUtils shared].currentModule=@"main";
NSString* _content = @"";
[B4IRDebugUtils shared].currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub Button2_Click";
[B4IRDebugUtils shared].currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="Dim content As String";
_content = @"";
[B4IRDebugUtils shared].currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="If File.Exists(File.DirDocuments, \"string.txt\") Then";
if ([[self.__c File] Exists:[[self.__c File] DirDocuments] :@"string.txt"]) { 
[B4IRDebugUtils shared].currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="content = File.ReadString(File.DirDocuments, \"string.txt\")";
_content = [[self.__c File] ReadString:[[self.__c File] DirDocuments] :@"string.txt"];
[B4IRDebugUtils shared].currentLine=524292;
 //BA.debugLineNum = 524292;BA.debugLine="lblOutput.Text = content";
[self._lbloutput setText:_content];
 }else {
[B4IRDebugUtils shared].currentLine=524294;
 //BA.debugLineNum = 524294;BA.debugLine="lblOutput.Text = \"檔案：string.txt不存在...\"";
[self._lbloutput setText:@"檔案：string.txt不存在..."];
 };
[B4IRDebugUtils shared].currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _button3_click{
[B4IRDebugUtils shared].currentModule=@"main";
B4IList* _students = nil;
[B4IRDebugUtils shared].currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub Button3_Click";
[B4IRDebugUtils shared].currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="Dim students As List";
_students = [B4IList new];
[B4IRDebugUtils shared].currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="students.Initialize()";
[_students Initialize];
[B4IRDebugUtils shared].currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="students.Add(\"陳會安\")";
[_students Add:(NSObject*)(@"陳會安")];
[B4IRDebugUtils shared].currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="students.Add(\"江小魚\")";
[_students Add:(NSObject*)(@"江小魚")];
[B4IRDebugUtils shared].currentLine=458757;
 //BA.debugLineNum = 458757;BA.debugLine="File.WriteList(File.DirDocuments, \"list.txt\", students)";
[[self.__c File] WriteList:[[self.__c File] DirDocuments] :@"list.txt" :_students];
[B4IRDebugUtils shared].currentLine=458758;
 //BA.debugLineNum = 458758;BA.debugLine="lblOutput.Text = \"已經將List物件寫入檔案list.txt...\"";
[self._lbloutput setText:@"已經將List物件寫入檔案list.txt..."];
[B4IRDebugUtils shared].currentLine=458759;
 //BA.debugLineNum = 458759;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _button4_click{
[B4IRDebugUtils shared].currentModule=@"main";
B4IList* _students = nil;
NSString* _content = @"";
int _i = 0;
[B4IRDebugUtils shared].currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub Button4_Click";
[B4IRDebugUtils shared].currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="Dim students As List";
_students = [B4IList new];
[B4IRDebugUtils shared].currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="Dim content As String = \"\"";
_content = @"";
[B4IRDebugUtils shared].currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="If File.Exists(File.DirDocuments, \"list.txt\") Then";
if ([[self.__c File] Exists:[[self.__c File] DirDocuments] :@"list.txt"]) { 
[B4IRDebugUtils shared].currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="students = File.ReadList(File.DirDocuments, \"list.txt\")";
_students = [[self.__c File] ReadList:[[self.__c File] DirDocuments] :@"list.txt"];
[B4IRDebugUtils shared].currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="For i = 0 To students.Size - 1";
{
const int step45 = 1;
const int limit45 = (int) ([_students Size]-1);
for (_i = (int) (0); (step45 > 0 && _i <= limit45) || (step45 < 0 && _i >= limit45); _i = ((int)(0 + _i + step45))) {
[B4IRDebugUtils shared].currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="content = content & students.Get(i) & CRLF";
_content = [@[_content,[self.bi ObjectToString:[_students Get:_i]],[self.__c CRLF]] componentsJoinedByString:@""];
 }
};
[B4IRDebugUtils shared].currentLine=393224;
 //BA.debugLineNum = 393224;BA.debugLine="lblOutput.Text = content";
[self._lbloutput setText:_content];
 }else {
[B4IRDebugUtils shared].currentLine=393226;
 //BA.debugLineNum = 393226;BA.debugLine="lblOutput.Text = \"檔案：list.txt不存在...\"";
[self._lbloutput setText:@"檔案：list.txt不存在..."];
 };
[B4IRDebugUtils shared].currentLine=393228;
 //BA.debugLineNum = 393228;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _button5_click{
[B4IRDebugUtils shared].currentModule=@"main";
B4IMap* _items = nil;
[B4IRDebugUtils shared].currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub Button5_Click";
[B4IRDebugUtils shared].currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="Dim items As Map";
_items = [B4IMap new];
[B4IRDebugUtils shared].currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="items.Initialize()";
[_items Initialize];
[B4IRDebugUtils shared].currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="items.Put(\"Google\", \"http://www.google.com/\")";
[_items Put:(NSObject*)(@"Google") :(NSObject*)(@"http://www.google.com/")];
[B4IRDebugUtils shared].currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="items.Put(\"Yahoo\", \"http://www.yahoo.com/\")";
[_items Put:(NSObject*)(@"Yahoo") :(NSObject*)(@"http://www.yahoo.com/")];
[B4IRDebugUtils shared].currentLine=327685;
 //BA.debugLineNum = 327685;BA.debugLine="File.WriteMap(File.DirDocuments, \"map.txt\", items)";
[[self.__c File] WriteMap:[[self.__c File] DirDocuments] :@"map.txt" :_items];
[B4IRDebugUtils shared].currentLine=327686;
 //BA.debugLineNum = 327686;BA.debugLine="lblOutput.Text = \"已經將Map物件寫入檔案map.txt...\"";
[self._lbloutput setText:@"已經將Map物件寫入檔案map.txt..."];
[B4IRDebugUtils shared].currentLine=327687;
 //BA.debugLineNum = 327687;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _button6_click{
[B4IRDebugUtils shared].currentModule=@"main";
B4IMap* _items = nil;
NSString* _content = @"";
NSString* _key = @"";
[B4IRDebugUtils shared].currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Button6_Click";
[B4IRDebugUtils shared].currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="Dim items As Map";
_items = [B4IMap new];
[B4IRDebugUtils shared].currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="Dim content As String = \"\"";
_content = @"";
[B4IRDebugUtils shared].currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="If File.Exists(File.DirDocuments, \"list.txt\") Then";
if ([[self.__c File] Exists:[[self.__c File] DirDocuments] :@"list.txt"]) { 
[B4IRDebugUtils shared].currentLine=262148;
 //BA.debugLineNum = 262148;BA.debugLine="items = File.ReadMap(File.DirDocuments, \"map.txt\")";
_items = [[self.__c File] ReadMap:[[self.__c File] DirDocuments] :@"map.txt"];
[B4IRDebugUtils shared].currentLine=262149;
 //BA.debugLineNum = 262149;BA.debugLine="For Each key As String In items.Keys";
id<B4IIterable> group66 = [_items Keys];
int groupLen66 = group66.Size;
for (int index66 = 0;index66 < groupLen66 ;index66++){
_key = [self.bi ObjectToString:[group66 Get:index66]];
[B4IRDebugUtils shared].currentLine=262150;
 //BA.debugLineNum = 262150;BA.debugLine="content = content & key & \"-\" & items.Get(key) & CRLF";
_content = [@[_content,_key,@"-",[self.bi ObjectToString:[_items Get:(NSObject*)(_key)]],[self.__c CRLF]] componentsJoinedByString:@""];
 }
;
[B4IRDebugUtils shared].currentLine=262152;
 //BA.debugLineNum = 262152;BA.debugLine="lblOutput.Text = content";
[self._lbloutput setText:_content];
 }else {
[B4IRDebugUtils shared].currentLine=262154;
 //BA.debugLineNum = 262154;BA.debugLine="lblOutput.Text = \"檔案：map.txt不存在...\"";
[self._lbloutput setText:@"檔案：map.txt不存在..."];
 };
[B4IRDebugUtils shared].currentLine=262156;
 //BA.debugLineNum = 262156;BA.debugLine="End Sub";
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