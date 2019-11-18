package devanir.soaresjunior.mezo_flicker_challenge.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import devanir.soaresjunior.mezo_flicker_challenge.R
import devanir.soaresjunior.mezo_flicker_challenge.common.GlideApp
import devanir.soaresjunior.mezo_flicker_challenge.data.dto.PhotoDto
import kotlinx.android.synthetic.main.item_rv_photos.view.*

class ImageAdapter(private val listener: OnItemClickedListener):
    RecyclerView.Adapter<ImageAdapter.ViewHolder> (){
    private var photoDto: List<PhotoDto> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_photos, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return photoDto.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(photoDto)

        holder.itemView.setOnClickListener {
            listener.onItemClickedListener(position)
        }
    }

    fun setData(photoDto: List<PhotoDto>){
        this.photoDto = photoDto
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var imageView: ImageView

        fun bind(photoDto: List<PhotoDto>) {
            imageView = itemView.img_photos

            val image = photoDto[position]
            itemView.apply {
                GlideApp.with(context)
                    .load(image.url)
                    .override(100,100)
                    .into(imageView)
            }
        }
    }

    interface OnItemClickedListener{
        fun onItemClickedListener(position: Int)
    }
}
