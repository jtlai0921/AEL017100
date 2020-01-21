
#import "iCore.h"
@interface LS_result:NSObject
@end

@implementation LS_result

- (void)LS_general:(B4ILayoutData*)views :(int)width :(int)height{
[B4ILayoutBuilder setScaleRate:0.3];
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[result/General script]
[B4ILayoutBuilder scaleAll:views :width :height];

}
@end