package com.example.expensetracking.ui.adapter

import android.view.LayoutInflater
import android.view.SurfaceControl.Transaction
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.expensetracking.databinding.AdapterTransactionsListItemBinding
import com.example.expensetracking.model.Transactions

class TransactionsAdapter : RecyclerView.Adapter<TransactionsAdapter.TransactionViewHolder>() {

    class TransactionViewHolder(val binding: AdapterTransactionsListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Transactions>(){
        override fun areItemsTheSame(oldItem: Transactions, newItem: Transactions): Boolean {
            return oldItem.mID == newItem.mID
        }

        override fun areContentsTheSame(oldItem: Transactions, newItem: Transactions): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val mView = AdapterTransactionsListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TransactionViewHolder(mView)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {

        val item = differ.currentList[position]
        holder.binding.apply {

            differ.currentList.get(position).let {
                amountTv.setText(it.amount.toString() ?: "")
                typeTv.setText(it.transactionType.toString()?:"")
            }

            holder.itemView.setOnClickListener {
                onItemClickListener?.let { it(item) }
            }

        }
    }

    private var onItemClickListener: ((Transactions)->Unit) ? =null
     fun setOnClickListener(listener: (Transactions) -> Unit) {
        onItemClickListener = listener
    }


}