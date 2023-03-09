package com.example.costomeview.cusomView

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.costomeview.R

class CustomeImageView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet) :
    ConstraintLayout(context, attributeSet) {
    var customImageWidth: Int = 0
    var customImageHeight: Int = 0


    init {
            inflate(context,R.layout.layout_custome_image_view,this)

            attributeSet.let {
                val attribute=context.obtainStyledAttributes(it,R.styleable.CustomeImageView)
                val image:ImageView=findViewById(R.id.image_view)
                val text:TextView=findViewById(R.id.text_view)
                try {
                   image.setImageDrawable(attribute.getDrawable(R.styleable.CustomeImageView_imageRef))
                    text.text=attribute.getString(R.styleable.CustomeImageView_text)

                    customImageWidth = attribute.getDimensionPixelSize(R.styleable.CustomeImageView_customImageWidth, 100)
                    customImageHeight = attribute.getDimensionPixelSize(R.styleable.CustomeImageView_customImageHeight, 100)


                    val layoutParams = LayoutParams(customImageWidth, customImageHeight)
                    image.layoutParams = layoutParams

                    val cornerRadius = attribute.getDimensionPixelSize(R.styleable.CustomeImageView_customCornerRadius, 0)
                    ?: 0

                    // Set the corner radius of the ImageView
                    image.background = createRoundedCornerDrawable(cornerRadius)

                    val textSize = attribute.getFloat(R.styleable.CustomeImageView_customTextSize, 12f)
                    val textColor = attribute.getColor(R.styleable.CustomeImageView_textColor, Color.BLACK)
                    text.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize)
                    text.setTextColor(textColor)


                }finally {
                    attribute.recycle()
                }
            }

        }
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
    private fun createRoundedCornerDrawable(cornerRadius: Int): Drawable {
        val shape = GradientDrawable()
        shape.shape = GradientDrawable.RECTANGLE
        shape.cornerRadius = cornerRadius.toFloat()
        shape.setColor(Color.WHITE)
        return shape
    }

}