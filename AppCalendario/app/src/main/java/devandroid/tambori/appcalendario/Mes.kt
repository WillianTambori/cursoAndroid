package devandroid.tambori.appcalendario

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Mes( itemView: View,
           private val onItemListener: Calendario.OnItemListener
) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    val dayOfMonth: TextView = itemView.findViewById(R.id.cellDayText)
    val cor: androidx.cardview.widget.CardView = itemView.findViewById(R.id.cardText)

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        onItemListener.onItemClick(adapterPosition, dayOfMonth.text.toString())
    }

}