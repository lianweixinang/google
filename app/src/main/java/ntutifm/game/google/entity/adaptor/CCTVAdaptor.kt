package ntutifm.game.google.entity.adaptor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ntutifm.game.google.apiClass.CCTV
import ntutifm.game.google.databinding.CctvItemBinding

class CCTVAdaptor(private var mList: List<CCTV>, private val itemOnClickListener: View.OnClickListener) :
    RecyclerView.Adapter<CCTVAdaptor.CCTVHolder>() {

    inner class CCTVHolder(binding: CctvItemBinding): RecyclerView.ViewHolder(binding.root){
        val location : TextView = binding.route1
        val url : TextView = binding.route2
        val root = binding.root
    }

    fun submitList(mList: List<CCTV>){
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CCTVAdaptor.CCTVHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = CctvItemBinding.inflate(inflater, parent, false)
        return CCTVHolder(view)
    }

    override fun onBindViewHolder(holder: CCTVAdaptor.CCTVHolder, position: Int) {
        holder.location.text = mList[position].name
        holder.url.text = mList[position].url
        holder.root.tag = mList[position]
        holder.root.setOnClickListener(itemOnClickListener)
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}