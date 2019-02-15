package com.jofood.jombangan.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.login.widget.LoginButton;
import com.jofood.jombangan.Api.BaseApiService;
import com.jofood.jombangan.Api.UtilsApi;
import com.jofood.jombangan.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.txtusername)
    TextInputEditText txtusername;
    @BindView(R.id.username)
    TextInputLayout username;
    @BindView(R.id.txtpswd)
    TextInputEditText txtpswd;
    @BindView(R.id.pswd)
    TextInputLayout pswd;
    @BindView(R.id.txtemail)
    TextInputEditText txtemail;
    @BindView(R.id.email)
    TextInputLayout email;
    @BindView(R.id.txtnohp)
    TextInputEditText txtnohp;
    @BindView(R.id.nohp)
    TextInputLayout nohp;
    @BindView(R.id.btndaftar)
    Button btndaftar;
    @BindView(R.id.atau)
    TextView atau;
    @BindView(R.id.loginButton)
    LoginButton loginButton;
    @BindView(R.id.ask)
    TextView ask;
    @BindView(R.id.tvlogin)
    TextView tvlogin;
    ProgressDialog loading;

    Context mContext;
    BaseApiService mApiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService();
    }

    @OnClick({R.id.btndaftar, R.id.loginButton, R.id.tvlogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btndaftar:
                loading=ProgressDialog.show(mContext,null,"harap tunggu",true,false);
                requestRegister();
                break;
            case R.id.loginButton:
                break;
            case R.id.tvlogin:
                break;
        }
    }

    private void requestRegister() {
        mApiService.registerRequest(txtusername.getText().toString(),
                txtemail.getText().toString(),

                txtpswd.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            Log.i("debug", "onResponse: BERHASIL");
                            loading.dismiss();
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                if (jsonRESULTS.getString("error").equals("false")){
                                    Toast.makeText(mContext, "BERHASIL REGISTRASI", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(mContext, LoginActivity.class));
                                } else {
                                    String error_message = jsonRESULTS.getString("error_msg");
                                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Log.i("debug", "onResponse: GA BERHASIL");
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.getMessage());
                        Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    }

