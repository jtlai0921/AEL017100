#import "iCore.h"
#import "iDebug.h"
@class b4i_piechart;
@class b4i_piechartmodule;
@class _pieitem;
@class _piedata;
@interface b4i_main : B4IStaticModule
- (NSString*)  _application_background;
- (NSString*)  _application_start:(B4INavigationControllerWrapper*) _nav;
- (NSString*)  _button1_click;
- (NSString*)  _page1_resize:(int) _width :(int) _height;
- (NSString*)  _process_globals;
@property (nonatomic)B4IApplicationWrapper* _app;
@property (nonatomic)B4INavigationControllerWrapper* _navcontrol;
@property (nonatomic)B4IPage* _page1;
@property (nonatomic)B4ITextFieldWrapper* _txtq1;
@property (nonatomic)B4ITextFieldWrapper* _txtq2;
@property (nonatomic)B4ITextFieldWrapper* _txtq3;
@property (nonatomic)B4ITextFieldWrapper* _txtq4;
@property (nonatomic)b4i_piechart* _piechart;
@property (nonatomic)b4i_piechartmodule* _piechartmodule;
@end
