﻿Type=Activity
Version=2.71
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	Dim pnlBars As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
    Activity.Title = "顯示堆疊長條圖"
    ' 建立Panel元件
    pnlBars.Initialize("")
    Activity.AddView(pnlBars, 10%x, 10%y, 80%x, 80%y)
    ' 初始BarData物件
    Dim BD As BarData	
    BD.Initialize()
    BD.Target = pnlBars
    BD.BarsWidth = 15dip
    BD.Stacked = True  ' 是堆疊長條圖
    ' 指定長條色彩, 一組有4個
    Charts.AddBarColor(BD, Colors.Red)
    Charts.AddBarColor(BD, Colors.Blue) 
    Charts.AddBarColor(BD, Colors.Green) 
    Charts.AddBarColor(BD, Colors.Yellow) 
    ' 新增項目 
    Charts.AddBarPoint(BD, 2012, Main.S12)
    Charts.AddBarPoint(BD, 2013, Main.S13)		
    ' 建立Graph物件的長條圖參數
    Dim G As Graph
    G.Initialize()
    G.Title = "業績堆疊長條圖"
    G.XAxis = "年"
    G.YAxis = "萬元"
    G.YStart = 0   ' Y軸最小值
    G.YEnd = 1500  ' Y軸最大值
    G.YInterval = 200  ' 增量
    G.AxisColor = Colors.Black
    Charts.DrawBarsChart(G, BD, Colors.LightGray)
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


