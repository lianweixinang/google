package ntutifm.game.google.entity.adaptor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import ntutifm.game.google.R
import ntutifm.game.google.apiClass.RoadFavorite
import ntutifm.game.google.databinding.RoadItemBinding
import ntutifm.game.google.entity.sync.SyncPosition

class RoadFavoriteAdaptor(private var mList: List<RoadFavorite>, private val itemOnClickListener: View.OnClickListener) :
    RecyclerView.Adapter<RoadFavoriteAdaptor.ParkingHolder>() {

    inner class ParkingHolder(binding: RoadItemBinding): RecyclerView.ViewHolder(binding.root){
        val type : TextView = itemView.findViewById(R.id.title1)
        val description : TextView = itemView.findViewById(R.id.content1)
        val root : MaterialCardView = itemView.findViewById(R.id.root)
    }

    fun submitList(mList: List<RoadFavorite>){
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoadFavoriteAdaptor.ParkingHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = RoadItemBinding.inflate(inflater, parent, false)
        return ParkingHolder(view)
    }

    override fun onBindViewHolder(holder: RoadFavoriteAdaptor.ParkingHolder, position: Int) {
        holder.type.text = mList?.get(position)?.roadName
        holder.description.text = mList?.get(position)?.roadName

        holder.root.tag = mList?.get(position) ?: "22"
        holder.root.setOnClickListener(itemOnClickListener)

        val index = SyncPosition.districtToIndex()
    }

    override fun getItemCount(): Int {
        return mList?.size ?: 0
    }
}