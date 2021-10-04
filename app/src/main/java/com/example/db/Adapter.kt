package com.example.db

import android.content.ContentValues
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.displayitems.view.*

class Adapter(var list: ArrayList<data>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        fun item(c:data, position: Int){
            itemView.email.text=c.EMAIL
            itemView.fname.text=c.FIRST
            itemView.lname.text=c.LAST
            itemView.number.text=c.MOBILE
            itemView.password.text=c.PASSWORD
            var helper=dbhelper(itemView.context)
            var db=helper.readableDatabase
            itemView.setOnClickListener {
                var back=R.drawable.itembackground
                itemView.itembackground.setBackgroundColor(back)
                Toast.makeText(itemView.context, "${c.EMAIL}", Toast.LENGTH_SHORT).show()
                itemView.visiblebutton.isVisible = true
            }
                itemView.decline.setOnClickListener {
                    db.delete("USER","EMAIL=?", arrayOf(c.EMAIL))
                    list.removeAt(adapterPosition)
                    notifyDataSetChanged()
                    Toast.makeText(itemView.context, "Not allowed", Toast.LENGTH_SHORT).show()

            }

            itemView.visiblebutton.acc.setOnClickListener {
                Toast.makeText(itemView.context, "accepted", Toast.LENGTH_SHORT).show()
                var v=ContentValues()
                v.put("EMAIL",c.EMAIL)
                v.put("FIRSTNAME",c.FIRST)
                v.put("LASTNAME", c.LAST)
                v.put("MOBILE", c.MOBILE)
                v.put("PASSWORD", c.PASSWORD)
                db.insert("ACCEPTED_USERS", null, v)
                Toast.makeText(itemView.context, "${c.EMAIL}", Toast.LENGTH_SHORT).show()
                list.removeAt(adapterPosition)
                notifyDataSetChanged()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.displayitems, parent, false)


        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var a= list[position]
        holder.item(a,position)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}