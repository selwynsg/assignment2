package com.cs4520.assignment1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductViewAdapter(private val products: List<Product>) :
    RecyclerView.Adapter<ProductViewAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.product_name)
        private val expiryDateTextView: TextView = itemView.findViewById(R.id.product_expiry_date)
        private val priceTextView: TextView = itemView.findViewById(R.id.product_price)
        private val productImageView: ImageView = itemView.findViewById(R.id.product_image)

        fun bind(product: Product) {
            nameTextView.text = product.name
            priceTextView.text = itemView.context.getString(R.string.price, product.price.toString())
            if (product.expiryDate.isNullOrEmpty()) {
                expiryDateTextView.visibility = View.GONE
            } else {
                expiryDateTextView.visibility = View.VISIBLE
                expiryDateTextView.text = itemView.context.getString(R.string.expires,product.expiryDate.toString())
            }

            val (backgroundColor, imageResId) = when (product) {
                is Product.Equipment -> Pair("#E06666", R.drawable.hammer)
                is Product.Food -> Pair("#FFD965", R.drawable.tomato)
            }

            itemView.setBackgroundColor(Color.parseColor(backgroundColor))
            productImageView.setImageResource(imageResId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(listOfProducts[position])
    }

    override fun getItemCount(): Int {
        return listOfProducts.size
    }
}
