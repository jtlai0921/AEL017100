#import "iCore.h"
@interface b4i_main : B4IStaticModule
- (NSString*)  _application_background;
- (NSString*)  _application_start:(B4INavigationControllerWrapper*) _nav;
- (NSString*)  _btnaction_click;
- (NSString*)  _newquestion;
- (NSString*)  _page1_resize:(int) _width :(int) _height;
- (NSString*)  _process_globals;
@property (nonatomic)B4IApplicationWrapper* _app;
@property (nonatomic)B4INavigationControllerWrapper* _navcontrol;
@property (nonatomic)B4IPage* _page1;
@property (nonatomic)B4IButtonWrapper* _btnaction;
@property (nonatomic)B4ITextFieldWrapper* _edtresult;
@property (nonatomic)B4ILabelWrapper* _lblnumber1;
@property (nonatomic)B4ILabelWrapper* _lblnumber2;
@property (nonatomic)B4ILabelWrapper* _lblresult;
@end
