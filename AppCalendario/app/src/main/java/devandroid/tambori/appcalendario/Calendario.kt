package devandroid.tambori.appcalendario

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate

class Calendario(private val daysOfMonth: ArrayList<String>,
                 private val onItemListener: OnItemListener,
                 private val mes: LocalDate,

) : RecyclerView.Adapter<Mes>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Mes {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.dias, parent, false)
        val layoutParams = view.layoutParams
        layoutParams.height = (parent.height * 0.10).toInt()
        return Mes(view, onItemListener)
    }

    override fun onBindViewHolder(holder: Mes, position: Int) {
        holder.dayOfMonth.text = daysOfMonth[position]
        holder.dayOfMonth.setBackgroundColor(cores(mes,daysOfMonth[position]))
        holder.cor.setCardBackgroundColor(cores(mes,daysOfMonth[position]))
//            when(dias(mes,daysOfMonth[position])){
//                0 -> ContextCompat.getColor(holder.itemView.context, R.color.blue)
//                1 -> ContextCompat.getColor(holder.itemView.context, R.color.yellow)
//                2 -> ContextCompat.getColor(holder.itemView.context, R.color.gray)
//                3 -> ContextCompat.getColor(holder.itemView.context, R.color.gray)
//                else -> ContextCompat.getColor(holder.itemView.context, R.color.gray)
//            })


    }

    override fun getItemCount(): Int {
        return daysOfMonth.size
    }

    interface OnItemListener {
        fun onItemClick(position: Int, dayText: String)
    }

    private fun cores( data : LocalDate, valor: String): Int{
        var result: Int
        if(valor == "")return 0xFFededf2.toInt()
        val dia = valor.toInt()
        // Definindo uma data específica (exemplo: 6 de novembro de 2024)
        val date = LocalDate.of(data.year, data.monthValue, dia)
        // Calculando o número de dias desde 1970-01-01
        var totalDias: Long = date.toEpochDay()
        totalDias %= 4
        result = when ((totalDias % 4).toInt()) {
            0 -> 0xFFededf2.toInt()
            1 -> 0xFFededf2.toInt()
            2 -> 0xFF6c788e.toInt()
            3 -> 0xFFa6aec1.toInt()
            else -> 0xFFededf2.toInt()
      }
        return result

    }

    private fun dias(data : LocalDate, valor: String): Int{
        if(valor == "")return 5
        val dia = valor.toInt()
        // Definindo uma data específica (exemplo: 6 de novembro de 2024)

        val date = LocalDate.of(data.year, data.monthValue, dia)

        // Calculando o número de dias desde 1970-01-01
        var totalDias: Long = date.toEpochDay()
        totalDias %= 4
         return totalDias.toInt()
//        val result = when ((totalDias % 4).toInt()) {
//            0 -> "folga"
//            1 -> "dia"
//            2 -> "noite"
//            3 -> "sai"
//            else -> "ferias"
    //      }



    }

}