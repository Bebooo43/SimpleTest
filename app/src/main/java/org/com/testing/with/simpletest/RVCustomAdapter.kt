package org.com.testing.with.simpletest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import org.com.testing.with.simpletest.databinding.CardViewItemBinding

/**
 * TODO: Implement the Adapter that will populate a RecyclerView using the information generated in ViewModel
 * */

class RVCustomAdapter(private val list: List<Article>) :
    RecyclerView.Adapter<RVCustomAdapter.ArticleViewHolder>() {


    class ArticleViewHolder(private val binding: CardViewItemBinding) : ViewHolder(binding.root) {

        fun bind(article: Article){
            binding.also {
                it.mTextViewTitle.text = article.title
                it.mTextViewContent.text = article.content
                Picasso.get()
                    .load(article.imageURL)
                    .into(it.mImageViewCardViewItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = CardViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}