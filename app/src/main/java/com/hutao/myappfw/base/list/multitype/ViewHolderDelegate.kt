package com.nan.xarch.base.list.multitype

import androidx.recyclerview.widget.RecyclerView
import com.hutao.myappfw.base.list.multitype.ItemViewDelegate

/**
 * @author Drakeet Xu
 */
abstract class ViewHolderDelegate<T, VH : RecyclerView.ViewHolder> : ItemViewDelegate<T, VH>()
