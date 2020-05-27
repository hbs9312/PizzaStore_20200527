package kr.co.tjoeun.pizzastore_20200527;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.bumptech.glide.Glide;

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

    }

    @Override
    public void setValues() {

        mStore = (Store) getIntent().getSerializableExtra("store");
        binding.nameTxt.setText(mStore.getName());
        binding.phoneNumTxt.setText(mStore.getTelNum());

        Glide.with(mContext).load(mStore.getLogoImgUrl()).into(binding.logoImg);

    }
}
