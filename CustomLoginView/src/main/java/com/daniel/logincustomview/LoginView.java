package com.daniel.logincustomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class LoginView extends LinearLayout {

    private Context mContext;
    private AttributeSet attrs;
    private int styleAttr;
    private View view;

    private TextView header;
    private EditText userNameEditText;
    private EditText passwordEditText;
    private Button submitButton;

    private String inputTextHint;
    private String passTextHint;
    private String buttonText;
    private String headerText;
    private int buttonTextColor;

    boolean isInputClicked;
    boolean isPassClicked;

    public LoginView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public LoginView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        this.attrs = attrs;
        initView();
    }

    public LoginView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        this.attrs = attrs;
        this.styleAttr = defStyleAttr;
        initView();
    }

    private void initView(){
        this.view = this;
        inflate(mContext, R.layout.login_view_layout,this);

        TypedArray arr = mContext.obtainStyledAttributes(attrs,R.styleable.LoginView,styleAttr,0);
        inputTextHint = arr.getString(R.styleable.LoginView_inputTextHint);
        passTextHint = arr.getString(R.styleable.LoginView_passTextHint);
        buttonText = arr.getString(R.styleable.LoginView_buttonText);
        headerText = arr.getString(R.styleable.LoginView_headerText);
        buttonTextColor = arr.getColor(R.styleable.LoginView_buttonTextColor,0);

        header = view.findViewById(R.id.login_header);
        userNameEditText = view.findViewById(R.id.login_user_name);
        passwordEditText = view.findViewById(R.id.login_password);
        submitButton = view.findViewById(R.id.login_submit);

        if(inputTextHint != null)
            setInputTextHint(inputTextHint);
        if(passTextHint != null)
            setPassTextHint(passTextHint);
        if(buttonText != null)
            setButtonText(buttonText);
        if(headerText != null)
            setHeaderText(headerText);
        if(buttonTextColor != 0)
            setButtonColor(buttonTextColor);


        submitButton.setBackground(getResources().getDrawable(R.drawable.custom_submit_button,null));


        isInputClicked = false;
        userNameEditText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.user_name_avatar,null),null,null,null);
        userNameEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if(isInputClicked){
                userNameEditText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.user_name_avatar,null),null,null,null);
                isInputClicked = false;
            }
            else {
                userNameEditText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.user_name_avatar_focused,null),null,null,null);
                isInputClicked = true;
            }
        });

        isPassClicked = false;
        passwordEditText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.password_avatar,null),null,null,null);
        passwordEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if(isPassClicked){
                passwordEditText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.password_avatar,null),null,null,null);
                isPassClicked = false;
            }
            else {
                passwordEditText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.password_avatar_focused,null),null,null,null);
                isPassClicked = true;
            }
        });


        arr.recycle();
    }

    private void setButtonColor(int color) {
        submitButton.setTextColor(color);
    }

    public void setInputTextHint(String txt){
        userNameEditText.setHint(txt);
    }

    public void setPassTextHint(String txt){
        passwordEditText.setHint(txt);
    }

    public void setButtonText(String txt){
        submitButton.setText(txt);
    }

    public void setButtonListener(OnClickListener listener){
        submitButton.setOnClickListener(listener);
    }
    public void setHeaderText(String txt) {
        header.setText(txt);
    }

    public String getInputTextValue(){
        return userNameEditText.getText().toString();
    }

    public String getPassTextValue(){
        return passwordEditText.getText().toString();
    }

}
