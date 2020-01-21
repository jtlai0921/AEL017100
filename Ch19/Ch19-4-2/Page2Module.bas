Type=StaticCode
Version=1.8
ModulesStructureVersion=1
B4i=true
@EndOfDesignText@
'Code module

Sub Process_Globals
    Private Page2 As Page
    Private lblOutput As Label
End Sub

Public Sub ShowPage2
    If Page2.IsInitialized = False Then
        Page2.Initialize("Page2")
        Page2.RootPanel.Color = Colors.White
        Page2.RootPanel.LoadLayout("Result")
        Page2.Title = "BMI計算結果"
    End If
    Main.NavControl.ShowPage(Page2)
    lblOutput.Text = "BMI值：" & Page1Module.bmiValue
End Sub  

Private Sub Page2_Resize(Width As Int, Height As Int)
    Log("Page2_Resize...")
End Sub

Sub btnReturn_Click
    Page1Module.ShowPage1()
End Sub