package ru.dimasokol.school.demosqlite;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ru.dimasokol.school.demosqlite.presenter.AddPetPresenter;
import ru.dimasokol.school.demosqlite.presenter.AddPetView;

public class AddPetActivity extends AppCompatActivity implements AddPetView {

    private AddPetPresenter mPresenter;
    private EditText mPetName, mPetAge;
    private Spinner mPetType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pet);

        if (savedInstanceState == null) {
            ((PetsApplication) getApplication()).createAddPetPresenter();
        }

        mPresenter = ((PetsApplication) getApplication()).getAddPetPresenter();

        mPetAge = findViewById(R.id.edit_pet_age);
        mPetName = findViewById(R.id.edit_pet_name);
        mPetType = findViewById(R.id.spinner_pet_type);

        findViewById(R.id.button_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.addPet(mPetName.getText().toString(),
                        mPetAge.getText().toString(),
                        mPetType.getSelectedItemPosition());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.attachView(this);
    }

    @Override
    protected void onStop() {
        mPresenter.detachView();
        super.onStop();
    }

    @Override
    public void onPetAdded() {
        finish();
    }

    @Override
    public void onError(int errorRes) {
        Toast.makeText(this, errorRes, Toast.LENGTH_SHORT).show();
    }
}
