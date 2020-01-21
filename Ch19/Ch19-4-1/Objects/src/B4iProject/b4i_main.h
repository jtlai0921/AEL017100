#import "iCore.h"
#import "iDebug.h"
@interface b4i_main : B4IStaticModule
- (NSString*)  _application_background;
- (NSString*)  _application_start:(B4INavigationControllerWrapper*) _nav;
- (NSString*)  _btnbmi_click;
- (NSString*)  _btnreturn_click;
- (NSString*)  _page1_resize:(int) _width :(int) _height;
- (NSString*)  _page2_resize:(int) _width :(int) _height;
- (NSString*)  _process_globals;
@property (nonatomic)B4IApplicationWrapper* _app;
@property (nonatomic)B4INavigationControllerWrapper* _navcontrol;
@property (nonatomic)B4IPage* _page1;
@property (nonatomic)B4IPage* _page2;
@property (nonatomic)B4ILabelWrapper* _lbloutput;
@property (nonatomic)B4ITextFieldWrapper* _txtheight;
@property (nonatomic)B4ITextFieldWrapper* _txtweight;
@end
