package com.example.thamer.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

public class TButton extends android.widget.Button {
    private int status;

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public TButton(Context context) {
        super(context);
        status=0;
    }

    public TButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
