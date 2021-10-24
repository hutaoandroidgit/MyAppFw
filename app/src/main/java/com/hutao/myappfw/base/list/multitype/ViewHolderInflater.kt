package com.nan.xarch.base.list.multitype

import androidx.recyclerview.widget.RecyclerView
import com.hutao.myappfw.base.list.multitype.ItemViewBinder

/**
 * @author Drakeet Xu
 */
abstract class ViewHolderInflater<T, VH : RecyclerView.ViewHolder> : ItemViewBinder<T, VH>()
