#import "iCore.h"
#import "iDebug.h"
@class b4i_main;
@class b4i_piechartmodule;
@class _pieitem;
@class _piedata;
@interface b4i_piechart : B4IStaticModule
- (NSString*)  _page1_resize:(int) _width :(int) _height;
- (NSString*)  _process_globals;
@property (nonatomic)int _q1;
@property (nonatomic)int _q2;
@property (nonatomic)int _q3;
@property (nonatomic)int _q4;
@property (nonatomic)B4IPage* _piechartpage;
@property (nonatomic)B4IPanelWrapper* _pnlpie;
@property (nonatomic)b4i_main* _main;
@property (nonatomic)b4i_piechartmodule* _piechartmodule;
- (NSString*)  _showpiechart;
@end
