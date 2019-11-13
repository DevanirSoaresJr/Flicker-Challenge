package devanir.soaresjunior.mezo_flicker_challenge.ui.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pixelart.week6daily2flikrapi.model.PhotoData
import devanir.soaresjunior.mezo_flicker_challenge.R
import kotlinx.android.synthetic.main.item_rv_photos.view.*

class PhotosAdapter(private val photoData: List<PhotoData>/*, private val photoInofList: InfoData*/, private val listener: OnItemClickedListener):
    RecyclerView.Adapter<PhotosAdapter.ViewHolder> (){
    private lateinit var context: Context
    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {
        context = viewGroup.context
        val binder : PhotosLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.fragment_photos, viewGroup, false)
        return ViewHolder(binder)
    }

    override fun getItemCount(): Int {
        return photoData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val image = photoData[position]
        //val imageInfo = photoInofList
        holder.itemView.apply {

            GlideApp.with(context)
                .load(image.url)
                .override(100,100)
                .into(img_photos)
        }

        holder.itemView.setOnClickListener {
            listener.onItemClickedListener(position)
        }
    }

    class ViewHolder(binder: ImageAdapterLayoutBinding) : RecyclerView.ViewHolder(binder.root)

    interface OnItemClickedListener{
        fun onItemClickedListener(position: Int)
    }

}