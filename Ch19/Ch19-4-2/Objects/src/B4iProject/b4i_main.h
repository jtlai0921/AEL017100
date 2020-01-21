#import "iCore.h"
#import "iDebug.h"
@class b4i_page1module;
@class b4i_page2module;
@interface b4i_main : B4IStaticModule
- (NSString*)  _application_background;
- (NSString*)  _application_start:(B4INavigationControllerWrapper*) _nav;
- (NSString*)  _process_globals;
@property (nonatomic)B4IApplicationWrapper* _app;
@property (nonatomic)B4INavigationControllerWrapper* _navcontrol;
@property (nonatomic)b4i_page1module* _page1module;
@property (nonatomic)b4i_page2module* _page2module;
@end
