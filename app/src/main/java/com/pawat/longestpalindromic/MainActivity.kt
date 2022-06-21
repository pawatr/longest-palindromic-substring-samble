package com.pawat.longestpalindromic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getResultBtn.setOnClickListener {
            resultTv.text = longestPalindrome(input.text.toString())
        }
    }

    private fun longestPalindrome(s: String): String {
        var longest = ""

        fun check(i: Int, j: Int) {
            var left = i
            var right = j
            while (left >= 0 && right < s.length) {
                if (s[left] != s[right]) break
                if (right - left + 1 > longest.length)
                    longest = s.substring(left..right)
                left--
                right++
            }
        }

        if (s.length % 2 == 0) {
            for (i in s.indices) {
                // จำนวน input เป็นเลขคู่
                check(i, i + 1)
            }
        } else {
            for (i in s.indices) {
                // จำนวน input เป็นเลขคี่
                check(i, i)
            }
        }

        return longest
    }
}