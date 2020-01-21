Type=StaticCode
Version=1.8
ModulesStructureVersion=1
B4i=true
@EndOfDesignText@
'Code module

Sub Process_Globals
    Private Page1 As Page
    Private txtHeight As TextField
    Private txtWeight As TextField
    Public bmiValue As Double
End Sub

Public Sub ShowPage1
    If Page1.IsInitialized = False Then
        Page1.Initialize("Page1")
        Page1.RootPanel.Color = Colors.White
        Page1.RootPanel.LoadLayout("Main")
        Page1.Title = "BMI計算機III"
    End If
    Main.NavControl.ShowPage(Page1)
End Sub   

Private Sub Page1_Resize(Width As Int, Height As Int)
    Log("Page1_Resize...")
End Sub

Sub btnBMI_Click
    Dim h As Double = txtHeight.Text / 100.0
    Dim w As Double = txtWeight.Text
    bmiValue = w / (h * h)
    Page2Module.ShowPage2()	
End Sub