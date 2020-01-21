#import "iCore.h"
#import "iDebug.h"
@class b4i_main;
@class b4i_page1module;
@interface b4i_page2module : B4IStaticModule
- (NSString*)  _btnreturn_click;
- (NSString*)  _page2_resize:(int) _width :(int) _height;
- (NSString*)  _process_globals;
@property (nonatomic)B4IPage* _page2;
@property (nonatomic)B4ILabelWrapper* _lbloutput;
@property (nonatomic)b4i_main* _main;
@property (nonatomic)b4i_page1module* _page1module;
- (NSString*)  _showpage2;
@end
