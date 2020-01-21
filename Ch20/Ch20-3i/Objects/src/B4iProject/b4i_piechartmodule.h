#import "iCore.h"
#import "iDebug.h"
@class b4i_main;
@class b4i_piechart;
@class _pieitem;
@class _piedata;
@interface b4i_piechartmodule : B4IStaticModule
- (NSString*)  _addpieitem:(_piedata*) _pd :(NSString*) _name :(float) _value :(int) _color;
- (float)  _calcslice:(_piedata*) _pd :(int) _radius :(float) _startingdegree :(float) _percent :(int) _color :(int) _gapdegrees;
- (B4IImageViewWrapper*)  _createlegend:(_piedata*) _pd;
- (B4IImageViewWrapper*)  _drawpie:(_piedata*) _pd :(int) _backcolor :(BOOL) _createlegendbitmap;
- (NSString*)  _process_globals;
@property (nonatomic)b4i_main* _main;
@property (nonatomic)b4i_piechart* _piechart;
@end
@interface _pieitem:NSObject
@property (nonatomic)BOOL IsInitialized;
@property (nonatomic)NSString* Name;
@property (nonatomic)float Value;
@property (nonatomic)int Color;
-(void)Initialize;
@end
@interface _piedata:NSObject
@property (nonatomic)BOOL IsInitialized;
@property (nonatomic)B4IList* Items;
@property (nonatomic)B4IPanelWrapper* Target;
@property (nonatomic)B4ICanvas* Canvas;
@property (nonatomic)int GapDegrees;
@property (nonatomic)float LegendTextSize;
@property (nonatomic)int LegendBackColor;
-(void)Initialize;
@end
