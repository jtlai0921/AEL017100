#import "iCore.h"
#import "iDebug.h"
@interface b4i_main : B4IStaticModule
- (NSString*)  _application_background;
- (NSString*)  _application_start:(B4INavigationControllerWrapper*) _nav;
- (NSString*)  _button1_click;
- (NSString*)  _button2_click;
- (NSString*)  _button3_click;
- (NSString*)  _button4_click;
- (NSString*)  _button5_click;
- (NSString*)  _button6_click;
- (NSString*)  _page1_resize:(int) _width :(int) _height;
- (NSString*)  _process_globals;
@property (nonatomic)B4IApplicationWrapper* _app;
@property (nonatomic)B4INavigationControllerWrapper* _navcontrol;
@property (nonatomic)B4IPage* _page1;
@property (nonatomic)B4ILabelWrapper* _lbloutput;
@end
