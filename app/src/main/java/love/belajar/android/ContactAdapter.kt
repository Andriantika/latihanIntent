package love.belajar.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.contact_list_item.view.*
import love.belajar.git.R

class ContactAdapter(val phoneItemList: List<PhoneData>, val clickListener: (PhoneData) -> Unit):
        RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.contact_list_item, parent, false)
        return PartViewHolder(view)

    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as  PartViewHolder).bind(phoneItemList[position],clickListener)
    }

    override fun getItemCount()=phoneItemList.size

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(phone: PhoneData, clickListener: (PhoneData) -> Unit){

            itemView.tv_part_item_name.text= phone.contactName
            itemView.tv_part_id.text= phone.phone.toString()
            Picasso.get().load(phone.image).resize(50,50).into(itemView.iv_contact_list)
            itemView.setOnClickListener({ clickListener(phone) })
        }
    }
}