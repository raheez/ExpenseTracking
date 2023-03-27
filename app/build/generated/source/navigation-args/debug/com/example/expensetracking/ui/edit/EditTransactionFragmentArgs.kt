package com.example.expensetracking.ui.edit

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.example.expensetracking.model.Transactions
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class EditTransactionFragmentArgs(
  public val transactions: Transactions
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(Transactions::class.java)) {
      result.putParcelable("transactions", this.transactions as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Transactions::class.java)) {
      result.putSerializable("transactions", this.transactions as Serializable)
    } else {
      throw UnsupportedOperationException(Transactions::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(Transactions::class.java)) {
      result.set("transactions", this.transactions as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Transactions::class.java)) {
      result.set("transactions", this.transactions as Serializable)
    } else {
      throw UnsupportedOperationException(Transactions::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): EditTransactionFragmentArgs {
      bundle.setClassLoader(EditTransactionFragmentArgs::class.java.classLoader)
      val __transactions : Transactions?
      if (bundle.containsKey("transactions")) {
        if (Parcelable::class.java.isAssignableFrom(Transactions::class.java) ||
            Serializable::class.java.isAssignableFrom(Transactions::class.java)) {
          __transactions = bundle.get("transactions") as Transactions?
        } else {
          throw UnsupportedOperationException(Transactions::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__transactions == null) {
          throw IllegalArgumentException("Argument \"transactions\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"transactions\" is missing and does not have an android:defaultValue")
      }
      return EditTransactionFragmentArgs(__transactions)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        EditTransactionFragmentArgs {
      val __transactions : Transactions?
      if (savedStateHandle.contains("transactions")) {
        if (Parcelable::class.java.isAssignableFrom(Transactions::class.java) ||
            Serializable::class.java.isAssignableFrom(Transactions::class.java)) {
          __transactions = savedStateHandle.get<Transactions?>("transactions")
        } else {
          throw UnsupportedOperationException(Transactions::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__transactions == null) {
          throw IllegalArgumentException("Argument \"transactions\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"transactions\" is missing and does not have an android:defaultValue")
      }
      return EditTransactionFragmentArgs(__transactions)
    }
  }
}
