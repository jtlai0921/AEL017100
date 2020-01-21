Type=StaticCode
Version=3.82
B4A=true
@EndOfDesignText@
'Code module
Sub Process_Globals
	Type PieItem (Name As String, Value As Float, Color As Int) 
	Type PieData (Items As List, Target As Panel, Canvas As Canvas, GapDegrees As Int, _
		LegendTextSize As Float, LegendBackColor As Int)
End Sub

#Region  Pie related methods
Sub AddPieItem(PD As PieData, Name As String, Value As Float, Color As Int)
	If PD.Items.IsInitialized = False Then PD.Items.Initialize
	If Color = 0 Then Color = Colors.RGB(Rnd(0, 255), Rnd(0, 255), Rnd(0, 255))
	Dim i As PieItem
	i.Initialize
	i.Name = Name
	i.Value = Value
	i.Color = Color
	PD.Items.Add(i)
End Sub

#If B4A
Sub DrawPie (PD As PieData, BackColor As Int, CreateLegendBitmap As Boolean) As Bitmap
	If PD.Items.Size = 0 Then
		ToastMessageShow("Missing pie values.", True)
		Return
	End If
	PD.Canvas.Initialize(PD.Target)
	PD.Canvas.DrawColor(BackColor)
	Dim Radius As Int
	Radius = Min(PD.Canvas.Bitmap.Width, PD.Canvas.Bitmap.Height) * 0.8 / 2
	Dim total As Int
	For i = 0 To PD.Items.Size - 1
		Dim it As PieItem
		it = PD.Items.Get(i)
		total = total + it.Value
	Next
	Dim startingAngle As Float
	startingAngle = 0
	Dim GapDegrees As Int
	If PD.Items.Size = 1 Then GapDegrees = 0 Else GapDegrees = PD.GapDegrees
	For i = 0 To PD.Items.Size - 1
		Dim it As PieItem
		it = PD.Items.Get(i)
		startingAngle = startingAngle + _ 
			calcSlice(PD.Canvas, Radius, startingAngle, it.Value / total, it.Color, GapDegrees)
	Next
	PD.Target.Invalidate
	If CreateLegendBitmap Then
		Return createLegend(PD)
	Else
		Return Null
	End If
End Sub

'Draws a single slice
Sub calcSlice(Canvas As Canvas, Radius As Int, _ 
		StartingDegree As Float, Percent As Float, Color As Int, GapDegrees As Int) As Float
	Dim b As Float
	b = 360 * Percent
	
	Dim cx, cy As Int
	cx = Canvas.Bitmap.Width / 2
	cy = Canvas.Bitmap.Height / 2 
	Dim p As Path
	p.Initialize(cx, cy)
	Dim gap As Float
	gap = Percent * GapDegrees / 2
	For i = StartingDegree + gap To StartingDegree + b - gap Step 10
		p.LineTo(cx + 2 * Radius * SinD(i), cy + 2 * Radius * CosD(i))
	Next
	p.LineTo(cx + 2 * Radius * SinD(StartingDegree + b - gap), cy + 2 * Radius * CosD(StartingDegree + b - gap))
	p.LineTo(cx, cy)
	Canvas.ClipPath(p) 'We are limiting the drawings to the required slice
	Canvas.DrawCircle(cx, cy, Radius, Color, True, 0)
	Canvas.RemoveClip
	Return b
End Sub

Sub createLegend(PD As PieData) As Bitmap
	Dim bmp As Bitmap
	If PD.LegendTextSize = 0 Then PD.LegendTextSize = 15
	Dim textHeight, textWidth As Float
	textHeight = PD.Canvas.MeasureStringHeight("M", Typeface.DEFAULT_BOLD, PD.LegendTextSize)
	For i = 0 To PD.Items.Size - 1
		Dim it As PieItem
		it = PD.Items.Get(i)
		textWidth = Max(textWidth, PD.Canvas.MeasureStringWidth(it.Name, Typeface.DEFAULT_BOLD, PD.LegendTextSize))
	Next
	bmp.InitializeMutable(textWidth + 20dip, 10dip +(textHeight + 10dip) * PD.Items.Size)
	Dim c As Canvas
	c.Initialize2(bmp)
	c.DrawColor(PD.LegendBackColor)
	For i = 0 To PD.Items.Size - 1
		Dim it As PieItem
		it = PD.Items.Get(i)
		c.DrawText(it.Name, 10dip, (i + 1) * (textHeight + 10dip), Typeface.DEFAULT_BOLD, PD.LegendTextSize, _
			it.Color, "LEFT")
	Next
	Return bmp
