package com.sunhao.myapplication2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.sunhao.myapplication2.MESSAGE";
    //private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mButton = findViewById(R.id.button_quit);
        //mButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ShowQuitDialog();
//            }
//        });

    }
    /**called when the user taps the Send Button */
    public void sendMessage (View view){
        //go to next activity
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText)findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    public void ShowQuitDialog(View view){
        //when you want to quit show a dialog for detecting miss touch
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(this);

        quitDialog.setMessage(this.getString(R.string.dialog_quit_question));
        quitDialog.setPositiveButton(this.getString(R.string.button_quit_positive), clickYes);
        quitDialog.setNegativeButton(this.getString(R.string.button_quit_negative), clickNo);

        AlertDialog quitDialogC = quitDialog.create();
        quitDialogC.show();

        //another method to implementing functions
//        AlertDialog.Builder builder = new AlertDialog.Builder(this)
//                .setMessage(this.getString(R.string.dialog_quit_question))
//                .setPositiveButton(this.getString(R.string.button_quit_positive), new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.dismiss();
//                    }
//                });
//        AlertDialog dialog = builder.create();
//        dialog.show();

    }

    //click yes -> quit app
    private  DialogInterface.OnClickListener clickYes = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            finish();
        }
    };

    //click no -> cancel
    private  DialogInterface.OnClickListener clickNo = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    };
}
