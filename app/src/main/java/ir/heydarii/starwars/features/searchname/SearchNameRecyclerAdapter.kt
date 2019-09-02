package ir.heydarii.starwars.features.searchname

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.heydarii.starwars.R
import ir.heydarii.starwars.pojo.CharacterSearchResult
import kotlinx.android.synthetic.main.character_search_item.view.*

class SearchNameRecyclerAdapter(
    private val list: List<CharacterSearchResult>,
    private val clickListener: (String) -> Unit
) :
    RecyclerView.Adapter<SearchNameRecyclerAdapter.SearchNameViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchNameViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_search_item, parent, false)
        return SearchNameViewHolder(view, clickListener)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: SearchNameViewHolder, position: Int) {
        holder.bind(list[position])
    }


    class SearchNameViewHolder(
        private val view: View,
        val clickListener: (String) -> Unit
    ) : RecyclerView.ViewHolder(view) {
        fun bind(characterSearchResult: CharacterSearchResult) {
            view.txtName.text =
                view.context.getString(R.string.character_name_is, characterSearchResult.name)
            view.txtBirthDate.text = view.context.getString(
                R.string.character_birth_date_is,
                characterSearchResult.birth_year
            )

            view.setOnClickListener {
                clickListener(characterSearchResult.url)
            }
        }

    }
}