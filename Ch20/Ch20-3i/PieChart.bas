Type=StaticCode
Version=1.8
ModulesStructureVersion=1
B4i=true
@EndOfDesignText@
'Code module

Sub Process_Globals
    Public Q1, Q2, Q3, Q4 As Int
    Private PieChartPage As Page
    Private pnlPie As Panel
End Sub

Public Sub ShowPieChart
    If PieChartPage.IsInitialized = False Then
        PieChartPage.Initialize("PieChartPage")
        PieChartPage.RootPanel.Color = Colors.White
        PieChartPage.Title = "顯示業績統計圖表"
        ' 新增Panel元件
        pnlPie.Initialize("")
        PieChartPage.RootPanel.AddView(pnlPie, 5%x, 5%y, 90%x, 90%y)
	End If
    ' 初始PieData物件
    Dim PD As PieData
    PD.Initialize()
    PD.Target = pnlPie  ' 指定顯示的元件
    ' 新增項目
    PieChartModule.AddPieItem(PD, "第一季: " & Q1 , Q1, 0)
    PieChartModule.AddPieItem(PD, "第二季: " & Q2 , Q2, 0)
    PieChartModule.AddPieItem(PD, "第三季: " & Q3 , Q3, 0)
    PieChartModule.AddPieItem(PD, "第四季: " & Q4 , Q4, 0)
    ' 每一片的間隙, 值0為沒有間隙
    PD.GapDegrees = 10	
    ' 圖例的背景色彩
    PD.LegendBackColor = Colors.ARGB(150, 100, 120, 120)
    ' 繪出派圖, 傳回圖例的ImageView物件
    Dim legend As ImageView
    legend = PieChartModule.DrawPie(PD, Colors.Gray, True)
    If legend.IsInitialized() Then  ' 有圖例
        ' 在派圖新增圖例
        pnlPie.AddView(legend, 2dip,0dip, legend.Width, legend.Height)
    End If		
    Main.NavControl.ShowPage(PieChartPage)
End Sub   

Private Sub Page1_Resize(Width As Int, Height As Int)

End Sub
