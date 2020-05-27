package kr.co.tjoeun.pizzastore_20200527;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.security.Permission;
import java.util.List;

import kr.co.tjoeun.pizzastore_20200527.databinding.ActivityDetailBinding;
import kr.co.tjoeun.pizzastore_20200527.datas.Store;

public class DetailActivity extends BaseActivity {

    ActivityDetailBinding binding;

    Store mStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_detail);
        setupEvent();
        setValues();
    }

    @Override
    public void setupEvent() {


        binding.callBtn.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {

                PermissionListener pl = new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {

                        Uri myUri = Uri.parse(String.format("tel:%s",mStore.getTelNum()));
                        Intent intent = new Intent(Intent.ACTION_CALL,myUri);
                        startActivity(intent);

                    }

                    @Override
                    public void onPermissionDenied(List<String> deniedPermissions) {
                        Toast.makeText(mContext, "권한이 거부되어 통화가 불가능합니다.", Toast.LENGTH_SHORT).show();
                    }
                };

                TedPermission.with(mContext)
                        .setPermissionListener(pl)
                        .setDeniedMessage("거부하면 통화가 불가능함. \n 설정에서 권한을 켜주세요.")
                        .setPermissions(Manifest.permission.CALL_PHONE)
                        .check();

            }
        });
    }

    @Override
    public void setValues() {

        mStore = (Store) getIntent().getSerializableExtra("store");
        binding.nameTxt.setText(mStore.getName());
        binding.phoneNumTxt.setText(mStore.getTelNum());

        Glide.with(mContext).load(mStore.getLogoImgUrl()).into(binding.logoImg);

    }
}
