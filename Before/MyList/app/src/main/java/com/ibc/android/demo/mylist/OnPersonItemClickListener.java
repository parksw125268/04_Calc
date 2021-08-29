package com.ibc.android.demo.mylist;

import android.view.View;

public interface OnPersonItemClickListener {
    //어떤 아이템이 클릭되면 요 함수가 호출되도록 할것이다.
    public void onItemClick(PersonAdapter.ViewHolder holder, View view,int position);
}