End Sub
#End If

#If B4i
Public Sub DrawPie (PD As PieData, BackColor As Int, CreateLegendBitmap As Boolean) As ImageView
	If PD.Items.Size = 0 Then
		Log("Missing pie values.")
		Return Null
	End If
	PD.Canvas.Initialize(PD.Target)
	PD.Canvas.DrawColor(BackColor)
	Dim Radius As Int
	Radius = Min(PD.Target.Width, PD.Target.Height) * 0.8 / 2
	Dim total As Int
	For i = 0 To PD.Items.Size - 1
		Dim it As PieItem
		it = PD.Items.Get(i)
		total = total + it.Value
	Next
	Dim startingAngle As Float
	startingAngle = 0
	Dim GapDegrees As Int
	If PD.Items.Size = 1 Then GapDegrees = 0 Else GapDegrees = PD.GapDegrees
	For i = 0 To PD.Items.Size - 1
		Dim it As PieItem
		it = PD.Items.Get(i)
		startingAngle = startingAngle + _ 
			calcSlice(PD, Radius, startingAngle, it.Value / total, it.Color, GapDegrees)
	Next
	PD.Canvas.Refresh
	If CreateLegendBitmap Then
		Return createLegend(PD)
	Else
		Return Null
	End If
End Sub

'Draws a single slice
Private Sub calcSlice(pd As PieData, Radius As Int, _ 
		StartingDegree As Float, Percent As Float, Color As Int, GapDegrees As Int) As Float
	Dim b As Float
	b = 360 * Percent
	
	Dim cx, cy As Int
	cx = pd.Target.Width / 2
	cy = pd.Target.Height / 2 
	Dim p As Path
	p.Initialize(cx, cy)
	Dim gap As Float
	gap = Percent * GapDegrees / 2
	For i = StartingDegree + gap To StartingDegree + b - gap Step 10
		p.LineTo(cx + 2 * Radius * SinD(i), cy + 2 * Radius * CosD(i))
	Next
	p.LineTo(cx + 2 * Radius * SinD(StartingDegree + b - gap), cy + 2 * Radius * CosD(StartingDegree + b - gap))
	p.LineTo(cx, cy)
	pd.Canvas.ClipPath(p) 'We are limiting the drawings to the required slice
	pd.Canvas.DrawCircle(cx, cy, Radius, Color, True, 0)
	pd.Canvas.RemoveClip
	Return b
End Sub

Private Sub createLegend(PD As PieData) As ImageView
	If PD.LegendTextSize = 0 Then PD.LegendTextSize = 15
	Dim textHeight, textWidth As Float
    textHeight = "M".MeasureHeight(Font.CreateNewBold(PD.LegendTextSize))
	For i = 0 To PD.Items.Size - 1
		Dim it As PieItem
		it = PD.Items.Get(i)
        textWidth = Max(textWidth, it.Name.MeasureWidth(Font.CreateNewBold(PD.LegendTextSize)))
	Next
	Dim iv As ImageView
	iv.Initialize("")
	iv.SetLayoutAnimated(0, 0, 0, 0, textWidth + 20dip, 10dip +(textHeight + 10dip) * PD.Items.Size)
	Dim c As Canvas
	c.Initialize(iv)
	c.DrawColor(PD.LegendBackColor)
	For i = 0 To PD.Items.Size - 1
		Dim it As PieItem
		it = PD.Items.Get(i)
		   c.DrawText(it.Name, 10dip, (i + 1) * (textHeight + 10dip), Font.CreateNewBold(PD.LegendTextSize), _
			   it.Color, "LEFT")
	Next
	c.Refresh
	Return iv
End Sub
#End If

#End Region




