package deak.david.mszr.cryptosky.ui.mainScreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import deak.david.mszr.cryptosky.R
import deak.david.mszr.cryptosky.disk.model.DBCoin
import kotlinx.android.synthetic.main.row_item.view.*

class CoinsAdapter(
    private val listener: CoinsItemListener
) : ListAdapter<DBCoin, CoinsAdapter.CoinViewHolder>(CoinsComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.row_item, parent, false)
        return CoinViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val newsItem = getItem(position)

        holder.tvName.text = newsItem.name
        holder.tvRank.text = newsItem.rank
        holder.bDetails.setOnClickListener {
            listener.onItemClick(newsItem.id)
        }
    }

    class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.tvName
        var tvRank: TextView = itemView.tvRank
        var bDetails: TextView = itemView.bDetails
    }

    object CoinsComparator : DiffUtil.ItemCallback<DBCoin>() {
        override fun areItemsTheSame(oldItem: DBCoin, newItem: DBCoin): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DBCoin, newItem: DBCoin): Boolean {
            return oldItem == newItem
        }
    }

    interface CoinsItemListener {
        fun onItemClick(coinId: String)
    }
}