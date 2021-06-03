package com.adyen.android.assignment.data.source.local.base

import androidx.room.TypeConverter
import com.adyen.android.assignment.domain.model.Category
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class CategoryTypeConverter : KoinComponent {

    private val moshi : Moshi by inject()

    private val categoryType = Types.newParameterizedType(List::class.java, Category::class.java)
    private val categoriesAdapter = moshi.adapter<List<Category>?>(categoryType)

    @TypeConverter
    fun fromJson(string: String): List<Category>? {
        return categoriesAdapter.fromJson(string).orEmpty()
    }

    @TypeConverter
    fun toJson(categories: List<Category>?): String {
        return categoriesAdapter.toJson(categories)
    }
}
