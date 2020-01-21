Type=StaticCode
Version=1.8
ModulesStructureVersion=1
B4i=true
@EndOfDesignText@
'Code module

Sub Process_Globals
    Private P1 As Page
	Private txtHeight As TextField
	Private txtWeight As TextField
	Public bmiValue As Double
End Sub

Public Sub ShowPage1
    If P1.IsInitialized = False Then
	    P1.Initialize("Page1")
	    P1.RootPanel.Color = Colors.White
	    P1.RootPanel.LoadLayout("Main")
	    P1.Title = "BMI計算機III"
	End If
	Main.NavControl.ShowPage(P1)
End Sub        

Sub btnBMI_Click
	Dim h As Double = txtHeight.Text / 100.0
	Dim w As Double = txtWeight.Text
	bmiValue = w / (h * h)
	Result.ShowPage2()	
End Sub