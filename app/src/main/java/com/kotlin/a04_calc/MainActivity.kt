package com.kotlin.a04_calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val expressionTextView : TextView by lazy {
        findViewById<TextView>(R.id.expressionTextView)
    }
    private val resultTextView : TextView by lazy {
        findViewById<TextView>(R.id.resultTextView)
    }
    var lastIsOperator = false //맨마지막이 operator인지
    var hasOperator = false//이미 연산자를 입력했는지
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        expressionTextView
        resultTextView


    }
    fun buttonClicked(v : View){
        when(v.id){
            R.id.button0 -> numberButtonClicked("0")
            R.id.button1 -> numberButtonClicked("1")
            R.id.button2 -> numberButtonClicked("2")
            R.id.button3 -> numberButtonClicked("3")
            R.id.button4 -> numberButtonClicked("4")
            R.id.button5 -> numberButtonClicked("5")
            R.id.button6 -> numberButtonClicked("6")
            R.id.button7 -> numberButtonClicked("7")
            R.id.button8 -> numberButtonClicked("8")
            R.id.button9 -> numberButtonClicked("9")
            R.id.buttonPlus -> opertorButtonClicked("+")
            R.id.buttonMinus ->opertorButtonClicked("-")
            R.id.buttonMulti ->opertorButtonClicked("*")
            R.id.buttonDiv ->opertorButtonClicked("/")
            R.id.buttonModulo ->opertorButtonClicked("%")
        }
    }
    private fun numberButtonClicked(number : String){
        if (lastIsOperator){
            expressionTextView.append(" ")
            lastIsOperator = false
        }
        val expressionText = expressionTextView.text.split(" ")
        if (expressionText.isNotEmpty() && expressionText.last().length >= 15){
            Toast.makeText(this, "15자리까지밖에 입력할 수 없습니다.",Toast.LENGTH_SHORT).show()
            return
        }else if (expressionText.last().isEmpty() && number == "0" ){
            return
        }
        expressionTextView.append(number)
        //TODO resultTextView에 실시간으로 결과 넣기 .
    }
    private fun opertorButtonClicked(operator : String){
        if (expressionTextView.text.isEmpty()) {
            return
        }
        when{
            lastIsOperator ->{
                val text = expressionTextView.text.toString()
                expressionTextView.text = text.dropLast(1) + operator
            }
            hasOperator ->{
                Toast.makeText(this,"연산자는 한번만 사용할 수 있습니다.",Toast.LENGTH_SHORT).show()
                return
            }
            else ->{
                lastIsOperator = true
                hasOperator = true
                expressionTextView.append(" ${operator}")
            }
        }
        //연산자만 색상을 변경
        val ssb = SpannableStringBuilder(expressionTextView.text)
        ssb.setSpan(
            ForegroundColorSpan(getColor(R.color.green)),
            expressionTextView.text.length-1,
             expressionTextView.text.length,
             Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        expressionTextView.text = ssb
    }
    fun clearButtonClicked(v : View){

    }
    fun historyButtonClicked(v : View){

    }
    fun resultButtonClicked(v : View){

    }
}