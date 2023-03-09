package com.example.costomeview.cusomView


import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import com.example.costomeview.R


class CustomeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,


) : View(context, attrs, defStyle) {

    private var mPaint: Paint? = null
    private var mPaints: Paint? = null
    var text: String? = null
    private var mRect: Rect? = null
    private var mSquareColor = 0
    var textColor = 0
    var mPadding = 0
    var texts="nitesh"

    init {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaints = Paint(Paint.ANTI_ALIAS_FLAG)
        mRect = Rect()

        val ta: TypedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomeView)
        mSquareColor = ta.getColor(R.styleable.CustomeView_attr_color, Color.GRAY)
        textColor = ta.getColor(R.styleable.CustomeView_attr_text_color, Color.BLUE)
        texts= ta.getString(R.styleable.CustomeView_attr_text).toString()
        mPaint!!.color = mSquareColor
        mPaints!!.color=textColor
        ta.recycle()
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val rect = Rect()
        rect.left = 0+mPadding
        rect.right = width-mPadding
        rect.top = 0+mPadding
        rect.bottom = height-mPadding
        mPaints?.let { canvas.drawText(texts, 40f, 0.0F, it) };
        mPaint?.let { canvas.drawRect(rect, it) }
    }
}