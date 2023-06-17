package com.baladroid.baseapp.utils

import android.content.Context
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import com.baladroid.baseapp.R

sealed class StringResource {

    data class String(
        @StringRes val id: Int,
        val args: List<*>,
        val upperCase: Boolean? = false,
        @StringRes val placeholder: Int = R.string.empty_dash
    ) : StringResource() {

        constructor(
            @StringRes id: Int,
            vararg args: Any?,
            upperCase: Boolean? = null,
            @StringRes placeholder: Int = R.string.empty_dash
        ) : this(
            id,
            args.asList(),
            upperCase,
            placeholder
        )

        override fun toText(context: Context): kotlin.String {

            return context.getString(
                id,
                *args.map {
                    when (it) {
                        null -> placeholder
                        is StringResource -> it.toText(context)
                        else -> it
                    }
                }.toTypedArray()
            )
        }
    }

    data class Quantity(@PluralsRes val id: Int, val quantity: Int?, @StringRes val placeholder: Int = R.string.empty_dash) : StringResource() {

        override fun toText(context: Context): kotlin.String {
            return if (quantity == null)
                context.resources.getString(placeholder)
            else
                context.resources.getQuantityString(id, quantity, quantity)
        }
    }

    // Convert back to String
    abstract fun toText(context: Context): kotlin.String
}

fun @receiver:StringRes Int.toStrRes(vararg args: Any?): StringResource.String = StringResource.String(this, *args)
fun @receiver:PluralsRes Int.toPluralsRes(quantity: Int): StringResource.Quantity =
    StringResource.Quantity(this, quantity)
