#import "iCore.h"
#import "iDebug.h"
@class b4i_main;
@class b4i_page2module;
@interface b4i_page1module : B4IStaticModule
- (NSString*)  _btnbmi_click;
- (NSString*)  _page1_resize:(int) _width :(int) _height;
- (NSString*)  _process_globals;
@property (nonatomic)B4IPage* _page1;
@property (nonatomic)B4ITextFieldWrapper* _txtheight;
@property (nonatomic)B4ITextFieldWrapper* _txtweight;
@property (nonatomic)double _bmivalue;
@property (nonatomic)b4i_main* _main;
@property (nonatomic)b4i_page2module* _page2module;
- (NSString*)  _showpage1;
@end
