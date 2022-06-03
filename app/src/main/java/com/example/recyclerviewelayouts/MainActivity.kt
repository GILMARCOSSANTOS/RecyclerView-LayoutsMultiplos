package com.example.recyclerviewelayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //        /* Inicializar Funções(): */
//        actionBarCenter()
//        private fun actionBarCenter() {
//            supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
//            supportActionBar?.setCustomView(R.layout.actionbar_center)
//        }


        val items = arrayListOf(
            1 to "Titulo",
            0 to "Item A",
            0 to "Item B",
            0 to "Item C",
            0 to "Item D",
            0 to "Item E"
        )


        val adapter = MyAdapter(items)
        findViewById<RecyclerView>(R.id.rcclrVw_mainActvt).adapter = adapter

    }

    class MyAdapter(private val items: List<Pair<Int, String>>) :
        RecyclerView.Adapter<MyAdapter.Holder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

            return if (viewType == 0) {
                MyContentHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_a, parent, false)
                )

            } else {
                MyHeaderHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_b, parent, false)
                )
            }

        }

        override fun getItemViewType(position: Int): Int {
            return items[position].first
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {

            holder.bind(items[position])

        }

        override fun getItemCount(): Int {
            return items.size
        }


        abstract class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            abstract fun bind(obj: Pair<Int, String>)
        }

        class MyContentHolder(itemView: View) : Holder(itemView) {
            private val textView: TextView = itemView.findViewById(R.id.txtVw_itemA)

            override fun bind(obj: Pair<Int, String>) {
                textView.text = obj.second


            }

        }

        class MyHeaderHolder(itemView: View) : Holder(itemView) {
            override fun bind(obj: Pair<Int, String>) {

            }

            /* Teste de Exclusao*/

//sdad
            ///sadsadasd
            //ss
            //ssss
        }
    }
}