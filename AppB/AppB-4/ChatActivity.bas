Type=Activity
Version=3.2
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
    Dim AStream As AsyncStreams
End Sub

Sub Globals
    Dim txtInput As EditText
    Dim txtLog As EditText
    Dim btnSend As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
    Activity.LoadLayout("Chat")
    Activity.Title = "聊天室"
    If AStream.IsInitialized = False Then
        ' 初始AsyncStreams物件
        AStream.InitializePrefix(Main.bluSPP.InputStream, _
                 True, Main.bluSPP.OutputStream, "AStream")
    End If
    txtLog.Width = 100%x
End Sub

Sub Activity_Resume
	
End Sub

Sub Activity_Pause (UserClosed As Boolean)
    If UserClosed Then
        AStream.Close()
    End If
End Sub

Sub AStream_NewData (Buffer() As Byte)
    ' 讀取訊息
    DisplayMessage("你", BytesToString(Buffer, 0, Buffer.Length, "UTF8"))
End Sub

Sub AStream_Error
    ToastMessageShow("藍芽連線已經中斷...", True)
    btnSend.Enabled = False
    txtInput.Enabled = False
End Sub

Sub AStream_Terminated
    AStream_Error
End Sub

Sub txtInput_EnterPressed
	If btnSend.Enabled = True Then btnSend_Click
End Sub

Sub btnSend_Click
    ' 送出訊息
    AStream.Write(txtInput.Text.GetBytes("UTF8"))
    txtInput.SelectAll
    txtInput.RequestFocus
    DisplayMessage("我", txtInput.Text)
End Sub
' 顯示聊天訊息
Sub DisplayMessage(From As String, Msg As String)
    txtLog.Text = txtLog.Text & From & ": " & Msg & CRLF
    txtLog.SelectionStart = txtLog.Text.Length
End Sub