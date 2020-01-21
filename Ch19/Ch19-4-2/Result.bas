Type=StaticCode
Version=1.8
ModulesStructureVersion=1
B4i=true
@EndOfDesignText@
'Code module

Sub Process_Globals
    Private P2 As Page
	Private lblOutput As Label
End Sub

Public Sub ShowPage2
    If P2.IsInitialized = False Then
	    P2.Initialize("Page2")
	    P2.RootPanel.Color = Colors.White
	    P2.RootPanel.LoadLayout("Result")
	    P2.Title = "BMI計算結果"
	End If
	Main.NavControl.ShowPage(P2)
	lblOutput.Text = "BMI值：" & Page1.bmiValue
End Sub    

Sub btnReturn_Click
	Page1.ShowPage1()
End Sub