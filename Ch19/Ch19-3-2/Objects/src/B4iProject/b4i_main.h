#import "iCore.h"
#import "iDebug.h"
@interface b4i_main : B4IStaticModule
- (NSString*)  _application_background;
- (NSString*)  _application_start:(B4INavigationControllerWrapper*) _nav;
- (NSString*)  _btncal_click;
- (int)  _intdivide:(int) _op1 :(int) _op2;
- (NSString*)  _page1_resize:(int) _width :(int) _height;
- (NSString*)  _pkrop_itemselected:(int) _column :(int) _row;
- (NSString*)  _process_globals;
@property (nonatomic)B4IApplicationWrapper* _app;
@property (nonatomic)B4INavigationControllerWrapper* _navcontrol;
@property (nonatomic)B4IPage* _page1;
@property (nonatomic)B4ILabelWrapper* _lbloutput;
@property (nonatomic)B4IPickerWrapper* _pkrop;
@property (nonatomic)B4ISwitchWrapper* _swhdivide;
@property (nonatomic)B4ITextFieldWrapper* _txtopd1;
@property (nonatomic)B4ITextFieldWrapper* _txtopd2;
@property (nonatomic)int _opindex;
@end
