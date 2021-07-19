package com.example.user.anko

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //nge-set main UI jadi layout main activity
        MainUI().setContentView(this)

        //Toast dengan anko commons
        toast("Ini Toast")

        alert{ 

        }

    }

    class MainUI : AnkoComponent<MainActivity>{
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            linearLayout {
                orientation = LinearLayout.VERTICAL

                textView("Hello world")

                imageView(R.drawable.abc_ic_star_black_16dp).lparams(width = matchParent)

                button("alert"){
                    onClick {
                        alert("Muthia cantik kan :) ?"){
                             positiveButton("YES"){
                                toast("jelas laaah...")
                            }
                            negativeButton("NO") {
                                toast("nggak tau maksudnya, soalnya belum pernah liat :D")
                            }
                        }.show()
                    }
                }

                button("progrees"){
                    onClick {
                        indeterminateProgressDialog ("please wait...").show()
                    }
                }

                button("intent"){
                    onClick {
                        
                        //intent
                        startActivity<Main2Activity>()
                    }
                }
            }
        }

    }
}
